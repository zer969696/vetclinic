package su.vistar.vetclinic.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import su.vistar.vetclinic.security.converter.UserRoleConverter;
import su.vistar.vetclinic.security.model.CustomUser;
import su.vistar.vetclinic.security.dao.CustomUserDao;
import su.vistar.vetclinic.service.ClientService;
import su.vistar.vetclinic.service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


class TokenAuthenticationService {

    private UserRoleConverter userRoleConverter = new UserRoleConverter();
    private ClientService clientService;
    private EmployeeService employeeService;

    private long EXPIRATIONTIME = 1000 * 60 * 60 * 24 * 10; // 10 days

    private String secret = "ThisIsASecret";
    private String tokenPrefix = "Bearer";
    private String headerString = "Authorization";

    public TokenAuthenticationService(ClientService clientService, EmployeeService employeeService) {
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    void addAuthentication(HttpServletResponse response, String login) {
        CustomUser customUser = new CustomUserDao(clientService, employeeService).getCustomUser(login);
        String userRole = userRoleConverter.toString(userRoleConverter.convertClientRolesArray(customUser));
        // We generate a token now.
        String JWT = Jwts.builder()
                .setSubject(login)
                .setIssuer(userRole)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        response.addHeader(headerString,tokenPrefix + " " + JWT);
    }

    Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(headerString);

        if (token != null) {
            // parse the token.
            String username = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            String role = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getIssuer();

            if (username != null) {
                return new AuthenticatedUser(username, role);
            }
        }

        return null;
    }
}

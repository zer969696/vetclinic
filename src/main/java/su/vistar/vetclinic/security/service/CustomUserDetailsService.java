package su.vistar.vetclinic.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import su.vistar.vetclinic.model.Role;
import su.vistar.vetclinic.security.dao.CustomUserDao;
import su.vistar.vetclinic.security.model.CustomUser;
import su.vistar.vetclinic.service.ClientService;
import su.vistar.vetclinic.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy Evzerov on 16.03.17.
 * VIstar
 */

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        CustomUser customUser = new CustomUserDao(clientService, employeeService).getCustomUser(login);

        if (customUser == null) {
            throw new UsernameNotFoundException("no such user");
        }

        return new org.springframework.security.core.userdetails.User(
                customUser.getLogin(),
                customUser.getPassword(),
                true,
                true,
                true,
                true,
                getGrantedAuthorities(customUser)
        );
    }

    private List<GrantedAuthority> getGrantedAuthorities(CustomUser customUser){
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(Role role : customUser.getRoles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getDescription()));
        }

        return authorities;
    }
}

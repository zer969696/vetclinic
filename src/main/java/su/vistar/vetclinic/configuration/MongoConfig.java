package su.vistar.vetclinic.configuration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

/**
 * Created by Evgeniy Evzerov on 22.03.17.
 * VIstar
 */
@Configuration
@PropertySource("classpath:application.properties")
//@ComponentScan("su.vistar.vetclinic.configuration")
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    private Environment environment;

    @Override
    protected String getDatabaseName() {
        return environment.getProperty("mongo.database");
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(
                environment.getProperty("mongo.host"),
                Integer.valueOf(environment.getProperty("mongo.port"))
        );
    }

    @SuppressWarnings("deprecation")
    @Override
    protected String getMappingBasePackage() {
        return "su.vistar.vetclinic.mongo.model";
    }

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
    }

    @Override
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), getDatabaseName());
    }
}

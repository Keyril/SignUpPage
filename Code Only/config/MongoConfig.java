package com.app.crud.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
        import com.mongodb.ServerAddress;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.data.mongodb.MongoDbFactory;
        import org.springframework.data.mongodb.core.MongoTemplate;
        import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
        import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

        import java.util.Collections;


/**
 * Mongo configuration class for building mongo bean
 */
@Configuration
@EnableMongoRepositories
public class MongoConfig {

    @Bean
    public MongoClient mongo() {
        return new MongoClient(
                new ServerAddress("192.168.33.10", 27017),
                Collections.singletonList(
                        MongoCredential.createCredential(
                                "admin",
                                "devdb",
                                "12345".toCharArray()
                        )
                )
        );
    }

    @Bean
    public MongoDbFactory mongoDbFactory(MongoClient mongoClient) throws Exception {
        return new SimpleMongoDbFactory(mongoClient, "devdb");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) throws Exception {
        return new MongoTemplate(mongoDbFactory);
    }
}

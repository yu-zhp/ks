package org.ks.kslog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

/**
 * MongoDB事务配置
 */
@Configuration
public class TransactionalConfig {

    @Bean
    MongoTransactionManager transactionManager (MongoDbFactory factory){return new MongoTransactionManager(factory);}
}
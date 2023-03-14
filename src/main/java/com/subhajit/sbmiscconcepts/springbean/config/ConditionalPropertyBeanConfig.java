package com.subhajit.sbmiscconcepts.springbean.config;

import com.subhajit.sbmiscconcepts.springbean.conditional.bean.MySqlDatabase;
import com.subhajit.sbmiscconcepts.springbean.conditional.bean.OracleDatabase;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalPropertyBeanConfig {

//    @Bean("oracleDatabaseBean")
//    @ConditionalOnProperty(prefix="database.conditional", name = "flag", havingValue = "oracle")
//    public ConditionalPropertyBeanInterface connectOracleDatabase(){
//        return new OracleDatabase();
//    }
//
//    @Bean("mySqlDatabaseBean")
//    @ConditionalOnProperty(prefix="database.conditional", name = "flag", havingValue = "mysql")
//    public ConditionalPropertyBeanInterface connectMySqlDatabase(){
//        return new MySqlDatabase();
//    }
}

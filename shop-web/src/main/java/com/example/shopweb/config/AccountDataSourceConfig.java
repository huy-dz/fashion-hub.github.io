//package com.example.shopweb.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories(basePackages = {"${spring.data.jpa.repository.packages}"})
//public class AccountDataSourceConfig {
//
//    @Primary
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource appDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//}

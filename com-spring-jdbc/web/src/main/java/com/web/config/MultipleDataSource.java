package com.web.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 多数据源配置
 */
@Configuration
public class MultipleDataSource {
    @Bean
    @Primary
    public DataSource masterDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.username("root")
                .driverClassName("").build();
        return dataSource;
    }

    @Bean
    public DataSource salveDataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        DataSource dataSource = dataSourceBuilder.username("root")
                .driverClassName("").build();
        return dataSource;
    }
}

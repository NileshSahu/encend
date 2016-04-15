package com.personal.training.spring.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by Nilesh on 4/15/2016.
 */
@Configuration
public class DBConfig {

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase dataBase = builder.setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
                //.addScript("schema.sql")
                //.addScript("data.sql")
                .build();
        return dataBase;
    }

}

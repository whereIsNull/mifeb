package com.mifeb.meetupmodel.service.city;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan("com.mifeb.meetupmodel")
@EnableJpaRepositories("com.mifeb.meetupmodel")
@PropertySource("application.properties")
@ComponentScan({"com.mifeb.meetupmodel"})
@EnableTransactionManagement
public class HsqlDBJpaConfig {

}

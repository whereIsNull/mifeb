package com.mifeb.meetupmodel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@EntityScan("com.mifeb.meetupmodel")
@EnableJpaRepositories("com.mifeb.meetupmodel")
@ComponentScan({"com.mifeb.meetupmodel"})
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

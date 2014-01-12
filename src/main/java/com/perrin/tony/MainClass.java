package com.perrin.tony;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@ComponentScan
@EnableAutoConfiguration
public class MainClass {
    public static void main( String[] args ) {
        SpringApplication.run(MainClass.class, args);
    }
}

package com.javainAction.angular_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({"com.controller", "com.model"})
public class App 
{
    public static void main( String[] args )
    
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "App started...!" );
    }
}

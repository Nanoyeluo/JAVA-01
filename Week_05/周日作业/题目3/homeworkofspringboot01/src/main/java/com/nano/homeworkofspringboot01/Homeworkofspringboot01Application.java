package com.nano.homeworkofspringboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Homeworkofspringboot01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Homeworkofspringboot01Application.class, args);
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }

}

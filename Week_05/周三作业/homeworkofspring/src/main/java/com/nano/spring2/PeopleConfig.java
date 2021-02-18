package com.nano.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nano
 * @ClassName PeopleConfig
 * @Description TODO
 * @Date 2021/2/12 22:11
 * @Version 1.0
 **/
@Configuration
public class PeopleConfig {
    @Bean
    public People newPeople() {
        return new People();
    }

}

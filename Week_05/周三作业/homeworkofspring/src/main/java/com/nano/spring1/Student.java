package com.nano.spring1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Nano
 * @ClassName Student
 * @Description TODO
 * @Date 2021/2/12 22:03
 * @Version 1.0
 **/
@Component
public class Student {

    @Value("小明")
    private String name;

    public void play(){
        System.out.println(name);
    }
}

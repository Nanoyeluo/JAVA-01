package com.nano.spring2;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Nano
 * @ClassName Peopeo
 * @Description TODO
 * @Date 2021/2/12 22:09
 * @Version 1.0
 **/
public class People {
    @Value("我是个大人物")
    private String name;

    public void show() {
        System.out.println(name);
    }
}

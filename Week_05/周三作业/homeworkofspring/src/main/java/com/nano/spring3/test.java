package com.nano.spring3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Nano
 * @ClassName test
 * @Description TODO
 * @Date 2021/2/12 22:38
 * @Version 1.0
 **/
public class test {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/ConstructorArgReferenceTest-context.xml");
        // 通过别名 xiaomage-user 获取曾用名 user 的 bean
        Boss boss = beanFactory.getBean("boss", Boss.class);
        boss.play();
    }
}

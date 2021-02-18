package com.nano.spring3;

/**
 * @author Nano
 * @ClassName Boss
 * @Description TODO
 * @Date 2021/2/12 22:40
 * @Version 1.0
 **/
public class Boss {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play(){
        System.out.println(name);

    }
}

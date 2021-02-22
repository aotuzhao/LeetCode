package com.demo.test;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/21 19:40
 */
public class Test {

    public static void main(String[] args) {

        List<Demo> list = new ArrayList<>();
        list.add(new Demo("1","abc"));
        list.add(new Demo("2","-"));
        list.add(new Demo("3","gr"));
        list.add(new Demo("4","-"));

        list.forEach(e->{
            if("-".equalsIgnoreCase(e.getCode())){
                e.setCode(e.getName());
            }
        });
        list.forEach(System.out::println);

    }
}
class Demo{
    public String name;
    public String code;

    public Demo(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

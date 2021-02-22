package com.demo.test;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/21 19:40
 */
public class GCTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"--start");

        int i =0;
        try {
            List<String> list = new ArrayList<>();
            String a = "test";
            while (true){
                list.add(a);
                a = a+a;
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(i);
            System.out.println(e.getMessage());
        }



        System.out.println(Thread.currentThread().getName()+"--end");
    }
}

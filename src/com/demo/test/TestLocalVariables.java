package com.demo.test;

import java.util.concurrent.TimeUnit;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/24 19:43
 */
public class TestLocalVariables {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"--start");
        try {
            TimeUnit.SECONDS.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"--end");
    }

    public void add1(){
        int i = 9;
        int s = i++;
        int n = ++i;

    }

    public TestLocalVariables(){
        int m = 1;
    }

    public static void testS(){
        int mm = 2;
    }

    public int test1(int i){
        int s = i+1;
        int m = s*2;
        return test2(m);
    }

    public int test2(int i){
        int s = i+1;
        int m = s*2;
        return test3(s);
    }

    public int test3(int i){
        int s = i+1;
        int m = s*2;
        return test4(m);
    }

    public int test4(int i){
        int s = i+1;
        int m = s*2;
        return i+1;
    }


}

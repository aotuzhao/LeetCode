package com.demo.test;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/14 16:31
 */
public class Son extends Father{
    public int i=m1();

    public static int j = m2();

    {
        System.out.println("d");
    }

    static{
        System.out.println("e");
    }

    public Son(){
        System.out.println("a");
    }

    public static int m2(){
        System.out.println("c");
        return 3;
    }


    @Override
    public int m1(){
        System.out.println("b");
        return 2;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        Son s2 = new Son();
    }
}

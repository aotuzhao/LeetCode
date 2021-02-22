package com.demo.test;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/14 16:29
 */
public class Father {
    public int i=m1();

    public static int j = m2();

    {
        System.out.println(4);
    }

    static{
        System.out.println(5);
    }

    public Father(){
        System.out.println(1);
    }

    public static int m2(){
        System.out.println(3);
        return 3;
    }


    public int m1(){
        System.out.println(j);
        System.out.println(2);
        return 2;
    }

}

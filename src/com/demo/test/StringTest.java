package com.demo.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/21 14:34
 */
public class StringTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger= new AtomicInteger(0);
        System.out.println(atomicInteger.get());
        int andIncrement = atomicInteger.getAndIncrement();
        System.out.println(andIncrement);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(1,3));
        System.out.println(atomicInteger.get());


    }
}

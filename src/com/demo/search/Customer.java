package com.demo.search;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2021/1/19 13:30
 */
public class Customer {
    int id =1001;
    String name;
    Account account;

    {
        name="张三";
    }

    public Customer() {
        account = new Account();
    }
}
class Account{}

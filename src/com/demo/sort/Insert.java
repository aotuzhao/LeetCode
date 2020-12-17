package com.demo.sort;

import java.util.Arrays;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/17 20:09
 */
public class Insert {

    public static void main(String[] args) {
        int[] arr = {101, 34, 9, 1};


        for (int i = 1; i <= arr.length - 1; i++) {
            int temp = arr[i];
            int index = i - 1;
            while (index >= 0 && temp < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index+1] = temp;

        }



        System.out.println(Arrays.toString(arr));

    }

}

package com.demo.sort;

import java.util.Arrays;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/16 19:48
 */
public class Choose {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {

        for(int i=0;i< arr.length-1;i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i+1;j<arr.length-1;j++){
                if(min>arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }


    }

}

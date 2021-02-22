package com.demo.sort;

import java.util.Arrays;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/19 9:48
 */
public class Shell {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};

        sort(arr);


//        int temp = 0;
//        int index = arr.length/2;
//        while (index!=0){
//            for(int i = index;i<arr.length;i++){
//                for(int j = i - index;j<arr.length&&j>=0;j-=index){
//
//                    if(arr[j]>arr[j+index]){
//                        temp = arr[j];
//                        arr[j] = arr[j+index];
//                        arr[j+index] =temp;
//                    }
//                }
//            }
//            index = index/2;
//        }
        System.out.println(Arrays.toString(arr));
    }

    public  static void sort(int[] arr){

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }
}

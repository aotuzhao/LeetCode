package com.demo.sort;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/16 15:05
 */
public class Bubbling {
        public static void main(String[] args) {
            int[] arr = {3, 9, -1, 10, -2, 12, 8, 9};
            boolean tag = true;
            for (int j = 1; j < arr.length && tag; j++) {
                tag = false;
                int temp;
                for (int i = 0; i < arr.length - j; i++) {
                    if (arr[i] > arr[i + 1]) {
                        tag = true;
                        temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }
        }


}

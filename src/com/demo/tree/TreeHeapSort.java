package com.demo.tree;

import java.util.Arrays;

/**
 * @Description: 堆排序
 * 大顶堆 升序
 * 小顶堆 降序
 * @Author zhaoxuezhao
 * @Date 2020/12/10 14:33
 */
public class TreeHeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序!!");



        //完成我们最终代码
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for(int i = arr.length / 2 -1; i >=0; i--) {
            adjustHeap(arr, i, arr.length);
        }

		/*
		 * 2).将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
　　			3).重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
		 */
        for(int j = arr.length-1;j >0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        //System.out.println("数组=" + Arrays.toString(arr));

    }

    /**
     * 构造大顶堆
     * @param arr 数组
     * @param i 非叶子结点
     * @param length 参与调整长度
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k = 2*i+1;k<length;k=k*2+1){
            if(k+1<length && arr[k+1]>arr[k]){
                k++;
            }
            if(arr[k]>temp){
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;
    }
}

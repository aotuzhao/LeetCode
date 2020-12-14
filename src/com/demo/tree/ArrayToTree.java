package com.demo.tree;

/**
 * @Description: 完全二叉树 数组转回 完全二叉树
 *    第n个元素的左子节点为  2 * n + 1
 *    第n个元素的右子节点为  2 * n + 2
 *    第n个元素的父节点为  (n-1) / 2
 * @Author zhaoxuezhao
 * @Date 2020/12/9 16:55
 */
public class ArrayToTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        BinaryTreeNode treeNode = toTree(arr, 0);
        System.out.println(treeNode);
    }

    public  static BinaryTreeNode toTree(int[] arr,int index){
        BinaryTreeNode treeNode = new BinaryTreeNode(arr[index],"tree");
        Integer leftIndex = 2*index+1<=arr.length-1?2*index+1:null;
        Integer rightIndex = 2*index+2<=arr.length-1?2*index+2:null;
        if (leftIndex!=null){
            treeNode.setLeftNode(toTree(arr,leftIndex));
        }
        if (rightIndex!=null){
            treeNode.setRightNode(toTree(arr,rightIndex));
        }
        return treeNode;
    }


}

package com.demo.hot100.com.demo.tree;

import java.util.Objects;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/9 14:58
 */

public class BinaryTreeNode {
    private int no;
    private String name;
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;

    public BinaryTreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int no, String name, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.no = no;
        this.name = name;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }
}

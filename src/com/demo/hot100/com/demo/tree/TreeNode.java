package com.demo.hot100.com.demo.tree;

import java.util.Objects;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/9 14:58
 */

public class TreeNode {
    private int no;
    private String name;
    private TreeNode next;

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return no == treeNode.no &&
                name.equals(treeNode.name) &&
                next.equals(treeNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, next);
    }

    public TreeNode() {
    }

    public TreeNode(int no, String name, TreeNode next) {
        this.no = no;
        this.name = name;
        this.next = next;
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

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }
}

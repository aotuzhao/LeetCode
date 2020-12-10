package com.demo.hot100.com.demo.tree;

/**
 * @Description: desc
 * @Author zhaoxuezhao
 * @Date 2020/12/9 14:57
 */
public class BinaryTree1 {
    public static void main(String[] args) {
        BinaryTreeNode left1 = new BinaryTreeNode(2,"zhanngsan",new BinaryTreeNode(1,"李四"),null);
        BinaryTreeNode right1 = new BinaryTreeNode(4,"zhanngsan");
        BinaryTreeNode root  = new BinaryTreeNode(3,"wangwu",left1,right1);
//        preRoot(root);
//        System.out.println("--------------");
//        midRoot(root);
//        System.out.println("--------------");
//        postRoot(root);
        BinaryTreeNode binaryTreeNode = preRootSearch(root, 1);
        System.out.println(binaryTreeNode.getNo());
        BinaryTreeNode binaryTreeNode2 = preRootSearch(root, 1);
        System.out.println(binaryTreeNode2.getNo());
        BinaryTreeNode binaryTreeNode3 = preRootSearch(root, 1);
        System.out.println(binaryTreeNode3.getNo());
    }

    /**
     * 先根
     * @param root
     */
    public  static void preRoot(BinaryTreeNode root){
        System.out.println(root.getNo());
        if (root.getLeftNode()!=null){
            preRoot(root.getLeftNode());
        }
        if (root.getRightNode()!=null){
            preRoot(root.getRightNode());
        }
    }

    /**
     * 中跟
     * @param root
     */
    public  static void midRoot(BinaryTreeNode root){
        if (root.getLeftNode()!=null){
            midRoot(root.getLeftNode());
        }
        System.out.println(root.getNo());
        if (root.getRightNode()!=null){
            midRoot(root.getRightNode());
        }
    }

    /**
     * 后跟
     * @param root
     */
    public  static void postRoot(BinaryTreeNode root){
        if (root.getLeftNode()!=null){
            postRoot(root.getLeftNode());
        }
        if (root.getRightNode()!=null){
            postRoot(root.getRightNode());
        }
        System.out.println(root.getNo());
    }


    /**
     * 先根查找
     * @param root
     */
    public  static BinaryTreeNode preRootSearch(BinaryTreeNode root,int no){
        System.out.println("preRootSearch");
        if(null!=root&&no == root.getNo()){
            return root;
        }
        BinaryTreeNode res = null;
        if (root.getLeftNode()!=null){
            res = preRootSearch(root.getLeftNode(),no);
        }
        if (null!=res){
            return res;
        }
        if (root.getRightNode()!=null){
            res= preRootSearch(root.getRightNode(),no);
        }
        return res;
    }

    /**
     * 中根查找
     * @param root
     */
    public  static BinaryTreeNode midRootSearch(BinaryTreeNode root,int no){
        BinaryTreeNode res = null;
        if (root.getLeftNode()!=null){
            res = midRootSearch(root.getLeftNode(),no);
        }
        if (null!=res){
            return res;
        }
        System.out.println("midRootSearch");
        if(null!=root&&no == root.getNo()){
            return root;
        }
        if (root.getRightNode()!=null){
            res= midRootSearch(root.getRightNode(),no);
        }
        return res;
    }

    /**
     * 后根查找
     * @param root
     */
    public  static BinaryTreeNode postRootSearch(BinaryTreeNode root,int no){
        BinaryTreeNode res = null;
        if (root.getLeftNode()!=null){
            res = postRootSearch(root.getLeftNode(),no);
        }
        if (null!=res){
            return res;
        }
        if (root.getRightNode()!=null){
            res= postRootSearch(root.getRightNode(),no);
        }
        if (null!=res){
            return res;
        }
        System.out.println("preRootSearch");
        if(null!=root&&no == root.getNo()){
            return root;
        }
        return res;
    }
}

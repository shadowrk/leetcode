package codinginterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateBinaryTree {
    public TreeNode create(List<Integer> preList, List<Integer> midList){
        if(preList.isEmpty() || midList.isEmpty())
            return null;
        int value = preList.get(0);

        TreeNode root = new TreeNode(value);
        int len = midList.indexOf(value);
        root.setLeft(create(preList.subList(1, len+1), midList.subList(0, len)));
        root.setRight(create(preList.subList(len+1, preList.size()), midList.subList(len+1, midList.size())));
        return root;
    }

    public void print(TreeNode root){
        if(root == null){
            System.out.println("根节点为null");
            return;
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.println(temp.getValue());
            if(temp.getLeft() != null){
                queue.offer(temp.getLeft());
            }
            if(temp.getRight() != null){
                queue.offer(temp.getRight());
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> preList = new ArrayList<Integer>() {
            {
                add(1);


            }
        };

        List<Integer> midList = new ArrayList<Integer>(){
            {
                add(1);

            }
        };
//        List<Integer> preList = new ArrayList<Integer>() {
//            {
//                add(1);
//                add(2);
//                add(4);
//                add(7);
//                add(3);
//                add(5);
//                add(6);
//                add(8);
//
//            }
//        };
//
//        List<Integer> midList = new ArrayList<Integer>(){
//            {
//                add(4);
//                add(7);
//                add(2);
//                add(1);
//                add(5);
//                add(3);
//                add(8);
//                add(6);
//
//            }
//        };
        CreateBinaryTree demo = new CreateBinaryTree();
        TreeNode root = demo.create(preList, midList);
        demo.print(root);
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

package codinginterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.BiConsumer;

public class CreateBinaryTree {
    public Node create(List<Integer> preList, List<Integer> midList){
        if(preList.isEmpty() || midList.isEmpty())
            return null;
        int value = preList.get(0);

        Node root = new Node(value);
        int len = midList.indexOf(value);
        root.setLeft(create(preList.subList(1, len+1), midList.subList(0, len)));
        root.setRight(create(preList.subList(len+1, preList.size()), midList.subList(len+1, midList.size())));
        return root;
    }

    public void print(Node root){
        if(root == null){
            System.out.println("根节点为null");
            return;
        }
        Node node = root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
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
        Node root = demo.create(preList, midList);
        demo.print(root);
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

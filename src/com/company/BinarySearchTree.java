package com.company;

public class BinarySearchTree {

    public static Node insert(Node root,int data){
        if(root == null){
            return new Node(data);
        }
        else{
            Node current;
            if(data <= root.data){
                current = insert(root.left, data);
                root.left = current;
            }
            else{
                current = insert(root.right, data);
                root.right = current;
            }
            return root;
        }
    }

    public static int getHeight(Node root){
        if (root == null) {
            return -1;
        }
        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;
        return Math.max(left, right);
    }

}

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

/*
    Node root = null;
    root = BinarySearchTree.insert(root, 3);

    BinarySearchTree.insert(root,5);
    BinarySearchTree.insert(root,2);
    BinarySearchTree.insert(root,1);
    BinarySearchTree.insert(root,4);
    BinarySearchTree.insert(root,6);
    BinarySearchTree.insert(root,7);

   System.out.println(BinarySearchTree.getHeight(root)); //3
*/

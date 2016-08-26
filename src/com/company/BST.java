package com.company;

/**
 * Created by Esa on 8/26/2016.
 */
public class BST {

    public Node root;

    public BST()
    {
        this.root = null;
    }
    public BST(Node root) {
        this.root = root;
    }//constructor


    public void addNode(int value, Node root) {
        if (this.root == null) {
            this.root = new Node(value);
        } else {
            if (root == null) {
                root = new Node(value);
            } else if (value < root.data) {
                if (root.left == null)
                    root.left = new Node(value);
                else
                    addNode(value, root.left);
            } else {
                if (root.right == null)
                    root.right = new Node(value);
                else
                    addNode(value, root.right);
            }//else
        }//else
    }//addNode

    public void removeNode(int value) {

    }




    //printing methods
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data + " ");
        }
    }


}

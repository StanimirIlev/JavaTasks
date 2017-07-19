package com.stanimiriliev.chaptertwo.homogeneoustree;

/**
 * Binary Ordered Tree, Homogeneous Tree
 * @author  Stanimir
 * @since 18.6.2017
 */
public class Tree {

    private Node root;

    /**
     * Constructor for the new instance of this class
     */
    public Tree(int root) {
        this.root = new Node(root);
    }

    /**
     * Finds if the tree contains this element
     * @param element -> The element to search for
     * @return true if the element is found and false if it is not
     */
    public boolean contains(int element) {
        return this.root.contains(element);
    }
    /**
     * Adds new element to the tree
     * If the value is already in the tree, it will be not added
     * If this is the first add, the value is the root of the tree
     * @param value -> The element which would be added in the tree
     */
    public void add(int value) {
        this.root.add(value);
    }
    /**
     * Prints the elements of the tree
     * First the root of the tree, then left nodes and right nodes
     */
    public void printElements() {
        this.root.printElements();
    }
    /**
     * Inner class for Tree
     */
    class Node {
        public final int value;
        public Node left;
        public Node right;

        /**
         * Constructor for new instances of this class
         */
        public Node(int value){
            this.value = value;
            this.left = this.right = null;
        }

        /**
         * Finds if the tree contains this element
         * @param element -> The element to search for
         * @return true if the element is found and false if it is not
         */
        public boolean contains(int element) {
            if(element == this.value)
                return true;
            else if(element < this.value) {
                if(this.left != null)
                    return this.left.contains(element);
                else
                    return false;
            }
            else {
                if(this.right != null)
                    return this.right.contains(element);
                else
                    return false;
            }
        }
        /**
         * Adds new element to the tree
         * If the value is already in the tree, it will be not added
         * If this is the first add, the value is the root of the tree
         * @param value -> The element which would be added in the tree
         */
        public void add(int value) {
            if(contains(value))
                return;
            if(value < this.value) {
                if (this.left == null)
                    this.left = new Node(value);
                else
                    this.left.add(value);
            }
            else {
                if (this.right == null)
                    this.right = new Node(value);
                else
                    this.right.add(value);
            }
        }
        /**
         * Prints the elements of the tree
         * First the root of the tree, then left nodes and right nodes
         */
        public void printElements() {
            System.out.println(this.value);
            if(this.left != null)
                this.left.printElements();
            if(this.right != null)
                this.right.printElements();
        }
    }
}

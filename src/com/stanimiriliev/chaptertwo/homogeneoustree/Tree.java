package com.stanimiriliev.chaptertwo.homogeneoustree;

/**
 * Binary Ordered Tree, Homogeneous Tree
 * @author  Stanimir
 * @since 18.6.2017
 */
public class Tree {
    private int value;
    private Tree left, right;
    private boolean firstAdd = true;

    /**
     * Constructor for the new instance of this class
     */
    public Tree() {
        this.left = this.right = null;
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
        if(firstAdd){
            this.value = value;
            this.firstAdd = false;
        }
        else if(value < this.value) {
            if (this.left == null) {
                this.left = new Tree();
                this.left.value = value;
            }
            else
                this.left.add(value);
        }
        else {
            if (this.right == null) {
                this.right = new Tree();
                this.right.value = value;
            }
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
}

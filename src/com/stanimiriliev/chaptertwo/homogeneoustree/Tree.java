package com.stanimiriliev.chaptertwo.homogeneoustree;

/**
 * Binary tree
 * Created by Stanimir Iliev on 18.6.2017 y..
 */
public class Tree {
    private int value;// root and the value of the notes
    private Tree left,// elements less than root
            right;// elements greater than root
    private boolean firstAdd = true;// When function add is called for the first time
    // the value goes to the root of the tree

    /**
     * Creates new instance of this class
     */
    public Tree() {
        this.left = this.right = null;//  left and right nodes are with value null
        //  to know when we reach the end of the tree
    }

    /**
     * Adds new element to the tree
     * @param value -> The element which would be added in the tree
     */
    public void add(int value) {
        if(contains(value))// If the value is already in the tree do not add it
            return;
        if(firstAdd){// If this is the first add, the value is the root of the tree
            this.value = value;
            this.firstAdd = false;// make firstAdd false because the tree could has only one root
        }
        else if(value < this.value) {// If the value is less than root go to left node
            if (this.left == null) {// if the left node is null then it is the bottom
                // of the tree and we create new instance of this class for the
                // left node
                this.left = new Tree();
                this.left.value = value;// Set value in the left node
            }
            else
                this.left.add(value);// recursively call this function to reach the
            // bottom of the tree
        }
        else {// If the value is greater than root go to right node
            if (this.right == null) {// if the right node is null then it is the bottom
                // of the tree and we create new instance of this class for the
                // right node
                this.right = new Tree();
                this.right.value = value;// Set value in the right node
            }
            else
                this.right.add(value);// recursively call this function to reach the
            // bottom of the tree
        }
    }

    /**
     * Prints the elements of the tree
     * First the root of the tree, then left nodes and right nodes
     */
    public void printElements() {
        System.out.println(this.value);// Prints the root element
        if(this.left != null)// If bottom of the tree is not reached print left node
            this.left.printElements();
        if(this.right != null)// If bottom of the tree is not reached print right node
            this.right.printElements();
    }

    /**
     * Finds if the tree contains this element
     * @param element -> The element to search for
     * @return true if the element is found and false if not
     */
    public boolean contains(int element) {
        if(element == this.value)// If the root element is the searched element return true
            return true;
        else if(element < this.value) {// If the searched element is less than root search in left node
            if(this.left != null) {// If the program is not reached the tree bottom recursively call this function with
                // left sub node
                return this.left.contains(element);
            }
            else// If the bottom is reached and the element is not found then it is not in the tree
                return false;
        }
        else {// If the searched element is greater than root search in right node
            if(this.right != null) {// If the program is not reached the tree bottom recursively call this function with
                // right sub node
                return this.right.contains(element);
            }
            else// If the bottom is reached and the element is not found then it is not in the tree
                return false;
        }
    }
}

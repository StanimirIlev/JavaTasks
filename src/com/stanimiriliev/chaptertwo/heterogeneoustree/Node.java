package com.stanimiriliev.chaptertwo.heterogeneoustree;

/**
 * Created by Stanimir Iliev on 22.6.2017 y..
 */
import java.util.ArrayList;
import java.util.List;

public class Node<Object> {

    private static int ids = 0;// Static identification number that increases with every instance of this class
    private Object value;// Value of the current instance
    private Node<Object> parent;// Creates instance of this class which is parent of the current instance of this class
    private List<Node<Object>> children = new ArrayList<>();// Creates a list of instances of this class which are children
    // of the current instance of this class
    private boolean hasChildren;// Shows if the current instance of this class has any children
    private boolean hasParent;// Shows if the current instance of this class has parent
    private int id;// Identification number for current instance

    /**
     * First constructor which creates instance of this class with specific value
     * @param value -> value of the new instance
     */
    public Node(Object value){
        this.value = value;// Sets value of the current instance of this class
        this.id = ids++;// Sets id of the current instance and increases the static ids after that
        this.hasParent = false;// Shows that current instance of this class has no parent
        this.hasChildren = false;// Shows that current instance of this class has no children
    }

    /**
     * Second constructor which creates instance of this class with specific value and links it to specific parent
     * @param value -> value of the new instance
     * @param parent -> parent of the new instance
     */
    public Node(Object value, Node<Object> parent){
        this.value = value;// Sets value of the current instance of this class
        this.id = ids++;// Sets id of the current instance and increases the static ids after that
        this.parent = parent;// Links the current instance of this class to the specific parent
        this.hasChildren = false;// Shows that current instance of this class has no children
        this.hasParent = true;// Shows that current instance of this class now has parent
        Node<Object> child = new Node<>(value);// Creates new instance of this class
        parent.addChild(this);// Add the new instance to the parent of the current instance as child
    }

    /**
     * Gets the identification number of the current instance
     * @return the identification number of the current instance
     */
    public int getId(){
        return this.id;
    }

    /**
     * Gets the list with children of the current instance
     * @return the list with children of the current instance
     */
    public List<Node<Object>> getChildren(){
        return this.children;
    }

    /**
     * Gets the children count of the current instance
     * @return the count of the children of the current instance
     */
    public int childrenCount(){
        return this.children.size();
    }

    /**
     * Links a parent to the current instance
     * @param parent -> the parent which is being linked to the current instance
     */
    public void setParent(Node<Object> parent){
        parent.addChild(this);// Add current instance to the parent
        this.parent = parent;// Links the parent to the current instance
        this.hasParent = true;// Shows that the current instance has parent
    }

    /**
     * Removes the parent of the current instance
     */
    public void removeParent(){
        this.parent.children.remove(this);// Remove this instance of the children list of its parent
        if(this.parent.childrenCount() == 0)// If the parent of the current instance has no children
            this.parent.hasChildren = false;// Shows that the parent has no children
        this.parent = null;// Unlink the parent from the current instance
        this.hasParent = false;// Shows that the current instance has no parent
    }

    /**
     * Adds child by value to the current instance
     * @param value -> The value of the new child
     */
    public void addChild(Object value){
        Node<Object> child = new Node<>(value);// Creates new instance of this class with the specific value
        child.parent = this;// Link the current instance as parent to the new instance
        child.hasParent = true;// Shows that the new instance has parent
        this.children.add(child);// Add the new instance to the list of children of the current instance
        this.hasChildren = true;// Shows that the current instance has children
    }

    /**
     * Adds child by variable to the current instance
     * @param child -> The new child
     */
    public void addChild(Node<Object> child){
        child.parent = this;// Link the current to the child as parent
        child.hasParent = true;// Shows that the child has parent
        this.children.add(child);// Add the child to the children list of the current instance
        this.hasChildren = true;// Shows that the current instance has children
    }

    /**
     * Gets the value of the current instance
     * @return the value of the current instance
     */
    public Object getValue(){
        return this.value;
    }

    /**
     * Sets the value to the current instance
     * @param value -> the new value for the current instance
     */
    public void setValue(Object value){
        this.value = value;
    }

    /**
     * Checks if the current instance is root
     * @return true if it is, false if it is not
     */
    public boolean isRoot(){
        return (!this.hasParent);// If the current instance has no parent returns true
    }

    /**
     * Checks if the current instance is leaf
     * @return true if it is, false if it is not
     */
    public boolean isLeaf(){
        return (!this.hasChildren);// If the current instance has no children returns true
    }
}
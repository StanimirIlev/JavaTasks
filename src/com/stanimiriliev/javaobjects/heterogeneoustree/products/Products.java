package com.stanimiriliev.javaobjects.heterogeneoustree.products;

/** Class for products
 * @author Stanimir Iliev
 * @since 21.07.2017
 */
public abstract class Products implements Comparable<Products>{

    public enum Packages{
        SMALL, MEDIUM, BIG
    }

    public final String make;
    public final Integer code;

    public Products(String make, int code){
        this.make = make;
        this.code = code;
    }

    public int compareTo(Products product){
        return this.code.compareTo(product.code);
    }
}

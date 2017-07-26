package com.stanimiriliev.javaobjects.heterogeneoustree.products;

/**
 * @author Stanimir Iliev
 * @since 21.07.2017
 */
public class Milk extends Products {

    public final Packages pack;

    public Milk(Packages pack, String make, Integer code){
        super(make, code);
        this.pack = pack;
    }
}

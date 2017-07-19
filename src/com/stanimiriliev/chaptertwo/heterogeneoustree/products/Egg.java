package com.stanimiriliev.chaptertwo.heterogeneoustree.products;

/**
 * @author Stanimir Iliev
 * @since 21.07.2017
 */
public class Egg extends Products {

    public final Packages pack;

    public Egg(Packages pack, String make, Integer code){
        super(make, code);
        this.pack = pack;
    }
}

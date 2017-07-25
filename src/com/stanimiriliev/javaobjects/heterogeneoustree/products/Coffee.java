package com.stanimiriliev.chaptertwo.heterogeneoustree.products;

/**
 * @author Stanimir Iliev
 * @since 21.07.2017
 */

public class Coffee extends Products {

    public enum Types{
            GROUND, BEANS
    }

    public final Packages pack;
    public final Types type;

    public Coffee(Packages pack, Types type, String make, Integer code){
        super(make, code);
        this.pack = pack;
        this.type = type;
    }
}

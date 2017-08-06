package com.stanimiriliev.testing.warehousemanagement;

import com.stanimiriliev.javaobjects.heterogeneoustree.products.*;
import com.stanimiriliev.javaobjects.heterogeneoustree.products.Products.Packages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Stanimir Iliev
 * @since 01.08.2017
 */
public class WarehouseManagement {

    private List<Products> milk = null, coffee = null, egg = null;
    private int milkCount = 0, coffeeCount = 0, eggCount = 0;
    private final int milkMax, coffeeMax, eggMax;

    enum TypeProducts {MILK, COFFEE, EGG}

    public WarehouseManagement(int milkMax, int coffeeMax, int eggMax){
        this.milkMax = milkMax;
        this.coffeeMax = coffeeMax;
        this.eggMax = eggMax;
    }

    /**
     * Gets product in specific quantity from the warehouse
     * @param typeProduct -> The enum type of the product (MILK, COFFEE, EGG)
     * @param make ->  The make of the product (not case sensitive)
     * @param pack -> The enum package of the product (SMALL, MEDIUM, BIG)
     * @param quantity -> The quantity of the product to get
     * @return list with the quantity of the product
     * or null if there is no such a product or not enough quantity of it
     */
    public List<Products> getProducts(TypeProducts typeProduct, String make,
                                      Packages pack, double price, int quantity){
        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive integer");
        List<Products> output = new ArrayList<>();
        int matches = 0;
        switch(typeProduct){
            case MILK:
                if(quantity > containsProduct(typeProduct, make, price, pack))
                    return null;
                for(int i = 0; i < milk.size() && matches < quantity; i++){
                    if(milk.get(i).make.equalsIgnoreCase(make) && milk.get(i).pack == pack &&
                            milk.get(i).price == price){
                        output.add(milk.get(i));
                        milk.remove(i--);
                        matches++;
                    }
                }
                return output.size() != 0 ? output : null;
            case COFFEE:
                if(quantity > containsProduct(typeProduct, make, price, pack))
                    return null;
                for(int i = 0; i < coffee.size() && matches < quantity; i++){
                    if(coffee.get(i).make.equalsIgnoreCase(make) && coffee.get(i).pack == pack &&
                            coffee.get(i).price == price){
                        output.add(coffee.get(i));
                        coffee.remove(i--);
                        matches++;
                    }
                }
                return output.size() != 0 ? output : null;
            case EGG:
                if(quantity > containsProduct(typeProduct, make, price, pack))
                    return null;
                for(int i = 0; i < egg.size() && matches < quantity; i++){
                    if(egg.get(i).make.equalsIgnoreCase(make) && egg.get(i).pack == pack &&
                            egg.get(i).price == price){
                        output.add(egg.get(i));
                        egg.remove(i--);
                        matches++;
                    }
                }
                return output.size() != 0 ? output : null;
            default: return null;
        }
    }


    /**
     * Adds specific quantity of product in the warehouse
     * @param typeProduct -> The enum type of the product you want to add (MILK, COFFEE, EGG)
     * @param product -> The actual product you want to add
     * @param quantity -> The quantity of this product you want to add
     * @return true if the product is added successfully
     * or false if there is not enough space in the warehouse
     */
    public boolean addProducts(TypeProducts typeProduct, Products product, int quantity){
        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive integer");
        switch(typeProduct){
            case MILK:
                if(milkCount + quantity <= milkMax){
                    if(milk == null)
                        milk = new ArrayList<>();
                    for(int i = 0; i < quantity; i++)
                        milk.add(product);
                    milkCount += quantity;
                    return true;
                }
                return false;
            case COFFEE:
                if(coffeeCount + quantity <= coffeeMax){
                    if(coffee == null)
                        coffee = new ArrayList<>();
                    for(int i = 0; i < quantity; i++)
                        coffee.add(product);
                    coffeeCount += quantity;
                    return true;
                }
                return false;
            case EGG:
                if(eggCount + quantity <= eggMax){
                    if(egg == null)
                        egg = new ArrayList<>();
                    for(int i = 0; i < quantity; i++)
                        egg.add(product);
                    eggCount += quantity;
                    return true;
                }
                return false;
            default: return false;
        }
    }

    /**
     * Returns all products in the warehouse sorted by their price (Returns without removing from the warehouse)
     * @return list with the products in the warehouse sorted by price
     * or null if there is not any products in the warehouse
     */
    public List<Products> getProductsSorted(){
        List<Products> output = new ArrayList<>();
        for(Products m : milk)
            output.add(m);
        for(Products c : coffee)
            output.add(c);
        for(Products e : egg)
            output.add(e);
        Collections.sort(output);
        return output;
    }

    /**
     * Shows how many free sets the specific product type has
     * @param typeProduct -> The enum type of the product (MILK, COFFEE, EGG)
     * @return the number of the free sets of the product
     */
    public int freeSets(TypeProducts typeProduct){
        switch(typeProduct){
            case MILK:
                return milkMax - milkCount;
            case EGG:
                return eggMax - eggCount;
            case COFFEE:
                return coffeeMax - coffeeCount;
            default:
                return -1;
        }
    }

    /**
     * Shows how many products the warehouse has with the same description
     * @param typeProduct -> The enum type of the product (MILK, COFFEE, EGG)
     * @param make -> The make of the product (not case sensitive)
     * @param pack -> The enum package of the product (SMALL, MEDIUM, BIG)
     * @return
     */
    public int containsProduct(TypeProducts typeProduct, String make, double price, Packages pack){
        int matches = 0;
        switch(typeProduct) {
            case MILK:
                for (int i = 0; i < milk.size(); i++)
                    if (milk.get(i).make.equalsIgnoreCase(make) && milk.get(i).pack == pack &&
                            milk.get(i).price == price)
                        matches++;
                break;
            case COFFEE:
                for (int i = 0; i < coffee.size(); i++)
                    if (coffee.get(i).make.equalsIgnoreCase(make) && coffee.get(i).pack == pack &&
                            coffee.get(i).price == price)
                        matches++;
                break;
            case EGG:
                for (int i = 0; i < egg.size(); i++)
                    if (milk.get(i).make.equalsIgnoreCase(make) && egg.get(i).pack == pack &&
                            egg.get(i).price == price)
                        matches++;
                break;
            default:
                return -1;
        }
        return matches;
    }
}

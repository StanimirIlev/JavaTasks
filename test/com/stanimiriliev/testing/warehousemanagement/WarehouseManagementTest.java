package com.stanimiriliev.testing.warehousemanagement;

import com.stanimiriliev.javaobjects.heterogeneoustree.products.*;
import com.stanimiriliev.javaobjects.heterogeneoustree.products.Products.Packages;
import com.stanimiriliev.testing.warehousemanagement.WarehouseManagement.TypeProducts;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Stanimir Iliev
 * @since 03.08.2017
 */
class WarehouseManagementTest {

    @Test
    void freeSetsTest(){
        WarehouseManagement warehouse = new WarehouseManagement(20, 30, 40);

        assertEquals(20, warehouse.freeSets(TypeProducts.MILK));
        assertEquals(30, warehouse.freeSets(TypeProducts.COFFEE));
        assertEquals(40, warehouse.freeSets(TypeProducts.EGG));

        warehouse.addProducts(TypeProducts.MILK, new Milk(Packages.BIG, "Vereia", 2.59), 7);

        assertEquals(13, warehouse.freeSets(TypeProducts.MILK));
    }

    @Test
    void addProductsTest(){
        WarehouseManagement warehouse = new WarehouseManagement(20, 30, 40);

        Products vereia = new Milk(Packages.MEDIUM, "Vereia", 2);
        Products bozhentsi = new Milk(Packages.SMALL, "Bozhentsi", 1.1);
        Products dalia = new Milk(Packages.BIG, "Dalia", 3.45);

        Products jacobs = new Coffee(Packages.MEDIUM, Coffee.Types.GROUND, "Jacobs", 2.8);
        Products novaBrasilia = new Coffee(Packages.MEDIUM, Coffee.Types.BEANS, "Nova Brasilia", 2.65);
        Products nescafe = new Coffee(Packages.SMALL, Coffee.Types.GROUND, "NESCAFE 3in1", 0.3);

        Products stoevtsi = new Egg(Packages.SMALL, "Stoevtsi", 1.2);
        Products yabalka = new Egg(Packages.MEDIUM, "Yabalka", 2.15);
        Products krushevo = new Egg(Packages.BIG, "Krushevo", 3.6);

        assertEquals(true, warehouse.addProducts(TypeProducts.MILK, vereia, 10));
        //  Not enough space
        assertEquals(false, warehouse.addProducts(TypeProducts.MILK, bozhentsi, 30));
        assertEquals(true, warehouse.addProducts(TypeProducts.MILK, bozhentsi, 5));
        assertEquals(true, warehouse.addProducts(TypeProducts.MILK, dalia, 5));
        assertEquals(true, warehouse.addProducts(TypeProducts.COFFEE, jacobs, 15));
        assertEquals(true, warehouse.addProducts(TypeProducts.COFFEE, novaBrasilia, 10));
        assertEquals(true, warehouse.addProducts(TypeProducts.COFFEE, nescafe, 5));
        assertEquals(true, warehouse.addProducts(TypeProducts.EGG, stoevtsi, 20));
        assertEquals(true, warehouse.addProducts(TypeProducts.EGG, yabalka, 10));
        assertEquals(true, warehouse.addProducts(TypeProducts.EGG, krushevo, 10));
    }

    @Test
    void getProductsSortedTest(){
        WarehouseManagement warehouse = new WarehouseManagement(20, 30, 40);

        Products vereia = new Milk(Packages.MEDIUM, "Vereia", 2);
        Products bozhentsi = new Milk(Packages.SMALL, "Bozhentsi", 1.1);
        Products dalia = new Milk(Packages.BIG, "Dalia", 3.45);

        Products jacobs = new Coffee(Packages.MEDIUM, Coffee.Types.GROUND, "Jacobs", 2.8);
        Products novaBrasilia = new Coffee(Packages.MEDIUM, Coffee.Types.BEANS, "Nova Brasilia", 2.65);
        Products nescafe = new Coffee(Packages.SMALL, Coffee.Types.GROUND, "NESCAFE 3in1", 0.3);

        Products stoevtsi = new Egg(Packages.SMALL, "Stoevtsi", 1.2);
        Products yabalka = new Egg(Packages.MEDIUM, "Yabalka", 2.15);
        Products krushevo = new Egg(Packages.BIG, "Krushevo", 3.6);

        warehouse.addProducts(TypeProducts.MILK, vereia, 10);
        warehouse.addProducts(TypeProducts.MILK, bozhentsi, 5);
        warehouse.addProducts(TypeProducts.MILK, dalia, 5);
        warehouse.addProducts(TypeProducts.COFFEE, jacobs, 15);
        warehouse.addProducts(TypeProducts.COFFEE, novaBrasilia, 10);
        warehouse.addProducts(TypeProducts.COFFEE, nescafe, 5);
        warehouse.addProducts(TypeProducts.EGG, stoevtsi, 20);
        warehouse.addProducts(TypeProducts.EGG, yabalka, 10);
        warehouse.addProducts(TypeProducts.EGG, krushevo, 10);

        List<Products> sortedProducts = new ArrayList<>();

        for(int i = 0; i < 5; i++)
            sortedProducts.add(nescafe);
        for(int i = 0; i < 5; i++)
            sortedProducts.add(bozhentsi);
        for(int i = 0; i < 20; i++)
            sortedProducts.add(stoevtsi);
        for(int i = 0; i < 10; i++)
            sortedProducts.add(vereia);
        for(int i = 0; i < 10; i++)
            sortedProducts.add(yabalka);
        for(int i = 0; i < 10; i++)
            sortedProducts.add(novaBrasilia);
        for(int i = 0; i < 15; i++)
            sortedProducts.add(jacobs);
        for(int i = 0; i < 5; i++)
            sortedProducts.add(dalia);
        for(int i = 0; i < 10; i++)
            sortedProducts.add(krushevo);

        assertEquals(sortedProducts, warehouse.getProductsSorted());
    }

    @Test
    void getProductsTest(){
        WarehouseManagement warehouse = new WarehouseManagement(20, 30, 40);

        Products vereia = new Milk(Packages.MEDIUM, "Vereia", 2);
        Products bozhentsi = new Milk(Packages.SMALL, "Bozhentsi", 1.1);
        Products dalia = new Milk(Packages.BIG, "Dalia", 3.45);

        Products jacobs = new Coffee(Packages.MEDIUM, Coffee.Types.GROUND, "Jacobs", 2.8);
        Products novaBrasilia = new Coffee(Packages.MEDIUM, Coffee.Types.BEANS, "Nova Brasilia", 2.65);
        Products nescafe = new Coffee(Packages.SMALL, Coffee.Types.GROUND, "NESCAFE 3in1", 0.3);

        Products stoevtsi = new Egg(Packages.SMALL, "Stoevtsi", 1.2);
        Products yabalka = new Egg(Packages.MEDIUM, "Yabalka", 2.15);
        Products krushevo = new Egg(Packages.BIG, "Krushevo", 3.6);

        warehouse.addProducts(TypeProducts.MILK, vereia, 10);
        warehouse.addProducts(TypeProducts.MILK, bozhentsi, 5);
        warehouse.addProducts(TypeProducts.MILK, dalia, 5);
        warehouse.addProducts(TypeProducts.COFFEE, jacobs, 15);
        warehouse.addProducts(TypeProducts.COFFEE, novaBrasilia, 10);
        warehouse.addProducts(TypeProducts.COFFEE, nescafe, 5);
        warehouse.addProducts(TypeProducts.EGG, stoevtsi, 20);
        warehouse.addProducts(TypeProducts.EGG, yabalka, 10);
        warehouse.addProducts(TypeProducts.EGG, krushevo, 10);

        List<Products> products = new ArrayList<>();
        for(int i = 0; i < 7; i++)
            products.add(vereia);
        List<Products> warehouseProducts = warehouse.getProducts(
                TypeProducts.MILK, "vereia", Packages.MEDIUM, 2, 7);
        assertEquals(products, warehouseProducts);
        warehouseProducts = warehouse.getProducts(
                TypeProducts.MILK, "vereia", Packages.MEDIUM, 2,  20);
        assertEquals(null, warehouseProducts);
    }

    @Test
    void containsProductTest() {
        WarehouseManagement warehouse = new WarehouseManagement(20, 30, 40);

        warehouse.addProducts(TypeProducts.MILK, new Milk(Packages.MEDIUM, "Vereia", 2), 3);

        assertEquals(3, warehouse.containsProduct(TypeProducts.MILK, "vereia", 2, Packages.MEDIUM));
    }
}
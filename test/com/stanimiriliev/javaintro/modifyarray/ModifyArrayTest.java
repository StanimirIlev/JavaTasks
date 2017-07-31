package com.stanimiriliev.javaintro.modifyarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Stanimir Iliev
 * @since 31.07.2017
 */
class ModifyArrayTest {
    @Test
    void getMinElement() {
        assertEquals(-2, new ModifyArray(new int[]
                {1, 2, 3, 6, 8, -2, -2, 5, 0, 11, 8}).getMinElement());

        assertEquals(0, new ModifyArray(new int[]{0, 0, 0, 3}).getMinElement());

        assertEquals(1, new ModifyArray(new int[]{2, 1, 8, 3}).getMinElement());

        try{
            assertEquals(0, new ModifyArray(new int[]{}).getMinElement());
            fail("The method should throw exception");
        }
        catch(IllegalArgumentException e){
        }
    }

    @Test
    void getSum() {
        assertEquals(40, new ModifyArray(new int[]
                {1, 2, 3, 6, 8, -2, -2, 5, 0, 11, 8}).getSum());

        assertEquals(3, new ModifyArray(new int[]{0, 0, 0, 3}).getSum());

        assertEquals(14, new ModifyArray(new int[]{2, 1, 8, 3}).getSum());

        try{
            assertEquals(0, new ModifyArray(new int[]{}).getSum());
            fail("The method should throw exception");
        }
        catch(IllegalArgumentException e){
        }
    }

}
package com.stanimiriliev.javaobjects.sumator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Stanimir Iliev
 * @since 29.07.2017
 */
class SumatorTest {
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Sumator sum = new Sumator();
    }

    @org.junit.jupiter.api.Test
    void sum2() {
        assertEquals(19, Sumator.sum("15", "4"));

        try{
            Sumator.sum("a", "b");
            fail("The method should throw NumberFormatException");
        }
        catch(NumberFormatException e){
            assertEquals(true, true);
        }

        try{
            Sumator.sum(null, "b");
            fail("The method should throw IllegalArgumentException");
        }
        catch(IllegalArgumentException e){
            assertEquals(true, true);
        }
    }

}
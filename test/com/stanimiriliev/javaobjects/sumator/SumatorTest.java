package com.stanimiriliev.javaobjects.sumator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * @author Stanimir Iliev
 * @since 29.07.2017
 */
class SumatorTest {
    
    @Test
    void testWithNormalEntry() {
        assertEquals(19, Sumator.sum("15", "4"));
    }

    @Test
    void testWithInvalidEntry(){
        try{
            Sumator.sum("a", "b");
            fail("The method should throw NumberFormatException");
        }
        catch(NumberFormatException e){}
    }

    @Test
    void testWithNullValue(){
        try{
            Sumator.sum(null, "b");
            fail("The method should throw IllegalArgumentException");
        }
        catch(IllegalArgumentException e){}
    }

}
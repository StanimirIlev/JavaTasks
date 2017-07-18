package com.stanimiriliev.chaptertwo.sumator;
/**
 * Created by Stanimir Iliev on 16.6.2017 y..
 */

import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sumator {
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static int sum(int a, int b){
        return a + b;
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static double sum(double a, double b){
        return a + b;
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static int sum(String a, String b){
        try{
            return Integer.parseInt(a) + Integer.parseInt(b);// Trying to parse both strings to int and sum them
        }
        catch(NumberFormatException e){// If one of the strings does not contains only digits
            System.out.println("Invalid numbers.\nPlease enter valid numbers.\nFirst number: ");// Print error msg
            Scanner input = new Scanner(System.in);// Open Scanner stream
            while(true){// Infinity loop so the code inside will run until the user enters a valid numbers
                try{// Second try-catch block to process the exceptions
                    int c = input.nextInt();// read first number from the console
                    System.out.println("Second number: ");
                    int d = input.nextInt();// read second number from the console
                    input.close();// Close the Scanner stream
                    return c + d;// return the result
                }
                catch(InputMismatchException ex){// If the user has entered invalid numbers
                    System.out.println("Invalid numbers.\nPlease enter valid numbers.\nFirst number: ");// Error msg
                    input = new Scanner(System.in);// Recreates instance of the class Scanner in order to reset the
                    // input of the user
                }
                catch(NoSuchElementException ex){// If the input is exhausted
                    System.out.println("Input is exhausted.\nPlease enter the numbers again.\nFirst number: ");// Error msg
                    input = new Scanner(System.in);// Recreates instance of the class Scanner
                }
                catch(IllegalStateException ex){// If the scanner is closed
                    System.out.println("The scanner is closed.\nPlease enter the numbers again.\nFirst number: ");// Error msg
                    input.reset();// Restart the instance of the class Scanner
                }
            }
        }
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static BigInteger sum(BigInteger a, BigInteger b){
        return a.add(b);
    }
    /**
     * Sum two numbers
     * @param a -> first number
     * @param b -> second number
     * @return the sum of the two numbers
     */
    public static BigDecimal sum(BigDecimal a, BigDecimal b){
        return a.add(b);
    }
}

package com.stanimiriliev.chapterone.modifyarray;

/**
 * Created by Stanimir Iliev on 18.7.2017 г..
 */
public class Test {
    public static void main(String[] args){
        int[] array = {5, 9, 8, 1, 7, 3, 5, 9, 2, 5, 1, 5, 9, 5};
        ModifyArray myArr = new ModifyArray(array);
        System.out.printf("The minimal element of the array is %d\n", myArr.getMinElement());
        System.out.printf("The sum of all elements in the array is %d\n", myArr.getSum());
        System.out.println("The array:");
        myArr.printArray();
    }
}

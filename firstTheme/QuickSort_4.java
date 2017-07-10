/**
 * Created by Stanimir Iliev on 13.6.2017 y..
 */
import java.util.*;

public class QuickSort {
    public static void main(String[] args){
        int[] array = new int[] {5, 8, 6, 4, 2, 3, 7, 5, 6, 2, 1, 5, 9, 34};
        sort(array, 0, array.length - 1);
        for(int number : array){
            System.out.printf("%d, ", number);
        }
    }

    /**
     * Sorts array by quickSort method
     * @param array -> The array that is sorted
     * @param left -> The beginning of the array that is sorted
     * @param right -> The ending of the array that is sorted
     */
    private static void sort(int[] array, int left, int right){
        if(array.length == 1 || array.length == 0){
            return;// can't sort array with one element or empty array
        }
        int i = left,// Beginning of the unsorted array
                j = right,//    Ending of the unsorted array
                pivot = array[left + (right - left) / 2];// get the middle element of the array
        while(i <= j){
            while(array[i] < pivot)//   Searching for element bigger than the pivot
                i++;
            while(array[j] > pivot)//   Searching for element smaller than the pivot
                j--;
            if(i <= j){//   When 'i' is index of element bigger than the pivot and 'j' is index of element smaller
                swap(array, i, j);//    than the pivot, both elements are swapped
                i++;//  Moving to the next element
                j--;
            }
        }
        if(left < j)
            sort(array, left, j);// Recursively sort left part of the array
        if(i < right)
            sort(array, i, right);// Recursively sort right part of the array
    }

    /**
     * Swap two elements inside the array
     * @param array -> the array which elements are being swapped
     * @param a -> the index of the one element
     * @param b -> the index of the other element
     */
    private static void swap(int[] array, int a, int b){
        int temp = array[a];//  Temporary variable to store the value of the first variable
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Prints the array to the console
     * @param array -> The array that is printed
     */
    private static void printArray(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length - 1; i++){//    Print all elements of the array without the last one
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("%d]\n", array[array.length - 1]);//  Print last element of the array
    }
}

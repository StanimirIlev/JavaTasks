/**
 * Created by Stanimir Iliev on 15.6.2017 y..
 */
public class ReverseArray {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverse(array);//   Reversing the array
        print(array);// Printing the array
    }

    /**
     * Reversing elements of the array
     * @param array -> The array which elements is reversed
     */
    private static void reverse(int[] array){
        int i = 0,//    beginning of the array
                j = array.length - 1;// ending of the array
        while(i <= j){//    Swap first and last element, then second element and this before last and etc.
            swap(array, i, j);
            i++;
            j--;
        }
    }

    /**
     * Swaps two elements in an array
     * @param array -> The array which elements are being swapped
     * @param a -> The index of the first element to swap
     * @param b -> The index of the second element to swap
     */
    private static void swap(int[] array, int a, int b){
        int temp = array[a];//  Temporary variable for storing the value of the first variable
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Prints the array to the console
     * @param array -> The array that is printed
     */
    private static void print(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length - 1; i++){//    Print all elements of the array without the last one
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("%d]\n", array[array.length - 1]);// Print the last element of the array
    }
}

/**
 * Created by Stanimir Iliev on 13.6.2017 y..
 */
public class EditArray {
    public static void main(String[] args){
        int[] array = {5, 9, 8, 1, 7, 3, 5, 9, 2, 5, 1, 5, 9, 5};// define some array
        System.out.printf("The minimal element of the array is %d\n", getMinElement(array));//  get minimal element of the array
        System.out.printf("The sum of all elements in the array is %d\n", getSum(array));// get sum of the array elements
        System.out.println("The array:");
        printArray(array);//    print the array
    }
//change for git hub
    /**
     * Gets the minimal element of an array
     * @param array -> the array of which the smallest element is returned
     * @return the smallest element of an array
     */
    private static int getMinElement(int[] array){
        int minValue = Integer.MAX_VALUE;// set maximum value to minValue so the array to not has bigger element
        for(int number : array){//  iterates every element of the array as number
            if(number < minValue){//    if any element is smaller than the minValue, the minValue gets its value
                minValue = number;
            }
        }
        return minValue;
    }

    /**
     * Sum all elements of an array
     * @param array -> the array which elements are summed
     * @return the sum of all elements in the array
     */
    private static int getSum(int[] array){
        int sum = 0;//  define the sum of the array
        for(int number : array){//  add the value of every element in the array to sum
            sum += number;
        }
        return sum;
    }

    /**
     * Print an array
     * @param array -> the array which will be printed
     */
    private static void printArray(int[] array){
        System.out.print("[");
        for(int i = 0; i < array.length; i++){
            if(i < array.length - 1){// printing all elements with comma without the last one because it should not be printed
                System.out.printf("%d, ", array[i]);//                                                              with comma
                continue;
            }
            System.out.printf("%d]\n", array[i]);
        }
    }
}

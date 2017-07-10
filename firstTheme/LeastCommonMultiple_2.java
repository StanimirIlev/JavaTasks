/**
 * Created by aaa on 12.6.2017 г..
 */
import java.util.*;
public class LeastCommonMultiple {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                System.out.print("\tFind least common multiple\nEnter first number: ");
                int a = Integer.parseInt(in.nextLine());//  read integer from the console
                System.out.print("Enter second number: ");
                int b = Integer.parseInt(in.nextLine());//  read integer from the console
                System.out.printf("The least common multiple of " +
                        "%d and %d is %d", a, b, FindLCM(a, b));
                in.close();
                break;
            }
            catch(NumberFormatException e){// catches invalid input from the console
                System.out.println("Invalid input. You must enter an integer.");
            }
        }
    }
    /**
     * Finds the least common multiple of two integers.
     * @param a -> first integer.
     * @param b -> second integer.
     * @return the least common multiple of a and b.
     */
    public static int FindLCM(int a, int b){
        for(int i = 1;i <= a * b;i++){
            if(i % a == 0 && i % b == 0){// if i is multiple of a and b returns i
                return i;
            }
        }
        return 0;// Error
    }
}

/**
 * Created by Stanimir on 12.6.2017 y..
 */
import java.util.Scanner;

public class GreatestCommonDivisor {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){//  using infinity loop so if exception has been threw the program starts over
            try{
                System.out.print("\tFind greatest common divisor\nEnter first number: ");
                int a = Integer.parseInt(in.nextLine());//  read integer from the console
                System.out.print("Enter second number: ");
                int b = Integer.parseInt(in.nextLine());//  read integer from the console
                System.out.printf("The greatest common divisor of " +
                        "%d and %d is %d", a, b, FindGCD(a, b));
                in.close();
                break;
            }
            catch(NumberFormatException e){// catches invalid input from the console
                System.out.println("Invalid input. You must enter an integer.");
            }
        }
    }
    /**
     * Finds the greatest common divisor of two integers.
     * @param a -> first integer.
     * @param b -> second integer.
     * @return the greatest common divisor of a and b.
    */
    public static int FindGCD(int a, int b){
        int gcd = 1;//  greatest common divisor
        int smaller = a < b ? a : b;//  the smaller integer between a and b
        for(int i = 2; i <= smaller; i++){
            if(a % i == 0 && b % i == 0 && i > gcd){//   if i is common divisor and greatest than gcd, gcd gets its value
                gcd = i;
            }
        }
        return gcd;
    }
}

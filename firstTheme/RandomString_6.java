/**
 * Created by Stanimir Iliev on 15.6.2017 y..
 */
import java.util.Scanner;
import java.util.Random;

public class RandomString {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){//  Infinity loop to return if the user enters a invalid integer
            System.out.print("\tRandom string generator\nEnter the length of the string: ");
            try{
                int length = Integer.parseInt(in.nextLine());// Gets the length of the string by the user
                System.out.println(randomString(length));// Prints the random string
                break;
            }
            catch(NumberFormatException e){//   Catches if the user enter an invalid integer
                System.out.println("Invalid input. You must enter a integer.");
            }
        }
        in.close();
    }

    /**
     * Generates random string with specified length
     * @param length -> The length of the string
     * @return random string
     */
    private static String randomString(int length){
        if(length <= 0)//   Check if length is zero or less and if it is true returns a empty string
            return "";
        Random rnd = new Random();//    Generates instance of the class java.util.Random
        StringBuilder str = new StringBuilder();//    Generates instance of the class StringBuilder
        for(int i = 0; i < length; i++){
            str.append((char)rnd.nextInt(128));//   Appends random character, of the ASCII table, to the str
        }
        return str.toString();//    Convert str from StringBuilder to String and returns it
    }
}

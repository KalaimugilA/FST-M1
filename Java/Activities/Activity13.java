package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main (String[] args){

        Scanner scan =new Scanner(System.in);
        ArrayList<Integer> list =new ArrayList<Integer>();
        System.out.print("Enter integers please ");
        System.out.println("(EOF or non-integer to terminate): ");

        Random indexGen = new Random();
                   while(scan.hasNextInt())
        {
            list.add(scan.nextInt());
       }

        Integer nums[] =list.toArray(new Integer[0]);
        int index=indexGen.nextInt(nums.length);
        System.out.println("Index generated" + index);
        System.out.println("values in array in generated index" + nums[index]);
scan.close();
    }
}

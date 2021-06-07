package typeCasting;

import java.util.Scanner;

public class typeCasting {

    /*** Java Class to represent the use of Scanner class for taking user input ***/

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println("The input is :" + " " +input);

        Scanner scString = new Scanner(System.in);
        String string = scString.nextLine();
        System.out.println(string);
    }
}

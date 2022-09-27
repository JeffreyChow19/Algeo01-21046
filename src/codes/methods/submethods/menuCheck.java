package codes.methods.submethods;

import java.util.Scanner;

public class menuCheck {
    public static Scanner scn = new Scanner(System.in);

    public static int main(int min, int max, String[] methods) {

        for (int i = 1; i <= methods.length; i++) {
            System.out.printf("[%d] %s\n", i, methods[i - 1]);
        }
        
        int choice = -9999;

        while (choice < min || choice > max) {
            if (choice != -9999) {
                System.out.println("Input not valid, try again.");
            }
            System.out.printf("\nMenu : ");

            choice = scn.nextInt();
            scn.nextLine();

        }

        return choice;
    }
}

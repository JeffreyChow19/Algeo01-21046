package codes.methods.submethods;

import java.util.Scanner;

import codes.ADT.constructors.printMtrxConsole;

public class menuCheck extends printMtrxConsole {
    public static Scanner scn = new Scanner(System.in);

    public static int main(int min, int max, String[] methods) {

        for (int i = 1; i <= methods.length; i++) {
            System.out.printf("[%d] %s\n", i, methods[i - 1]);
        }
        
        int choice = -9999;

        while (choice < min || choice > max) {
            if (choice != -9999) {
                println("Input not valid, try again.");
            }
            print("\nMenu : ");

            choice = scn.nextInt();
            scn.nextLine();

        }

        return choice;
    }
}

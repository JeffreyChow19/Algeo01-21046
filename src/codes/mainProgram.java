package codes;

import java.util.Scanner;
import codes.inputs.*;
import codes.methods.InterpolasiPolinom;
import codes.methods.submethods.menuCheck;

public class mainProgram {
    public static Scanner scn = new Scanner(System.in); 

    public static boolean running = true;
    public static void main(String[] args) {
        while (running){
            
            System.out.println("\nWelcome to Matrix Processing Program");
            System.out.println("====================================\n");

            // Menu
            System.out.println("Menu");

            String[] menu = { "Sistem Persamaan Linear", "Determinan", "Matriks Balikan", "Interpolasi Polinom",
                    "Interpolasi Bicubic", "Regresi Linier Berganda", "Exit" };

            int choice = menuCheck.main(1, 7, menu);

            switch (choice) {
                case 1:
                    inputSPL.main(args);
                    break;
                case 2:
                    inputDeterminan.main(args);
                    break;
                case 3:
                    inputInvers.main(args);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    running = false;
                    System.exit(0);
                    break;
                default:
                    break;
            }

            System.out.println("\nPress enter key to continue");
            try {
                System.in.read();
            } catch (Exception e) {}
            
        }

        scn.close();

    }
}

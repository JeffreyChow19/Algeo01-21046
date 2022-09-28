package codes;

import java.util.Scanner;

import codes.ADT.constructors.printMtrxConsole;
import codes.inputs.*;
import codes.methods.RegresiLinierBerganda;
import codes.methods.submethods.menuCheck;

public class mainProgram extends printMtrxConsole {
    public static Scanner scn = new Scanner(System.in); 

    public static boolean running = true;
    public static void main(String[] args) {
        while (running){
            
            println("\nWelcome to Matrix Processing Program");
            println("====================================\n");

            // Menu
            println("Menu");

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
                    inputPolynom.main(args);
                    break;
                case 5:
                    break;
                case 6:
                    RegresiLinierBerganda.main(args);
                    break;
                case 7:
                    running = false;
                    System.exit(0);
                    break;
                default:
                    break;
            }

            println("\nPress enter key to continue");
            try {
                System.in.read();
            } catch (Exception e) {}
            
        }

        scn.close();

    }
}

package codes;

import java.util.Scanner;
import codes.inputs.*;

public class mainProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Header
        System.out.println("Welcome to Matrix Processing Program");
        System.out.println("====================================\n");

        // Menu
        System.out.println("Menu");

        String []menu = {"Sistem Persamaan Linear", "Determinan", "Matriks Balikan", "Interpolasi Polinom", "Interpolasi Bicubic", "Regresi Linier Berganda", "Exit"};

        for (int i = 1; i <= menu.length; i++){
            System.out.printf("[%d] %s\n", i, menu[i-1]);
        }

        int choice = -9999 ;
    
        while (choice <1 || choice >7){
            if (choice != -9999){
                System.out.println("Input not valid, try again.");
            } 
            System.out.printf("\nMenu : ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        switch (choice) {
            case 1:
                inputSPL.main(args);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default :
                break;
        }

        scanner.close();

    }

}

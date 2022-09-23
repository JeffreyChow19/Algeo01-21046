package codes.inputs;

import java.util.Scanner;
import codes.mainProgram;
import codes.ADT.constructors.*;
import codes.ADT.Matrix;

public class inputSPL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] methods = {
            "Metode eliminasi Gauss",
            "Metode eliminasi Gauss-Jordan",
            "Metode matriks balikan",
            "Kaidah Cramer",
            "Return to Menu"
        };
    
        System.out.println("\nMethods");
        System.out.println("=======\n");

        for (int i=1; i <= methods.length; i++){
            System.out.printf("[%d] %s", i, methods[i-1]);
        }

        int choice = -9999;

        while (choice < 1 || choice > 7) {
            if (choice != -9999) {
                System.out.println("Input not valid, try again.");
            }
            System.out.printf("\nMethods : ");
            choice = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Input Type:");
        System.out.println("[1] Console");
        System.out.println("[2] File txt");

        int inputType = -9999;
        while (inputType < 1 || inputType > 2){
            if (inputType != -9999){
                System.out.println("Input not valid, try again.");
            }

            inputType = scanner.nextInt();
            scanner.nextLine();
        }

        Matrix matrix;

        switch(inputType){
            case 1:
                matrix = createMtrxConsole.createMatrix();
                break;
            case 2:
                matrix = createMtrxFile.createMatrix();
                break;
            default: break;
        }

        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                mainProgram.main(args);
            default:
                break;
        }

        scanner.close();
        
    }


}

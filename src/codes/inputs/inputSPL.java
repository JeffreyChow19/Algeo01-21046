package codes.inputs;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

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
                break;
            default:
                break;
        }

        scanner.close();
        
    }


}

package codes.ADT.constructors;

import java.io.IOException;
import java.util.Scanner;

import codes.ADT.Matrix;

public class createMtrx {
    public static Scanner scanner = new Scanner(System.in);

    public static Matrix main(boolean square) {
        System.out.println("Input Types:");
        System.out.println("[1] Console");
        System.out.println("[2] File txt");

        int inputType = -9999;
        while (inputType < 1 || inputType > 2) {
            if (inputType != -9999) {
                System.out.println("Input not valid, try again.");
            }

            System.out.printf("\nInput type : ");
            inputType = scanner.nextInt();
            scanner.nextLine();
        } 

        Matrix matrix;
        if (inputType == 1){
            matrix = createMtrxConsole.createMatrix(square);
            return matrix;
        } else {
            System.out.println("File name: ");
            String pathname = scanner.nextLine();
            try{
                matrix = createMtrxFile.createMatrix(pathname);
                return matrix;
            } catch (IOException ex){
                System.out.println("No such files.");
            }
            return null;
        }
        
    }
}

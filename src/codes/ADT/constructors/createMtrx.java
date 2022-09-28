package codes.ADT.constructors;

import java.io.IOException;
import java.util.Scanner;

import codes.ADT.Matrix;
import codes.methods.submethods.menuCheck;

public class createMtrx {
    public static Scanner scanner = new Scanner(System.in);

    public static Matrix main(boolean square) {
        System.out.println("Input Types:");

        String[] methods = {
            "Console",
            "File txt"
        };

        int inputType = menuCheck.main(1, 2, methods);
        
        Matrix matrix;
        if (inputType == 1){
            matrix = createMtrxConsole.createMatrix(square);
            return matrix;
        } else {
            System.out.printf("File name: ");
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

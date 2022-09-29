package codes.inputs;
import codes.ADT.*;
import java.util.Scanner;
import codes.methods.*;

public class inputBikubik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix size: ");
        int size_matrix = scanner.nextInt();
        Matrix matrix = new Matrix(size_matrix, size_matrix);
        System.out.println("Input your matrix: ");
        int i, j;
        for(i=0; i<size_matrix; i++){
            for(j=0; j<size_matrix; j++){
                matrix.Mtrx[i][j]= scanner.nextDouble();
            }
        }
        System.out.println("Input function arguments");
        System.out.print("x = ");
        double indeks1 = scanner.nextDouble();
        System.out.print("y = ");
        double indeks2 = scanner.nextDouble();
        scanner.close();
        InterpolasiBicubic.bikubik(matrix, indeks1, indeks2);
    }
}

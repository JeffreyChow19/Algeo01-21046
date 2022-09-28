package codes;
import java.util.Scanner;

import codes.ADT.*;
import codes.methods.InterpolasiBicubic;

public class test_wt {
    public static void main(String[] args){
        InterpolasiBicubic.bikubik(read_matrix());
    }
    public static void print_matrix(Matrix m){
        int i, j;
        for(i=0; i<m.rows; i++){
            for(j=0; j<m.cols; j++){
                System.out.printf("%.2f ", m.Mtrx[i][j]);
            }
            System.out.println();
        }
    }
    public static Matrix read_matrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix size: ");
        int size_matrix = scanner.nextInt();
        Matrix matrix = new Matrix(size_matrix, size_matrix);
        int i, j;
        for(i=0; i<size_matrix; i++){
            for(j=0; j<size_matrix; j++){
                matrix.Mtrx[i][j]= scanner.nextDouble();
            }
        }
        scanner.close();
        // print_matrix(matrix);
        return matrix;
    }
}

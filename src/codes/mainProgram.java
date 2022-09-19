package codes;

// import codes.ADT.constructor.createMtrx;
import codes.ADT.Matrix;
// import codes.ADT.constructor.Transpose;
import codes.ADT.constructors.*;
// import codes.ADT.primitives.*;
import codes.methods.*;

public class mainProgram {
    public static void main(String[] args) {
        Matrix matrix = createMtrx.createMatrix();
        // matrix = Transpose.transpose(matrix);
        printMtrx.printMatrix(matrix);
        System.out.println("\n");
        // double timesDiag = TimesDiagonal.timesDiagonal(matrix, IsSquare.isSquare(matrix));
        // System.out.println("Product of diagonal: "+timesDiag);
        // double det = detCofactor.determinant(matrix, matrix.rows , IsSquare.isSquare(matrix));
        // System.out.println("Determinant: "+ det);

        printMtrx.printMatrix(Gauss.gauss(matrix));



    }
}

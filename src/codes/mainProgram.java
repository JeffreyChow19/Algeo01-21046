package codes;

// import codes.ADT.constructor.createMtrx;
import codes.ADT.Matrix;
// import codes.ADT.constructor.Transpose;
import codes.ADT.constructor.*;

public class mainProgram {
    public static void main(String[] args) {
        Matrix matrix = createMtrx.createMatrix();
        matrix = Transpose.transpose(matrix);
        createMtrx.printMatrix(matrix);
        System.out.println("\n");
        double timesDiag = TimesDiagonal.timesDiagonal(matrix, IsSquare.isSquare(matrix));
        System.out.println("Product of diagonal: "+timesDiag);
    }
}

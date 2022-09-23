package codes.methods;

import codes.ADT.Matrix;
import codes.ADT.constructors.Transpose;
import codes.ADT.primitives.*;

public class Inverse {
    public static Matrix inverse (Matrix m) {
        Matrix temp_inverse = new Matrix(m.rows, m.cols);
        Matrix inversed_matrix = new Matrix(m.rows, m.cols);
        double det = determinant.detCofactor(m, m.rows, true);
            if (det == 0){
                System.out.println("Matrix is singular.");
                return m;
            } else {
                adjoinInverse(m, temp_inverse);
                temp_inverse = Transpose.transpose(temp_inverse);
                for (int i = 0; i < m.rows; i++){
                    for (int j = 0; j < m.cols; j++){
                        inversed_matrix.Mtrx[i][j] = temp_inverse.Mtrx[i][j] / det;
                    }}
                return inversed_matrix;
            }
    }

    public static void adjoinInverse(Matrix m, Matrix adjMtrx) {
        if (m.rows == 1){
            adjMtrx.Mtrx[0][0] = 1;
        }

        Matrix temp = new Matrix(m.rows, m.cols);
        for (int i = 0; i < m.rows; i++){
            for (int j = 0; j < m.cols; j++){
                GetCofactor.getCofactor(m, temp, i, j, m.rows);
                // ganti tanda tiap urutan genap
                int sign = ((i+j) % 2 == 0) ? 1 : -1;
                adjMtrx.Mtrx[i][j] = (sign) * determinant.detCofactor(temp, m.rows-1, true);

            }
        }
    }
}

package codes.methods;

import codes.ADT.*;

public class InverseSample {
    public static Matrix inverse(Matrix matrix) {
    // Matrix Declaration.
    int order = matrix.rows;
    matrix.cols = matrix.rows*2;
    double[] temp;
 
    // Create the augmented matrix
    // Add the identity matrix
    // of order at the end of original matrix.
    for (int i = 0; i < order; i++) {
 
        for (int j = 0; j < 2 * order; j++) {
 
            // Add '1' at the diagonal places of
            // the matrix to create a identity matrix
            if (j == (i + order))
                matrix.Mtrx[i][j] = 1;
        }
    }
 
    // Interchange the row of matrix,
    // interchanging of row will start from the last row
    for (int i = order - 1; i > 0; i--) {
 
        // Swapping each and every element of the two rows
        // if (matrix[i - 1][0] < matrix[i][0])
        // for (int j = 0; j < 2 * order; j++) {
        //
        //        // Swapping of the row, if above
        //        // condition satisfied.
        // temp = matrix[i][j];
        // matrix[i][j] = matrix[i - 1][j];
        // matrix[i - 1][j] = temp;
        //    }
 
        // Directly swapping the rows using pointers saves
        // time
 
        if (matrix.Mtrx[i - 1][0] < matrix.Mtrx[i][0]) {
            temp = matrix.Mtrx[i];
            matrix.Mtrx[i] = matrix.Mtrx[i - 1];
            matrix.Mtrx[i - 1] = temp;
        }
    }
 
    double temp2;
    // Replace a row by sum of itself and a
    // constant multiple of another row of the matrix
    for (int i = 0; i < order; i++) {
 
        for (int j = 0; j < order; j++) {
 
            if (j != i) {
 
                temp2 = matrix.Mtrx[j][i] / matrix.Mtrx[i][i];
                for (int k = 0; k < 2 * order; k++) {
 
                    matrix.Mtrx[j][k] -= matrix.Mtrx[i][k] * temp2;
                }
            }
        }
    }
 
    // Multiply each row by a nonzero integer.
    // Divide row element by the diagonal element
    for (int i = 0; i < order; i++) {
 
        temp2 = matrix.Mtrx[i][i];
        for (int j = 0; j < 2 * order; j++) {
 
            matrix.Mtrx[i][j] = matrix.Mtrx[i][j] / temp2;
        }
    }
    // print the resultant Inverse matrix.
    return matrix;
    }
}


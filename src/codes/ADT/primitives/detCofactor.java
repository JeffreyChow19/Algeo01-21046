package codes.ADT.primitives;

import codes.ADT.Matrix;

public class detCofactor {
    public static double determinant(Matrix m, int n, boolean isSquare)
{   if (isSquare){
    float result = 0;
    //  Base recursion
    if (n == 1)
        return m.Mtrx[0][0];

    Matrix temp = new Matrix(m.rows, m.cols); // store cofactors

    float sign = 1; // -1 multiplier

    for (int permitted_col = 0; permitted_col < n; permitted_col++)
    {
        // Cofactor of A[permitted_row][permitted_col]
        int i = 0, j = 0, current_row, current_col, permitted_row = 0;
        for (current_row = 0; current_row < n; current_row++)
        {
            for (current_col = 0; current_col < n; current_col++)
            {
                if (current_row != permitted_row && current_col != permitted_col)
                {
                    temp.Mtrx[i][j++] = m.Mtrx[current_row][current_col];
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
        
        // Determinant
        result += sign * m.Mtrx[0][permitted_col] * determinant(temp, n - 1, true);

        // terms are to be added with alternate sign
        sign = -sign;
    }

    return result;
} else {
    return -9999;
}
}
    
}

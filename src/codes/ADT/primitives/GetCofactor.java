package codes.ADT.primitives;

import codes.ADT.*;

public class GetCofactor {
    public static void getCofactor(Matrix m, Matrix temp, int permitted_row, int permitted_col, int n) {
        // Cofactor of A[permitted_row][permitted_col]
        int i = 0, j = 0, current_row, current_col;
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
    }
}

Documentation for this dir
dir : src/codes/ADT/constructor

- `createMtrx.java` -> read & create defined Matrix
- `IsSquare.java` -> returning boolean for Matrix size
- `TimesDiagonal.java` -> returning the product of diagonal
- `Transpose.java` -> transpose of Matrix

1. createMtrx.java [
    function : return type Matrix
    - createMatrix() : return defined Matrix

    procedure : 
    - printMatrix(Matrix matrix) : printing Matrix to console

    * How to use printMatrix => `printMatrix(Matrix test);`
]

2. IsSquare.java [
    function : return type boolean
    - isSquare(Matrix matrix) : return true if matrix size is square.
    * How to use isSquare => `isSquare(Matrix test)`;
]

3. TimesDiagonal.java [
    function : return type float (double)
    - timesDiagonal(Matrix matrix, boolean isSquare) : return product of diagonal if matrix is square sized. (return 0 if not square sized)

    * How to use timesDiagonal => `timesDiagonal(Matrix test, isSquare(Matrix test));`
]

4. Transpose.java [
    function : return type Matrix
    - transpose(Matrix matrix) : return new Matrix

    * How to use transpose => `transpose(Matrix test);`
]
Documentation for this dir
dir : src/codes/ADT/constructor

- `createMtrxConsole.java` -> read & create defined Matrix from console
- `IsSquare.java` -> returning boolean for Matrix size
- `TimesDiagonal.java` -> returning the product of diagonal
- `Transpose.java` -> transpose of Matrix
- `CopyMtrx.java` -> copy the given Matrix
- `printMtrx.java` -> for displaying Matrix
- `createMtrxFile` -> read & create defined Matrix from input File

1. createMtrxConsole.java & createMtrxFile.java [
    function : return type Matrix
    - createMatrix() : return defined Matrix
]

2. IsSquare.java [
    function : return type boolean
    - isSquare(Matrix matrix) : return true if matrix size is square.
    * How to use isSquare => `isSquare(Matrix test);`
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

5. CopyMtrx.java [
    function : return type Matrix
    - copyMtrx(Matrix matrix) : return new copied for given Matrix

    * How to use copyMtrx => `copyMtrx(Matrix test);`
]

6. printMtrx.java [
    procedure : display the given Matrix
    - printMtrx(Matrix matrix) : display the given Matrix to console.

    * How to use printMtrx => `printMtrx(Matrix test);`
]
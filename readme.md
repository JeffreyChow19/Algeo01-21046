# Matrix Calculator - IF 2123
Tugas Besar 1 IF 2123 Aljabar Linier dan Geometri

## How to Run?
### MANUAL VIA TERMINAL:
1. Go to src : `cd src`
2. Compile in bin : `javac -d ../bin ./codes/*.java` 
3. `cd..`
4. Go to bin : `cd bin`
5. Run in bin : `java codes.mainProgram`
Suggestion : It is better to recompile due to the difference of Java version

### JAR FILE
1. Go to lib : `cd lib`
2. Run in lib : `java -jar "Tubes 1.jar"`

Note : 
- All class files will be inside the bin folder.



## Project Structure
```bash
src
│   readme.md
│
└───codes
    │   mainProgram.java
    │   readme.md
    │
    ├───ADT
    │   │   Matrix.java
    │   │   Param.java
    │   │   readme.md
    │   │
    │   ├───constructors
    │   │       createMtrx.java
    │   │       createMtrxConsole.java
    │   │       createMtrxFile.java
    │   │       printMtrx.java
    │   │       printMtrxConsole.java
    │   │       printMtrxFile.java
    │   │       readme.md
    │   │
    │   └───primitives
    │           CheckNeg0.java
    │           CopyMtrx.java
    │           GetCofactor.java
    │           IsSquare.java
    │           MakeSquare.java
    │           readme.md
    │           SwitchCol.java
    │           TimesDiagonal.java
    │           Transpose.java
    │
    ├───inputs
    │       inputBikubik.java
    │       inputDeterminan.java
    │       inputInvers.java
    │       inputPolynom.java
    │       inputSPL.java
    │       readme.md
    │
    └───methods
        │   Cramer.java
        │   determinant.java
        │   Gauss.java
        │   GaussJordan.java
        │   InterpolasiBicubic.java
        │   InterpolasiPolinom.java
        │   InverseCofactor.java
        │   InverseGaussJordan.java
        │   readme.md
        │   RegresiLinierBerganda.java
        │
        └───submethods
                menuCheck.java
                readme.md
                SPLCheck.java
```



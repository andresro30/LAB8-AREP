package edu.escuelaing.arep.server;

public class MatrixCalculator {


    public static void main(String[] args) {
        int[][] m1 = createMatrix(200);
        int [][] m2 = createMatrix(200);
        printMatrix(m1);
        System.out.println();
        printMatrix(m2);
        System.out.println();
        printMatrix(multiply(m1,m2));

    }

    public int[][] getResult(String tam){
        int size = Integer.parseInt(tam);
        return multiply(createMatrix(size),createMatrix(size));
    }

    public static int[][] multiply(int[][] matrixA, int[][] matrixB){
        int[][] result = null;

        if(matrixA != null && matrixB != null){
            int row = matrixA.length;
            int col = matrixB[0].length;
            result = new int[row][col];

            if(row == col){
                for(int i=0;i<row;i++){
                    for(int j=0;j< col; j++){
                        int value = 0;
                        for(int k=0;k<matrixA[0].length; k++){
                            value += matrixA[i][k] * matrixB[k][j];
                        }
                        result[i][j] = value;
                    }
                }
            }
            else
                System.out.println("Tamaños incorrectos");
        }
        return result;
    }

    public static void printMatrix(int[][] matriz){

        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(j== matriz[0].length -1)
                    System.out.print(matriz[i][j]);
                else
                    System.out.print(matriz[i][j]+",");
            }
            System.out.println();
        }
    }


    public String toStringMatrix(int[][] matriz){
        String matrix = "";
        for(int i=0;i<matriz.length;i++){
            matrix+= "\n Row "+i+": ";
            for(int j=0;j<matriz[0].length;j++){
                if(j== matriz[0].length -1)
                    matrix += String.valueOf(matriz[i][j]);
                else
                    matrix+= matriz[i][j]+",";
            }
        }

        return matrix;
    }


    public static int[][] createMatrix(int tam){
        int[][] matriz = new int[tam][tam];

        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                matriz[i][j] = (int)Math.ceil(Math.random()*(i+j));
            }
        }
        return matriz;

    }
}

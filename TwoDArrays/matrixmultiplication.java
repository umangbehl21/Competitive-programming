package TwoDArrays;

public class matrixmultiplication {
    public void  Mutliply(int[][] matrixA, int[][] matrixB)
    {
        int rowsA = matrixA.length;     //length of row is length of size of array means number of 1d arrays are in it
        int colsA = matrixA[0].length; //length of col is length of the 0th row of matrix
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        if(colsA != rowsB)
        {
            return;
        }
        int prd[][] = new int[rowsA][colsB];
        for(int i = 0;i<rowsA;i++)
        {
            for(int j = 0;j<colsB;j++)
            {
                for(int k = 0;k<colsA;k++)
                {
                    prd[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        for(int i = 0;i<rowsA;i++)
        {
            for(int j = 0;j<colsB;j++)
            {
                System.out.print(prd[i][j]+" ");
            }
            System.out.println();
        }
    }
 
}

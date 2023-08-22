package Arrays;

public class MakeMatrixRowAndColSumEqual {
        public static int findMinOperation(int N, int[][] matrix) { //https://practice.geeksforgeeks.org/problems/make-matrix-beautiful-1587115620/1
          
            int maxinMat = Math.max( maxfromrows(matrix,N),maxfromcols(matrix,N) ); //maximum sum in matrix means sum of any single column or row in the matrix which is greatest than any other row or colum sum 
            int maxbrc = -1; //max between row and col 
            int steps = 0;
            for(int i = 0;i<N;i++)
            {
                for(int j = 0;j<N;j++)
                {
                    int MaxSumRow = returnMaxSumOfRow(matrix,i,N);
                    int MaxSumCol = returnMaxSumOfCol(matrix,j,N);
                    maxbrc = Math.max(MaxSumRow,MaxSumCol);
                    int diff = maxinMat - maxbrc; //maximum sum in matrix - maximum sum between current row or column this difference gives us the number which we can add in our current element without making sum of current row or col greater than the maximum sum in matrix 
                    steps += diff;
                    matrix[i][j] += diff; //how much maximum num should we add in current element such that the current row and current column sum do not exceed the max sum of row or column in the matrix
                    maxbrc = -1;
                }
            }
            return steps;
        }
        public static int maxfromrows(int a[][],int N) //it will give the maximum sum from all the rows in the matrix 
        {
            int max = -1;
            int rsum = 0;
            for(int i = 0;i<N;i++)
            {
                for(int j = 0;j<N;j++)
                {
                    rsum += a[i][j];
                }
                max = Math.max(rsum,max);
                rsum = 0;
            }
            return max;
        }
         public static int maxfromcols(int a[][],int N) //it will give the maximum sum from all the columns in the matrix 
        {
            int max = -1;
            int csum = 0;
            for(int i = 0;i<N;i++)
            {
                for(int j = 0;j<N;j++)
                {
                    csum += a[j][i];
                }
                max = Math.max(csum,max);
                csum = 0;
            }
            return max;
        }
        public static int returnMaxSumOfRow(int [][]a,int rowno,int N) //it will give the sum of current row 
        {
            int rowsum = 0;
            
                for(int j = 0;j<N;j++)
                {
                    rowsum += a[rowno][j];
                }
            return rowsum;
        }
        public static int returnMaxSumOfCol(int [][]a,int colno,int N) //it will give the sum of current column 
        {
            int colsum = 0;
            for(int i = 0;i<N;i++)
            {
                colsum += a[i][colno];
            }
            return colsum;
        }
        
    }
            
    


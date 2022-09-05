package Graphs.LevelTwo;
import java.util.Scanner;

public class ColoringBorder {



                            //right,down,left ,up
    static int dircs[][] = {{0,1},{1,0},{0,-1},{-1,0}};  //directions in which calls are to be made 
    public static void MarkTheColoredOnes(int grid[][],int row,int col,int clr)  // clr is the element which we have to find them in the border and color them 
    {
        grid[row][col] = -clr; //to mark visited in the same array rather than seperate visited array we make the current element negative to mark that it is visited 
        int count = 0;
        for(int i = 0;i<4;i++)  //4 directions 
        {
        int RowDash = row + dircs[i][0];   //we travel downwards in direction array each time the row is increasing from 0 till 3 but column is either 0 or 1 
        int ColDash = col + dircs[i][1];
        
        if(RowDash < 0 || ColDash < 0 || RowDash >= grid.length || ColDash >= grid[0].length|| Math.abs(grid[RowDash][ColDash]) != clr)  //Mth.abs(of num) != clr because if we are viewing a visited element in array it will be have minus of its orignal number which we have made to mark element visited but it is the same number as our current number for example -2 <- 2 here -2 is made negative to mark that it is visited once but 2 is viewing -2 which if we don't take absolute of -2 then -2 will not be equal to 2 and current iteration will be skipped  but -2 was actually 2 in orignal array and both element were equal so thats why math.abs is taken to check the visited element is 
        {
            continue;
        }
        count++;
        if(grid[RowDash][ColDash] == clr)  //if element we are viewing is positive number equal to the current number then call on that unvisited index element 
        {
            MarkTheColoredOnes(grid,RowDash,ColDash,clr);
        }
        }
        if(count == 4)  //element which have same element in its all the 4 directions then make it return to normal positive integer it will not be colored  
        {
           grid[row][col] = clr;
        }
        
    }
    public static void ColorTheVisitedNumbers(int grid[][],int row ,int col,int colorThem)
    {
       MarkTheColoredOnes(grid, row, col, grid[row][col]); //index of the starting of bordedr is passed through row and col also element is passed of which border is to be find 
       for(int i = 0;i<grid.length;i++)
       {
        for(int j = 0;j<grid[0].length;j++)
        {
            if(grid[i][j] < 0)  //the visited numbers will be marked as minus of its orignal number which is the indicatiion to color them and change to another number 
            {
                grid[i][j] = colorThem;
            }
        }
       }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the row of grid");
        int row = sc.nextInt();
        System.out.println("enter the col of grid");
        int col = sc.nextInt();
        int grid[][] = new int[row][col];
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println("orignal array");
        for(int i = 0;i<grid.length;i++)  //orignal array 
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        ColorTheVisitedNumbers(grid, 1,1,3); 
        System.out.println("colored array");
        for(int i = 0;i<grid.length;i++)  
        {
            for(int j = 0;j<grid[0].length;j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
    } 
}

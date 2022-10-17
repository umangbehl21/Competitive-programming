package Graphs.LevelTwo;
import java.util.*;
public class NumberOFIslands2 {
    

    public static int FindNumberOfIslands2(int grid[][],int pos[][])
    {
        int dircs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        ArrayList<Integer> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int parent[] = new int[m * n];
        Arrays.fill(parent, -1);
        int count = 0;
        int rank[] = new int[m * n];
        for(int i = 0;i<pos.length;i++) //for traversing on position array rowwise 
        {
            int row = pos[i][0];
            int col = pos[i][1]; //cellno is used to convert 2-d index into 1-d
            int cellno = row * n + col;  //row * column length of grid array + col number in position array
            if(parent[cellno] != -1) //if same index is given twice in the position array then that index on the parent array will not be -1 it will be in a set and it will not change the count of island continue 
            {
                ans.add(count); //add the same count because same index will be pointing to the same island which is already being counted 
                continue;
            }
            parent[cellno] = cellno;  //if index is new then first make itself its own parent 
            rank[cellno] = 1; //height of single node will be 1 
            count++; //count it as a single island for now 
            for(int j = 0;j<dircs.length;j++)  //now we will check in the loop if there exists a neighbour which is neighbour to our current cellnumber then we will count them as 1 island by reducing count
            {
                int nextrow = row + dircs[j][0]; 
                int nextcol = col + dircs[j][1]; 
                int nextcellno = nextrow * n + nextcol; // n is number of columns in grid array 
                if(nextrow < 0 || nextcol < 0 || nextcol >= grid[0].length||nextrow >= grid.length||parent[nextcellno] == -1) //paren[cellno] == -1 means that if the neighbour of our current index is -1 or not an island then its parent array will also have -1 in it as it is not included any set if it was icluded then it will not have -1 it have either itself as parent or any other node  
                {
                    continue; //as neighbour is not an island
                }
                int px = find(cellno,parent); //parent array is made on the basis of cellnumbers 
                int py = find(nextcellno,parent); //cell number is the representation of our (row,col) index in a single number index example (1,2) in 7 
                if(px != py)
                {
                    if(rank[px] > rank[py])
                    {
                        parent[py] = px;
                    }
                    else if(rank[py] > rank[px])
                    {
                        parent[px] = py;
                    }
                    else 
                    {
                        parent[px] = py;
                        rank[px]++;
                    }
                    count--;
                }
            }


        }
        return count;
        

    }
    private static int find(int x, int[] parent) {
        if(parent[x] == x)
        {
            return parent[x];
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    public static void main(String[] args) {
        int grid[][] = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        int pos[][] = {{0,3},{1,2},{0,2},{1,4},{2,3},{1,3}};
        System.out.println(FindNumberOfIslands2(grid, pos));


    }
}

package Graphs;
import java.util.*;
public class BreadthFirstInput 
{
   public static void printBfs(int edges[][])
   {     
     //visited array is used because when there are two seperate components of graphs which are not connected to each other example 0 - > 1 is one graph and 2->3 another then 0 will be able to add 1 in queue  when it finds edges[0][1] as 1 but 0 or 1 will not be able to add 2 in queue as they are not connected to 2 so 2 will be seperately added in queue  when visited[2] will be found false 
     boolean visited[] = new boolean[edges.length];
     for(int i = 0;i<visited.length;i++)
     {
         if(!visited[i]) 
         {
         printBfsHelper(edges,i,visited);
         }
     }
   }
   private static void printBfsHelper(int[][] edges, int sv, boolean[] visited) 
   {
     Queue<Integer> queue = new LinkedList<>();
     queue.add(sv);
     while(!queue.isEmpty())
     {
        int front = queue.remove();
        System.out.println(front);
        visited[front] = true;
        for(int i = 0;i<edges.length;i++)
        {
            if(edges[front][i] == 1 && !visited[i])
            {
                queue.add(i);
                visited[i] = true;
            }
        }
     }
   }
public static void main(String[] args)
   {
       Scanner sc = new Scanner(System.in);
       System.out.println("enter the ending range or point till which vertices will lie");
       int n = sc.nextInt();
       System.out.println("emter the number of edges");
       int e = sc.nextInt();
       int edges[][] = new int[n][n]; //if there are two nodes 0,1 connect to each other on 0->1 index then 1->0 will also be one path this indicates that number of rows and columns are equal 
       for(int i = 0;i<e;i++)
       {
         System.out.println("enter start vertex between 0 to "+(n-1)); //because the number of rows and cols of edges array depends upon the range in which vertices lie we cannot give the start or end vertice value 5 or 6 if the index of rows and cols is from 0 to 3 it will cause index out of bound so we can only give value within range of array rows and cols 
         int sv = sc.nextInt();
         System.out.println("enter the end vertex between 0 to "+ (n-1)); 
         int ev = sc.nextInt(); //whatever will be the value of stard vertice and end vertice they will be set to that index in array example there is edge between 0 -> 1 the it will set on 0,1 index 
          edges[sv][ev] = 1; //1 indicates the path between the start vertex and end vertex 
          edges[ev][sv] = 1; //if there is path wetween 0->1 then its vice versa path is also there i.t 1->0
        }
        printBfs(edges);

   }
    
}

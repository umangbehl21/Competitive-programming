package Graphs;

import java.util.*;

public class DepthFirstInput {
    
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of vertices");  
        int n = sc.nextInt();
        System.out.println("enter number of edges");
        int e = sc.nextInt();
        int edges[][] = new int[n][n]; //if there are two nodes 0,1 connect to each other on 0->1 index then 1->0 will also be one path this indicates that number of rows and columns are equal 
        for(int i = 0;i<e;i++) //<e because we want to control the connections between vertices or nodes
        {
           System.out.println("enter start vertex ");
           int sv = sc.nextInt(); 
           System.out.println("enter end vertex");
           int ev = sc.nextInt();
           edges[sv][ev] = 1; //1 indicates the path between the start vertex and end vertex 
           edges[ev][sv] = 1; //if there is path wetween 0->1 then its vice versa path is also there i.t 1->0
        }
        printVertices(edges);
    }

    public static void printVertices(int[][] edges) {
       //visited array is used because when there are two seperate components of graphs which are not connected to each other 
       boolean visited[] = new boolean[edges.length]; //our largest element is the length of row as well as column of the edges array means for inserting element 1,5 we will need the 5th column as well as 5th row so our visited array will have index till the largest element in graph 
       for(int i = 0;i<visited.length;i++)
       {
        if(!visited[i])  // looping upon the number of elements if there are any seperate graph for example if two paths are 0->1 and 4->5 the visited array will have index till 0 to 5 so in the print function 0 will be able to find 1 or the path between 0 nad 1 but it cannot call on the 4->5 for that we will check that if visited array index is non visited then call print on it on the index 4 of visited array it will call print func and print 4 then after some iterations when edges[4][5] will be found 1 then print func will again call for the start vertex as 5 and 5 will be printed when loop reaches edge[5][4] then function will check if visited[4] is false but it will be true so print func with 4 as sv will not be called again avoiding toggle  
        {
            printhelper(edges,i,visited); //i will be the starting vertex if not visited   
        }
       }
    }

    private static void printhelper(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv); //printing the starting vertex
        visited[sv] = true; //by marking true to the start vertex we can avoid toggling by checking that whether we have visited the current element 
        for(int i = 0;i<edges.length;i++) // < edges.length because if 0->5 , 0 and 5 have link then loop will go till the 5th index  
        {
           if(edges[sv][i] == 1 && !visited[i]) //if there is path between two vertice and we are visiting that vertice first time means visited[i] is false then call for print 
           {
             printhelper(edges, i, visited);  
           }
        }

}
}

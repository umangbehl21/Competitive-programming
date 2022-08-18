package Graphs;

import java.util.ArrayList;

public class PrintAllPath {
    public static void PrintAllPathHelper(ArrayList<Edges> Vertices[],int src,int des,String path,boolean visited[])
    {
       if(src == des)  //if src become equal to des then our string contains a path to reach the ending vertice then print it 
       {
        System.out.println(path);
        return;
       }
       visited[src] = true;  //when we visit one vertice mark it true so that we can't visit it again from our neighbour's loop 
       for(Edges e : Vertices[src])  //from Vertices[src] we get the ArrayList and we traverse over edges which ArrayList contain 
       {
          if(visited[e.nbr] == false) //if the neighbour of the current vertice is not visited i.e its position is visited array is false then call on the neighbour 
          {
             PrintAllPathHelper(Vertices, e.nbr, des, path + e.nbr, visited); //add the current neighbour in the String too since it was never visited and added to String first time 
          }
       }
       visited[src] = false;  //during backtracking for some vertice loop is not finished but all the vertices are once visited but more path can be discover with vertices visited once so unvisit or false the visited vertices to make more paths 
    }
    public static void printAllPath(ArrayList<Edges> Vertices[],int src,int des)
    {
        boolean visited[] = new boolean[Vertices.length];  
        PrintAllPathHelper(Vertices,src,des,src+"",visited); 
    }
    public static void main(String[] args) {
       ArrayList<Edges> Vertices []= AdjacencyListImplementation.AdjacencyListImplementationInp();
       printAllPath(Vertices,Vertices[0].get(0).src, Vertices[Vertices.length-1].get(0).src);
    }       //from vertices[0] we get the 0th position ArrayList and on that ArrayList on the index 0 src is the begining vertice of the graph and from the Verices[Vertices.length - 1] we get the ending ArrayList and on its 0th index ending vertice of the graph is present 
}
           //Vertices[0].get(0).src, Vertices[Vertices.length-1].get(0).src
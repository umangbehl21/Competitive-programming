package Graphs;

import java.util.*;

public class IsGraphConnected 
{
  static boolean ans = false;
  public static boolean IsGraphConnectedHelper(ArrayList<Edges> Vertices[],int src,boolean Visited[])
  {
    if(src == Vertices.length-1) //if src becomes equal to the last index means we have reach the last vertice of graph means whole graph is connected 
    {
        return true;
    }
     Visited[src] = true;
     for(Edges e : Vertices[src])
     {
        if(!Visited[e.nbr])
        {
           ans = IsGraphConnectedHelper(Vertices, e.nbr, Visited);
        }
     }
      if(ans == true)  //if ans is recieved true from the last vertice or the end of the graph then every vertice will collect that true and return it 
      {
        return true; 
      }
      else  //if ans is false return false 
      {
        return false;
      }
  }
  public static boolean IsGraphconnected(ArrayList<Edges> Vertices[],int src)
  {
    boolean fans = false;
    boolean Visited[] = new boolean[Vertices.length];
          fans = IsGraphConnectedHelper(Vertices, src,Visited);  //we will call only once and pass the starting of the graph if the graph is connected helper function will itself return true else it will return false and we will not call on the unconected componnent of the graph by traversing the visited array 
          if(fans == true)
          {
             return true;
          }
          else
          {
          return false;
          }
  }
  public static void main(String[] args) {
    ArrayList<Edges> Vertices[] = AdjacencyListImplementation.AdjacencyListImplementationInp();
    System.out.println(IsGraphconnected(Vertices, Vertices[0].get(0).src));
  }


}

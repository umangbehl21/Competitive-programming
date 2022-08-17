package Graphs;
import java.util.*;
public class HasPath 
{
   public static boolean HasPathhelper(ArrayList<Edges> Verteces[] ,int src,int des,boolean visited[])
   {
      if(src == des)  //if src becomes equal to destination return true 
      {
         return true;
      }
      visited[src] = true;  //marking visited true for the current source so that if we come again at this source we can't call it again and again 
      for(Edges e : Verteces[src])  //veteces[] is an Array containing ArrayLists by doing Verteces[src] we got the ArrayList full of edges of a particular index and then we will be iterating over ArrayList which contains edges
      {
         if(visited[e.nbr] == false) //if for the neihbour first time call is being made then visited will be false and calll will be transfer to neighbour if second time we have come to neighbour visited will be true so call will not be transfer to neighbour 
         {
          boolean HasPath = HasPathhelper(Verteces, e.nbr, des, visited); 
          if(HasPath == true)  //ifneighbour can reach destination source can also reach return true 
          {
             return true;
          }
         }
      }
      return false;
   }
   public static boolean hasPath(int src , int des,ArrayList<Edges>[] Verts)
   {
      boolean visited[] = new boolean[Verts.length];
      return HasPathhelper(Verts, src, des, visited);
   }
    public static void main(String[] args) {
      ArrayList<Edges>[] Verts = AdjacencyListImplementation.AdjacencyListImplementationInp();
      System.out.println(hasPath(0,6,Verts));
    }
   }

package Graphs;
import java.util.*;
class Edges
{
    int src = 0;
    int des = 0;
    int wght = 0;
    Edges(int src,int des,int wght)
    {
       this.src = src;
       this.des = des;
       this.wght = wght;
    }
}
public class AdjacencyListImplementation {  //Adjacency list have an array of ArrayList which stores edges connecting different vertices 
    public static ArrayList<Edges>[] AdjacencyListImplementationInp()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertices"); 
        int verts = sc.nextInt(); 
        ArrayList<Edges> Vertices[] = new ArrayList[verts]; //our array will contain data of type ArrayList which initially have null so we have to put ArrayList equal to the number of vertices we have
        for(int i = 0;i<verts;i++)
        {
            Vertices[i] = new ArrayList<Edges>(); //explicitly adding ArrayList in our array because currently it have null in all position and we won't be able to add edges in null[0].add()
        }
        System.out.println("enter the number of edges");
        int edges = sc.nextInt();
        for(int i = 0;i<edges;i++)
        { 
          System.out.println("enter the start vertex from 0 to"+(verts-1)); //0 to vertices - 1 are the only index which are available to store the edges in vertices ArrayList if i am saying there are total 7 verices then they are stores on their respective index in the array 1st vertice will be stores on 1st index in the array 
          int src = sc.nextInt();
          System.out.println("enter the end vertex from 0 to"+(verts - 1));
          int des = sc.nextInt();
          System.out.println("enter the weight between them");
          int wght = sc.nextInt();
          Vertices[src].add(new Edges(src, des , wght)); //if there is path b/w 0 -> 2 then there will be path from 2-> 0 too so first adding vertices[0].(new Edges(0,1,10)) then adding vertices[1].add(new Edges(1,0,10))
          Vertices[des].add(new Edges(des, src, wght));
        }
        return Vertices;
     }
     
}

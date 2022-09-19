package Graphs.LevelTwo;
import java.util.*;
public class KahnsAlgo  //topolical sorting this also is only applied on the direct edges and acyclic graph because in a undirected graph the edges is two way eg 0->1 and 1->0 so 1 wants 0 to compile first and on the other hand 0 wants 1 to compile first no vertice is independent in an cyclic graph 1->2 , 2->3 , 3->1 2 wants 1 to compile first 3 wants 2 to compile first 1 wants 3 to compile first this cycle will never end do it is not possble to use this algo in acyclic because everyone is dependent to each other 
{ 
    
 public static int[] OrderOfCompilation(ArrayList<Integer> graph[])  //files having no neighbour files are independent and can be compiled first 
 {
      int dependency[] = new int[graph.length];
      int ans[] = new int[graph.length];
      for(int i = 0;i<graph.length;i++)
      {
         for(int nbr : graph[i])  //g[0] = <3,2> traversing on neighbours and making that how many files they are dependent on 
         {
            dependency[nbr]++;  
         }
      }
      Queue<Integer> pendingnodes = new LinkedList<>(); 
      for(int i = 0;i<dependency.length;i++)
      {
        if(dependency[i] == 0)
        {
            pendingnodes.add(i);
        }
      }
      int idx = 0;
      while(!pendingnodes.isEmpty())
      {
        int front = pendingnodes.remove();
        ans[idx] = front;
        idx++;
        for(int nbr : graph[front])
        {
           dependency[nbr]--;
           if(dependency[nbr] == 0)
           {
             pendingnodes.add(nbr);
           }
        }

      }
      if(idx == graph.length)
      {
        return ans;
      }
      else {
        return new int[]{-1};
      }
 }
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("enter the number of vertices");
     int verts = sc.nextInt();
     System.out.println("enter the number of edges");
     int edges = sc.nextInt();
     ArrayList<Integer> graph[] = new ArrayList[verts];
     for(int i = 0;i<verts;i++)
     {
        graph[i] = new ArrayList<>();
     }
     for(int i = 0;i<edges;i++)
     {
         System.out.println("enter the startvertex");
         int sv = sc.nextInt();
         System.out.println("enter the endvertex");
         int ev = sc.nextInt();
         graph[sv].add(ev); //direct edges 
     }
     int arr[] = OrderOfCompilation(graph);
     for(int i : arr)
     {
        System.out.println(i);
     }
     
 }
}

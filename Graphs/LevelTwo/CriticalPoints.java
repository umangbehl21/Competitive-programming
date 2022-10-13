package Graphs.LevelTwo;
import java.util.*;
public class CriticalPoints {
    static int time = 0;
    static int parent[];  //stores parent
    static int low[];   //stores the least time 
    static int disc[];
    static boolean visited[];
    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();
    public static void bridges(List<List<Integer>> graph,int src)
    {
        time++;
        low[src] = time;
        disc[src] = time;
        visited[src] = true;
        for(int nbr : graph.get(src))
        {
            if(parent[src] == nbr)
            {
                continue;
            }
            else if(visited[nbr] == true)
            {
                low[src] = Math.min(disc[nbr], low[src]);
            }
            else 
            {
                parent[nbr] = src;
                bridges(graph, nbr);
                low[src] = Math.min(low[src],low[nbr]);
                  //difference in critical point and articulation point is that in articulation point we remove edges and its all edges to check if graph can become disconnected but in to find bridges we have to remove a single edge at a time rather than a whole vertice and its edges 
                  if(low[nbr] > disc[src])  //if the min time of nbr to remain connected to graph is greater to the discovery of src it means it nbr is tottally dependent on the src to remain connected to the graphas its discovery is after the source 
                  {
                     list = new ArrayList<>();
                     list.add(src);
                     list.add(nbr);
                     ans.add(list);
                  }
            
            }

        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertices");
        int v = sc.nextInt();
        System.out.println("enter the number of edges");
        int e = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;i<v;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<e;i++)
        {
            System.out.println("enter the sv");
            int sv = sc.nextInt();
            System.out.println("enter the nbr vertice");
            int nbr = sc.nextInt();
            graph.get(sv).add(nbr);
            graph.get(nbr).add(sv);
        }
        disc = new int[v];
        parent = new int[v];
        low = new int[v];
        visited = new boolean[v];
        bridges(graph, 0);
        System.out.println(ans);

    }

}

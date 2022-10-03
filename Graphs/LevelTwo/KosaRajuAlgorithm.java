package Graphs.LevelTwo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class KosaRajuAlgorithm //This algorithm helps to find us the strongly connected components in directed graph 
{
    static Stack<Integer> st = new Stack<>();
    public static void dfs(ArrayList<Integer>[] graph,boolean visited[],int src)
    {
        visited[src] = true;
        ArrayList<Integer> nbrs = graph[src];
        for(int nbr : nbrs)
        {
          if(visited[nbr] == false)
          {
            dfs(graph, visited, nbr);
          }
        }
        st.add(src);
    }
    public static void dfs2(ArrayList<Integer>[] graph2,boolean visited2[],int src)
    {
        visited2[src] = true;
        ArrayList<Integer> nbrs = graph2[src];
        for(int nbr : nbrs)
        {
            if(visited2[nbr] == false)
            {
                dfs2(graph2, visited2, nbr);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total vertices");
        int v = sc.nextInt();
        ArrayList<Integer> graph[] = new ArrayList[v];
        for(int i = 0;i<v;i++)
        {
            graph[i] = new ArrayList<>();
        }
        System.out.println("enter the total edges");
        int e = sc.nextInt();
        for(int i = 0;i<e;i++)
        {
            System.out.println("enter the start vertice");
            int sv = sc.nextInt();
            System.out.println("enter the neighbour");
            int nbr = sc.nextInt();
            graph[sv].add(nbr);
        }
        boolean visited[] = new boolean[v];
        //Step 1 ->Random dfs from any vertice and adding the elements in stack before backtracking now for any case on the top of the stack there will be vertice which is closest to the starting part of the problematic edge means we have that vertice on the top from which we can travel the other connected components too which we donnot want because we have to count subcycles when there is one edge connecting two subgraph so now reverse the whole graph by doing this problematic edge will be reversed and we will lose the path to travel other subgraph and we can count our subgraph as 1 and other graph can also consider them seperate connected components  
        for(int i = 0;i<graph.length;i++)
        {
            if(visited[i] == false)
            dfs(graph,visited,0);
        }
        ArrayList<Integer> graph2[] = new ArrayList[graph.length]; 
        for(int i = 0;i<graph2.length;i++)
        {
            graph2[i] = new ArrayList<>();
        }
        //Step 2 -> reversing the graph
        for(int i = 0;i<v;i++)  //outer loop extract the arraylist of graph1 where i referss to the source vertice and nbrs ArrayList have its neighbours inner loop travels on the neighbours and in the graph2 we make neighbours as a source vertice and adding the old graph source vertice as neighbour in order to reverse a graph       
        {
            ArrayList<Integer> nbrs = graph[i];
            for(int nbr : nbrs)
            {  
                graph2[nbr].add(i);
            }
        }
        boolean visited2[] = new boolean[graph2.length];
        int ans = 0;
        //Step 3 -> calling dfs on the stack elements 
        while(!st.isEmpty())
        {
            int front = st.pop();
            if(visited2[front] == false) 
            {
                dfs2(graph2,visited2,front);
                ans++;
            }
            
        }
        System.out.println(ans);

    }
}

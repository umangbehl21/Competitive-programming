package Graphs;

import java.util.*;

public class OrderOfCompilationTopolicalSort 
{   
    static class Edge
    {
        int src = 0;
        int nbr = 0;
        Edge(int src,int nbr)
        {
           this.src = src;
           this.nbr = nbr;
        }
    }
    public static ArrayList<Edge>[] UniDirectionalPathInput()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of vertices");
        int v = sc.nextInt();
        ArrayList<Edge> graph[] = new ArrayList[v];
        for(int i = 0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }
        System.out.println("enter the number of edges");
        int e = sc.nextInt();
        for(int i = 0;i<e;i++)
        {
           System.out.println("enter start vertice between 0 to"+(e-1));
           int sv = sc.nextInt();
           System.out.println("enter end vertice between 0 to"+(e-1));
           int ev = sc.nextInt();
           graph[sv].add(new Edge(sv, ev));  //unidirectional edge 
        }
        return graph;
    }
    static Stack<Integer> stack = new Stack<>();
    public static void TopologicalSortHelper(ArrayList<Edge> graph[],boolean visited[],int src)  //Topological sort is the permutation of the vertices connected together in an acyclic manner having an unidirectional or direct edge between them and if a vertice is dependent on its neighbour vertice then it should get printed before the neighbour vertice  example if 1->2 here 1 have a direct edge to 2 but 2 don't have so 1 is a dependent vertice it will be printed first and 2 will be printed after 1 
    {
        visited[src] = true;
        for(Edge e : graph[src])
        {
              if(visited[e.nbr] == false)
              {
                 TopologicalSortHelper(graph,visited, e.nbr);
              }
        }
        stack.push(src);   //edge with no neighbour will be added first and then the dependent vertice will be added so that dependent vertice is printed first according to Lifo 

    }
    public static void TopologicalSort(ArrayList<Edge> graph[],int src)
    {
        boolean visited[] = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++)
        {
            if(visited[i] == false)
            {
                TopologicalSortHelper(graph, visited, i);
            }
        }
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = UniDirectionalPathInput();        
        TopologicalSort(graph,graph[0].get(0).src);
    }

}

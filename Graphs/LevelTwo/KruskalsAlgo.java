package Graphs.LevelTwo;
import java.util.*;
public class KruskalsAlgo 
{
    static class Edges implements Comparable<Edges> // the prerequisite of this question is union and disjoint set which helps minimum spanning tree to maintain its acyclic property
    {
       int src;
       int nbr;
       int wt;
       Edges(int src,int nbr,int wt)
       {
          this.src = src;
          this.nbr = nbr;
          this.wt = wt;
       }
    @Override
       public int compareTo(Edges o) {
          if(this.wt < o.wt) return -1;

          else if(this.wt > o.wt) return 1;

          else return 0;
       }
    }
    public static int parent[];
    public static int rank[];
    public static int find(int x)
    {
        if(parent[x] != x)
        {
           parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public static void union(int a,int b)
    {   
        if(rank[a] < rank[b])
        {
           parent[a] = b;      
        }
        else if(rank[a] > rank[b])
        {
            parent[b]= a;
        }
        else
        {
            parent[b] = a;
            rank[a]++;
        }
    }
    public static int KruskalsAlgorithm(ArrayList<Edges> graph[])
    {
        ArrayList<Edges> edges = new ArrayList<>();
        for(int i = 0;i<graph.length;i++)  //outer loop will traverse on the ArrayLists containing edges
        {
            for(Edges ed : graph[i]) //inner loop will traverse on a particular index ArrayList and add the edges in the edges ArrayList 
            {
              edges.add(ed);
            }
        }
        Collections.sort(edges);  //sorting the edges ArrayList so that minimum spanning tree add the minimum weight edges first 
        int ans = 0;
        int count = 0;
        for(int i = 0;count < graph.length-1;i++)  //minimum spanning tree have v - 1 vertices if graph have total of v vertices it will have v-1 to avoid cycle in the tree 
        {   
            Edges edge = edges.get(i);  //extracting edge from the edges ArrayList 
            int a = find(edge.src);     //finding the representative parent of the source of the edge 
            int b = find(edge.nbr);     //finding the representative parent of the neighbour of the edge 
            if(a != b)  //if the representative parent of the both the nodes are same then they are in same set no need to union otherwise if they are not same then perform union and bring them in one set 
            {
                union(a, b);
                ans += edge.wt;  //add the edge weight which are now in one set 
                count++;  //increase the count as we have included one edge in the set or minimum spanning tree 
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of Vertices");
        int v = sc.nextInt();
        ArrayList<Edges> graph[] = new ArrayList[v];
        for(int i = 0;i<graph.length;i++)
        {
            graph[i] = new ArrayList<>();
        }
        System.out.println("enter the number of edges");
        int e = sc.nextInt();
        for(int i = 0;i<e;i++)
        { 
            System.out.println("enter the start vertice from 0 to"+(v-1));
            int sv = sc.nextInt();
            System.out.println("enter the end vertice from 0 to"+(v-1));
            int ev = sc.nextInt();
            System.out.println("enter the weight between them");
            int wt = sc.nextInt();
            graph[sv].add(new Edges(sv, ev, wt));  //since the minimum spanning tree works only on directed , acyclic graph we will add only 1 edge 
        }
        parent = new int[v];
        for(int i = 0;i<parent.length;i++)
        {
            parent[i] = i;
        }
        rank = new int[v];
        System.out.println(KruskalsAlgorithm(graph));

        
    }
    

}

import java.util.*;
import java.io.*;

public class RedundantConnectionTwo {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);

    int[][] pos = new int[n][2];
    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      pos[i][0] = Integer.parseInt(st[0]);
      pos[i][1] = Integer.parseInt(st[1]);
    }

    int[] ans = findRedundantDirectedConnection(pos);
    System.out.println(ans[0] + " " + ans[1]);
  }
  public static int find(int u)
  {
      if(parent[u] == u) return u;
      
      parent[u] = find(parent[u]);
      return parent[u];
  }
  public static boolean union(int u,int v)
  {
      int pu = find(u);
      int pv = find(v);
      if(pu != pv)
      {
      if(rank[u] > rank[v])
      {
          parent[v] = u;
      }
      else if(rank[u] < rank[v])
      {
          parent[u] = v;
      }
      else 
      {
          parent[v] = u;
          rank[u]++;
      }
      return false;
    }
    else 
    {
        return true;
    }
  }
  static int parent[];
  static int rank[];
  public static int[] findRedundantDirectedConnection(int[][] edges) {
     int n = edges.length;
     int indegree[] = new int[edges.length+1];  //1 based indexing for 5 edges we should have 0 to 5 indexes so length should be 5 + 1 i.e 6
     Arrays.fill(indegree,-1);
     int ledge = -1;
     int fedge = -1;
     for(int i =0;i<n;i++)
     {
         int u = edges[i][0];
         int v = edges[i][1];  //indegree edge is the incoming edge start from u -> v example 1-> 2 , 2 have incoming edge from 1 so we have to record the indegree of index 2 or v
         if(indegree[v] == -1)
         {
             indegree[v] = i;
         }
         else 
         {
             fedge = indegree[v]; // if a node have two indegree or two incoming edges indicating it is children to two nodes then store the former edge no as well as later edge number
             ledge = i;
             break;
         }
     }
     parent = new int[n+1];
     rank = new int[n+1];
     for(int i = 0;i<n;i++)
     {
         parent[i] = i;
         rank[i] = 1;
     }
     for(int i = 0;i<n;i++)
     {
         if(i == ledge)
         {
             continue;
         }
         int u = edges[i][0];
         int v = edges[i][1];
         boolean flag = union(u,v);
         if(flag == true)
         {
             if(ledge == -1) //if later edge is -1 means that there is only a cycle in graph and do not have two parents then simply return edge making cycle
             {
                return edges[i];  //case 2
             }
             else  //else if later edge is not -1 means that some node have two parent or some incoming second later edge then return the former edge because we have found cycle without traversing till the last edge which means the former edge which was connected first created the cycle
             {
                 return edges[fedge]; //case 3
             }
         }
         
     }
     return edges[ledge];  //case 1 and case 3
  }

}


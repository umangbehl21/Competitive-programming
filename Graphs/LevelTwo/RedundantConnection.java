
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class RedundantConnection {
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

        int[] ans = findRedundantConnection(pos);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int par[] = new int[edges.length + 1]; //1 based indexing
        int rank[] = new int[edges.length + 1];
        for(int i = 1;i<par.length;i++)
        {
            par[i] = i;
            rank[i] = i;
        }
        for(int edge[] : edges)
        {
            int pu = edge[0];
            int pv = edge[1];
            if(pu != pv)  //if the elements don't have same parent then merge it into a same set if the elements already have same parent means they are in the same set already means that is the redundant edge between two element that make it graph from a tree return that edge 
            {
                if(rank[pu] > rank[pv])
                {
                    par[pv] = pu;
                }
                else if(rank[pu] < rank[pv])
                {
                    par[pu] = pv;
                }
                else 
                {
                    par[pv] = pu;
                    rank[pu]++;
                }
            }
            else //if the elements already have same parent means they are in the same set already means that is the redundant edge between two element that make it graph from a tree return that edge 
            {
                return edge; 
            }
            
        }
        return new int[2];
      }

    private static int find(int[] parent, int f) {
        if (f == parent[f]) {
            return f;
        }
        parent[f] = find(parent, parent[f]);
        return parent[f];
    }
}}

package Graphs.LevelTwo;

import java.util.Arrays;

public class RemoveMaxEdges { //remove max edges but graph should be still traversable by both alice and bob
    public static boolean union(int u,int v,int parent[],int rank[])
    {
        int a = find(u,parent);
        int b = find(v, parent); 
        if(a!=b)
        {
            if(rank[a] < rank[b]) //rank acts like height if height of a tree is greater than the other tree's height them the greater tree root become parent of the smaller tree node 
            {
                parent[a] = b; 
            }
            else if(rank[b] < rank[a])
            {
                parent[b] = a;
            }
            else 
            {
                parent[a] = b;
                rank[a]++;
            }
            return true;
        }
        return false;
    }
    public static int find(int x,int parent[])
    {
        if(x == parent[x])
        {
            return parent[x];
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    public static int MaxRemove(int edges[][],int tv)
    {
        Arrays.sort(edges,(a,b)->Integer.compare(b[0], a[0])); //sorting on the basis of type where type 3 edges will be given priority as it solves the issue for both bob and alice
        int parenta[] = new int[tv+1]; //1 based indexing
        int parentb[] = new int[tv+1];
        int ranka[] = new int [tv+1];
        int rankb[] = new int [tv+1];
        for(int i = 0;i<tv;i++)
        {
            parenta[i] = i;
            parentb[i] = i;
            ranka[i] = 1;
            rankb[i] = 1;
        }
        int mergeda = 1; //at one union operation two nodes are merges so mergeda and mergedb intitally starts from 1 example ef we have to merge 1,2,3 then to merge 1 and 2 two nodes are merges so if we start from 0 and increment merge it will show that one node is merged so that's why inital value of mergea is 1 
        int meregedb = 1;
        int removeedge = 0;
        for(int e[] :edges)  //traversing on the 1-d arrays
        {
            if(e[0] == 3)
            {
                boolean ma = union(e[1], e[2], parenta, ranka);
                boolean mb = union(e[1],e[2],parentb,rankb);
                if(ma == true)
                {
                    mergeda++;
                }
                if(mb == true)
                {
                    meregedb++;
                }
                if(!ma && !mb)
                {
                    removeedge++;
                }
            }
            if(e[0] == 1)
            {
                boolean ma = union(e[1],e[2], parenta, ranka);
                if(ma == false)
                {
                    removeedge++;
                }
                else 
                {
                    mergeda++;
                }
            }
            if(e[0] == 2)
            {
              boolean  mb = union(e[1],e[2], parentb, rankb);
              if(mb == false)
              {
                removeedge++;
              }
              else 
              {
                meregedb++;
              }
            }
            if(mergeda !=tv || meregedb != tv) //if all the vertices of alice or bob is not equal to the total vertice then return -1
            {
                return -1;
            }
        }
        return removeedge;
    }
    
}

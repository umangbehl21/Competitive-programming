package Graphs.LevelTwo;
import java.util.*;
public class ArticulationPoint //Articulation point is that vertice which along with its edges when removed seperate the graph into two or more components 
{
    static int disc[]; //records when a following vertice is discovered
    static int low[]; //records the least distance a vertice can take to reach other vertice if this least distance of a vertice is somewhow less than the vertice which is discovered before it then this means there is some another path or back edge to whom it is connected other than a single path means even if we remove current vertice it will still remain connected to the graph so such vertice is not an articulation point 
    static int parent[]; //it will keep record of the parent of the vertices as the graph is undirected the child will try to call for parent but we will handle it in a condition that if we are calling on parent then continue
    static boolean ap[];
    static int time = 0;
    static boolean vis[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        System.out.println("enter the number of vertices");
        int v = sc.nextInt();
        System.out.println("enter the number of edges");
        int e = sc.nextInt();
        for(int i = 0;i<v;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int i =0;i<e;i++)
        {
            System.out.println("enter start vertice");
            int sv = sc.nextInt();
            System.out.println("enter neighbour vertice");
            int nbr = sc.nextInt();
            graph.get(sv).add(nbr);
            graph.get(nbr).add(sv);
        }
        disc = new int[v];
        ap = new boolean[v];
        parent = new int[v];
        low = new int[v];
        vis = new boolean[v];
        parent[0] = -1;
        dfs(0,graph);
        System.out.println("total ap");
        int count = 0;
        for(int i = 0;i<ap.length;i++)
        {
            if(ap[i] == true)
            {
                count++;
            }
        }
        System.out.println(count);
    }
    private static void dfs(int src, ArrayList<ArrayList<Integer>> graph) 
    {
        disc[src] = time;
        low[src] = time;
        time++;
        vis[src] = true;
        int count = 0;
        ArrayList<Integer> nbrs = graph.get(src);
        for(int i = 0;i<nbrs.size();i++)
        {
            int nbr = nbrs.get(i);
            if(nbr == parent[src]) //if the child is trying to call dfs on the neighbour which is its parent then continue as that path is already been covered 
            {
                continue;
            }
            else if(vis[nbr] == true)  //else if our neighbour is already being visited and we are coming on it second time then we have discovered a second path to remain connected to the cycle 
            {
                low[src] = Math.min(low[src], disc[nbr]);  //now in order to find the second path or the vertice to which src is connected we will take the minimum between our current least path and the newly discovered path whichever will be the minimum will update the least path to stay connected to graph 
            }
            else  //if the upper two condition is false then we can conclude that we are calling an undiscovered path or childrens 
            {
                parent[nbr] = src; //before calling to the neighbour make the source parent of the neighbour to whom we are going to call 
                count++;
                dfs(nbr, graph);
                low[src] = Math.min(low[src], low[nbr]);       //while backtracking if our nbr or child has discovered some path which is lesser than current least path which source has then update the least path of source too as if child can take that path then parent can also 
                
                //during backtracking we will also check that current source is articulation point or not
                
                if(parent[src] == -1) //the low[nbr] >= disc[src] don't work for the initial or starting vertice of graph because sometimes the discovery distance of source is equal to the low of its distance of its neighbour if the cycle is present starting from source and ending on source so we keep track on the number of times src is calling dfs for example if graph is 1->2 and 1->3 now first 1 will call dfs on 2 then call will backtrack and then it will call for 3 which means that they are not in a same path the count of dfs will be 2 which make src articulation point if we remove source then the 2 and 3 will become seperate components but if graph is 1->2 ,2->3 ,3->1 then dfs call from 1 will only backtrack after covering whole graph dfs count will be 1 which means if we remove src then 2 and 3 will still remain connected 
                {                                                                                                                                                                                                                                                                                                                                                                       
                    if(count >1)   
                    {
                        ap[src] = true;
                    }
                }
                //during backtracking we will also check that current source is articulation point or not which can be checked now because if the least path of the child is still greater or equal to the path discovered by source or parent then it will means that it completely depends on the single path of its parent and is unable to find any other part which makes parent articulation point on the other hand if the least path of child is less than the path discovereed by parent and it can still be connected to the graph by that least path means it is not merely dependent on the path of its parent then parent cannot be articulation point 
                else 
                {
                if(low[nbr] >= disc[src])
                {
                    ap[src] = true;
                }
                }   
            }
        }

    }
}

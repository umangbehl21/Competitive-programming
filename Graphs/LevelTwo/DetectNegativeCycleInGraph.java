package Graphs.LevelTwo;
import java.util.*;
public class DetectNegativeCycleInGraph 
{
    public static void detectNegativeCycleInGraph(int arr[][],int vtcs,int edges)
    {
        int path[] = new int[vtcs];
        for(int i= 1;i<path.length;i++)
        {
            path[i] = Integer.MAX_VALUE;
        }
        for(int i = 1;i<=vtcs-1;i++)  //if graph is like this 0->1->2->3 if for i = 1th iteration shortest path from 0 to 1 is recorded rest all are still Max value then when further i will increment to 2 then 2nd vertice distance will be found and when i is 3 finally 3rd vertice distance is found but there were 4 vertices in actual so we can notice to calculate distance till the end node 3 iterations were required so i will start from 1 as for 0th vertice distance is 0 as it is the start for so i will start from 1st vertice means i = 1 iteration and end at the totalvertices - 1 = 3 
        {
            for(int j = 0;j<edges;j++)
            {
                int src = arr[j][0];
                int nbr = arr[j][1];
                int wt = arr[j][2];
                if(path[src] == Integer.MAX_VALUE)  //suppose the node from which we have to find the distance have max value and the distance between the source node and the nbr is -5 or some negative number now path[src] +(-5) < path[nbr] the path[nbr] also have maxvalue now max value of src will be reduced by 5 which will be less than the nbr max value and it will assign that distance to the nbr which will be a wrong distance so the node from which we have to find the distance to neighbour must not have max value 
                {
                    continue;
                }
                if(path[src] + wt < path[nbr])
                {
                    path[nbr] = path[src] + wt;
                }
            }
        }
          for(int j = 0;j<edges;j++)
            {
                int src = arr[j][0];
                int nbr = arr[j][1];
                int wt = arr[j][2];
                if(path[src] == Integer.MAX_VALUE) 
                {
                    continue;
                }
                if(path[src] + wt < path[nbr])
                {
                   System.out.println("negative cycle detected"); //as we know that bellmanford don't work on the negative cycle as the distance of src keeps on decreasing even after vertices - 1 iteration where every node is destined to find its shortest path then print negative cycle return algo is not possible
                   return;
                }
            }
        System.out.println("no cycle detected");
    }
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("enter the numbere of edges");
		int edges = sc.nextInt();
        System.out.println("enter the number of vertices");
        int vtcs = sc.nextInt();
		int arr[][] = new int[edges][3];
	    for(int i = 0;i<edges;i++)
        {
            System.out.println("enter the source vertice");
            int src = sc.nextInt();
            System.out.println("enter the neighbour vertice");
            int nbr = sc.nextInt();
            System.out.println("enter the weight between them");
            int wt = sc.nextInt();
            arr[i][0] = src;
            arr[i][1] = nbr;
            arr[i][2] = wt;
        }
        detectNegativeCycleInGraph(arr, vtcs, edges);
    }
}

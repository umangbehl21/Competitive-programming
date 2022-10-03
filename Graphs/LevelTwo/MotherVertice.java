package Graphs.LevelTwo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class MotherVertice {   //Kosaraju appllication vertice from which all connected components can be visited
    	public static void main(String args[]) throws Exception {  

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");  //input number in one based indexing it will be converted into 0 based
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>graph)
    {
	    Stack<Integer> st = new Stack<>();
	    boolean visited[] = new boolean[N];
	    for(int i = 0;i<visited.length;i++)
	    {
	        if(visited[i] == false)
	        {
	           dfs(st,visited,i,graph);
	        }
	    }
	    Arrays.fill(visited,false);
	    int top = st.pop(); //the top element present in the stack it always faces towards the start point of the problemaatic edge and have an passage to enter other components of the graph so if we call dfs from there and there is no problematic edge between other components then we can return the stack top element that is the mother vertice from which we can travel through whole graph but if we can't travel then there should be that vertice which will be marked false or unvisited in the visited array if there is 2 problematic edge in the whole graph then we will not be able to travel whole graph
	    dfsOnStackTopElem(visited,graph,top);
	    for(int i = 0;i<visited.length;i++)
	    {
	        if(visited[i] == false)  //if any element is not being able to get visited by the dfs call on stack top element which should have passage to go to all connected components of graph then return -1 there is an problematic edge means if graph is 1->2->3<-4 4 to 3 is the problematic edge 4 cannot visit 2 and 1 return -1 
	        {
	            return -1;
	        }
	    }
	    return top + 1; //as indexing is converted into 0 based but we have to return answer in 1 based indexing so return top + 1 
    }
    public static void dfs(Stack<Integer> st,boolean [] visited,int src, ArrayList<ArrayList<Integer>>graph)
    {   
        if(visited[src] == false)
        {
            visited[src] = true;
            ArrayList<Integer> nbrs = graph.get(src);
            for(int nbr : nbrs)
            {
                if(visited[nbr] == false)
                {
                    dfs(st,visited,nbr,graph);
                }
            }
        }
        st.add(src);
    }
    public static void dfsOnStackTopElem(boolean visited[],ArrayList<ArrayList<Integer>> graph,int src)
    {
        if(visited[src] == false)
        {
            visited[src] = true;
            ArrayList<Integer> nbrs = graph.get(src);
            for(int nbr : nbrs)
            {
                if(visited[nbr] == false)
                {
                dfsOnStackTopElem(visited,graph,nbr);
                }
            }
        }
    }
    
    
}


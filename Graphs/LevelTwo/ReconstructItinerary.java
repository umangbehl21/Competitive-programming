package Graphs.LevelTwo;
import java.util.*;
public class ReconstructItinerary
{
    static HashMap<String,PriorityQueue<String>> graph;
    static LinkedList<String> ans;
    public static List<String> reconstructItinerary(List<List<String>> tickets)
    {   
        ans = new LinkedList<>();
        graph = new HashMap<>();
        for(List<String> ticket : tickets)
        {
            PriorityQueue<String> temppq = graph.getOrDefault(ticket.get(0),new PriorityQueue<>());  //getting the old priority queue or getting a new priority queue by default
            temppq.add(ticket.get(1)); //adding the neighbour in the priority queue example "jfk", "alf" now jfk will be key and alf will be added in priority queue there can be more than one nbr in priority queue sorted lexigraphically 
            graph.put(ticket.get(0), temppq); //by this our graph will be prepared using Hashmap to store key of string, priority queue 
        }
        dfs("jfk"); //calling dfs from the starting 
        return ans;
    }
    private static void dfs(String src)
    {
        PriorityQueue<String> nbrs = graph.get(src);
        while(nbrs.size() > 0)
        {
            String nbr = nbrs.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
    
}

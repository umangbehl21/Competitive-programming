package Graphs;
import java.util.*;
public class SpreadOfInfection {
    static class pair 
    {
        int v;
        int day;
        pair(int v,int day)  
        {
            this.v = v;
            this.day = day;
        }
    }
    public static int spreadOfInfection(ArrayList<Edges> []graph,int src,int day)  //day till how much people are infected is passed 
    {
        int count = 0;
        int visited[] = new int[graph.length];
        for(int i = 0;i<graph.length;i++)
        {
            if(visited[i] == 0)  
            {
               count += spreadOfInfectionHelper(graph, src, day,visited);
            }
        }
      return count;
    }
    private static int spreadOfInfectionHelper(ArrayList<Edges>[] graph, int src, int day, int[] visited)
    {
        int count = 0;
        Queue<pair> pendingnodes = new LinkedList<>();
        pendingnodes.add(new pair(src,1));
        while(!pendingnodes.isEmpty())
        {
           pair front = pendingnodes.remove();
           if(visited[front.v] > 0)  //if someone is infected once then it will have some day greater than 0 in visited on which he is infected so he cannot be infected again at another day continue for current iteration 
           {
              continue;
           }
           if(front.day > day)  //if front.day is becoming greater than the day till which we have to find the spread then break from loop 
           {
             break;
           }
           count++;  //else count the number of people infected till the day we have to find 
           visited[front.day] = front.day;  //set the day on which they are infected in the visited array on their respective index 
           for(Edges e : graph[src])
           {
              if(visited[e.nbr] == 0)  //if neihbour is not visited or infected then add it in the queue to infect him 
              {
                pendingnodes.add(new pair(e.nbr, front.day + 1));  //add new pair with neighbour and previous day + 1 is the day neighbour will get infected 
              }
           }

        }
        return count;


    }
    public static void main(String[] args) {
        ArrayList<Edges> [] graph = AdjacencyListImplementation.AdjacencyListImplementationInp();
        int a = spreadOfInfection(graph, graph[graph.length-1].get(0).src, 3); 
        System.out.println(a);
    }

}

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
    private static int spreadOfInfection(ArrayList<Edges>[] graph, int src, int day)
    {
        int count = 0;
        Queue<pair> pendingnodes = new LinkedList<>();
        pendingnodes.add(new pair(src,1));
        int visited[] = new int[graph.length];
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
           visited[front.v] = front.day;  //set the day on which they are infected in the visited array on their respective index 
           for(Edges e : graph[front.v])  //traverse on the edges of the current vertice 
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
        int a = spreadOfInfection(graph, 0, 3); 
        System.out.println(a);
    }

}

package Graphs.LevelTwo;

import java.util.*;

public class MinimumNoOfBuses {  //minimum number of buses required to reach from source to destination 
    public static int MinimumNoOfBusesReq(int routes[][],int src,int des)
    {
         HashMap<Integer,ArrayList<Integer>> map = new HashMap<>(); //in hashmap we will store the <Busstop -> Number of buses which can be board from that bus stop through which we can travel different stops and can find destination>
         for(int i = 0;i<routes.length;i++)
         {
           for(int j = 0;j<routes[0].length;j++)
           { 
                  int IndexBusList = routes[i][j]; //extracting the index or the bus stop along which list of busno is mapped in the hashmap
                  ArrayList<Integer> busno = map.getOrDefault(IndexBusList, new ArrayList<>()); //get or default whether we will get previous ArrayList or a new ArrayList will be made 
                  busno.add(i); //add the current bus number in the arraylist so that we can set it in map along with the stop from where it is boarded 
                  map.put(routes[i][j], busno); 
           }  
 
         }
         HashSet<Integer> BusStopVis = new HashSet<>(); //after visiting a BusStop add it in hashset to mark it visited so that it cannot be added twice
         HashSet<Integer> BusNoVis = new HashSet<>(); //after traversing all the routes of a bus mark it visited 
         Queue<Integer> busStop = new LinkedList<>();  //queue will hava all the bus stop added 
         busStop.add(src);  //add the src stop in the queue 
         BusStopVis.add(src); //mark it visited by adding in bus stop visited hashset 
         int level = 0;
         while(!busStop.isEmpty())
         {
            int size = busStop.size(); 
            while(size-- > 0)
            {
             int front = busStop.remove();
             if(front == des)
             {
                return level;
             }
             for(int Bus : map.get(front))  //by map.get(busstop) we get the ArrayList of buses which can be board from the bus stop we are traversing on the ArrayList 
             {
                if(!BusNoVis.contains(Bus))  //if a bus is not traversed before means its routes are not added in the queue then add its non visited bus stops 
                {
                    int busroute[] = routes[Bus]; //extracting routes or busstopes from the bus example if routes[0] where 0 is the bus number it contain all the stops where bus can visit 
                    for(int stopes : busroute) //traversing on the routes or stops which bus will take 
                    {
                         if(!BusStopVis.contains(stopes)) //if busstopvis hashset donnot contain a particular bus stop means it is nonvisited then only add 
                         {
                            BusStopVis.add(stopes); //mark busstop visited in the the busstopvis hashset so that this stop cannot be added again
                            busStop.add(stopes);  //add bus stop in queue 
                         }
                    }
                    BusNoVis.add(Bus); //after adding all the stops of bus in queue mark bus visited in busvis hashset
                }
             }

            }
         level++;
    }
    return -1;
    
}
public static void main(String[] args) { 
    int routes[][] = {{1,2,3},{1,4,5},{5,8,7},{3,6,7}};
    System.out.println(MinimumNoOfBusesReq(routes, 1, 7));
}
}

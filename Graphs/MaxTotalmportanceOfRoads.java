package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    class pair implements Comparable<pair> //leetcode 2285
    {
        int key = 0;
        int val = 0;
        public pair(int key,int val)
        {
            this.key = key;
            this.val = val;
        }
        public int compareTo(pair obj)
        {
            return obj.val - this.val;
        }
    }
    public long maximumImportance(int n, int[][] roads) { //intiution was simple a city which has most number of connections should be assigned most value most connections gives insights about indegree
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<roads.length;i++) //first maintaining the count of indegree for each city 
        {
            map.put(roads[i][0],map.getOrDefault(roads[i][0],0)+1);
            map.put(roads[i][1],map.getOrDefault(roads[i][1],0)+1);
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>();
        
        for(Map.Entry<Integer,Integer> it : map.entrySet()) //the city with greatest indegree count will be on top in priority queue 
        {
            pq.add(new pair(it.getKey(),it.getValue()));
        }

        int arr[] = new int[n];
        int gv = n; //gv is greatest value
        while(!pq.isEmpty()) //until priority queue is not empty we remove the city with most indegree than any other city from prioity queue then we assign the greatest value to it in the array and decrease the greatest value 
        {
            pair p = pq.remove();

            int key = p.key;
            arr[key] = gv;
            gv--;
        }
        long sum = 0;
        for(int i = 0;i<roads.length;i++) //at the end we do sum for the two interconnected city 
        {
            int u = roads[i][0];
            int v = roads[i][1];
            sum += arr[u] + arr[v];
        }
        return sum;
    }
}
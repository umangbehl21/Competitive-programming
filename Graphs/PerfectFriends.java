package Graphs;

import java.util.ArrayList;

public class PerfectFriends {  //get all possible combinations of friends from different clubs 
    public static void CombinedPairshelper(ArrayList<Edges> Vertices[],int src,boolean visited[],ArrayList<Integer> ans)
    {

       visited[src] = true;
       ans.add(src);
       for(Edges e : Vertices[src])
       {
          if(!visited[e.nbr])
          {
             CombinedPairshelper(Vertices, e.nbr, visited,ans);
          }
       }
    }
    public static ArrayList<ArrayList<Integer>> CombinedPairs(ArrayList<Edges> Vertices[],int src)
    {
       boolean visited[] = new boolean[Vertices.length];
       ArrayList<ArrayList<Integer>> cnpairs = new ArrayList<>();
       for(int i = 0;i<Vertices.length;i++)
       {
          if(!visited[i])
          {
            ArrayList<Integer> ans = new ArrayList<>();
            CombinedPairshelper(Vertices, i, visited, ans);
            cnpairs.add(ans);
          }
       }
       return cnpairs;
      
    }
    public static int countTotalDifferent_CombinationOfriends_FromDifferent_Clubs( ArrayList<ArrayList<Integer>> cnpairs)
    { 
        int pairs  = 0;
        int count = 0;
        for(int i = 0;i<cnpairs.size();i++)
        {
            for(int j = i+1;j < cnpairs.size();j++)
            {
                pairs = cnpairs.get(i).size() * cnpairs.get(j).size();
                count+= pairs; 
            }
        }
        return count;
    }
    public static void main(String[] args) {
     ArrayList<Edges> Vertices[] =  AdjacencyListImplementation.AdjacencyListImplementationInp();
    ArrayList<ArrayList<Integer>> cnpairs = CombinedPairs(Vertices, Vertices[0].get(0).src);
     System.out.println(countTotalDifferent_CombinationOfriends_FromDifferent_Clubs(cnpairs));
   }

}

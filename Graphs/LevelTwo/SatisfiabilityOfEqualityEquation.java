public class SatisfiabilityOfEqualityEquation 
{
    static int parent[];
    static int rank[];
    public static void union(int u,int v)
    {
        int pu = find(u);
        int pv = find(v);
        if(pu != pv)
        {
            if(rank[pu] > rank[pv])
            {
                parent[pv] = pu;
            }
            else if(rank[pu] < rank[pv])
            {
                parent[pu] = pv;
            }
            else 
            {
                parent[pv] = pu;
                rank[pu]++;
            }
        }
    }
    private static int find(int u) {
        if(u == parent[u])
        {
            return u;
        }
        parent[u] = find(parent[u]);
        return parent[u];
    }
    public static boolean isEqualEquations(String[] equations)
    {
        parent = new int[26];
        rank = new int[26];
        for(int i = 0;i<26;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        for(String str : equations)
        {
            if(str.charAt(1) == '=')
            {
                union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for(String str : equations)
        {
            if(str.charAt(1) == '!')
            {
                int pu = find(str.charAt(0) - 'a');
                int pv = find(str.charAt(3) - 'a');
                if(pu == pv)  //pu should not equal to pv as one equation is indicating this but if earlier somehow pu and pv was in same set means they were equal and now equation is also telling it is unequal then return false example a == b, b==c , a!=c if a is equal to b and b is equal to c then a should also be qual to c and they will be in same set now if one equation is indicating they are unequal but they have same parent in the dsu then return false 
                {
                    return false;
                }
            }
            
        }
        return true;
    }
    

}

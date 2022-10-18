package Graphs.LevelTwo;

public class RegionsCutBySlashes {

    public static int parent[];
    public static int rank[];
    static int count =1; //an empty matrix is also considered a region thats why count start with 1
    public static void regionsCutBySlashes(String grid[])  //where rows and columns are equal 
    {
        int dots = grid.length + 1;
        parent = new int[dots * dots];
        rank = new int[dots * dots];
        for(int i = 0;i<parent.length;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0;i<dots;i++)
        {
            for(int j = 0;j<dots;j++)
            {
                if(i == 0 || j == 0 || i == dots - 1 || j == dots-1) //finding cell numbers of the edges of the matrices and union them under 1 set with parent 0
                {
                   int ejcellnos = i * dots + j; //rowno * number of cols + colno connecting all the edges indexes in the martrice in the same set as if there are no slashes the edges still made a square like matrix which is considered as a cycle and a region that's why is the same set 
                    union(0, ejcellnos);
                }

            }
        }
        for(int i = 0;i<grid.length;i++)
        {
            char ch[] = grid[i].toCharArray();
            for(int j = 0;j<grid.length;j++) //rows and columns are equal
            {
                if(ch[j] == '/')
                {
                    int dwndotcellno = (i+1) * dots + j;
                    int updotcellno = i * dots + (j + 1);
                    union(dwndotcellno, updotcellno);
                } 
                if(ch[i] == '\\')
                {
                    int updotcellno = i * dots + j;
                    int dwndotcellno = (i + 1) * dots + (j + 1);
                    union(updotcellno, dwndotcellno);
                }
            }
        }
        
    }
    public static int find(int x,int parent[])  //find returns parent of an element 
    {
        if(x == parent[x])
        {
            return x;
        }
        parent[x] = find(parent[x], parent);
        return parent[x];
    }
    public static void union(int x,int y)
    {
        x = find(x, parent);
        y = find(x, parent);
        if(x !=y)
        {
            if(rank[x] > rank[y])
            {
                parent[y] = x;
            }
            else if(rank[y] > rank[x])
            {
                parent[x] = y;
            }
            else 
            {
                parent[y] = x;
                rank[x]++;
            }
        }
        else
        {
            count++;
        }
    

    }
 
    }

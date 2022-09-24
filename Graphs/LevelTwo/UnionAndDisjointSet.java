package Graphs.LevelTwo;
import java.util.*;
public class UnionAndDisjointSet 
{ 
    int n;
    int rank[];
    int parent[];
    public UnionAndDisjointSet(int n)
    {
        this.n = n;
        rank = new int[n];  //initially rank will be 0 it will be incremented when trees of same height one of them become the parent thus increaseing height by 1
        parent = new int[n];
        for(int i = 0;i<n;i++)  //initially all nodes will be their parent itself 
        {
            parent[i] = i;
        }
    }
    public int find(int x)  //2<-3<-4 if we find parent of 4 then it will first call on 3 which is its parent and then 3 wull call on 2 which is 3's parent then 2 will be returned now on the parent[3] = 2 is set as its parent and 2 will be returned and at the end parent[4] = 2 will become direct parent of 4 which was earlier 3 thus making the time complexity linear 
    { 
        if(parent[x] != x)
        {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int a,int b)
    {
        int x = find(a);
        int y = find(b);
        if(x == y) 
        {
            return;
        }  
        if(rank[x] > rank[y])  //when height of node is greater than other make it parent of the shorter tree as if we add shorter tree in longer height lh remain unchanged example 1->2 and 3 now if i make 3 parent of 1 then earlier 2 have to call above 1 height to reach 1 now it will call on 2 height to reach 3 increasing the time on the other hand if i make 1 as parent of 3 then 2 was previously have to call for 1 height and now also it has to call for 1 height so time didnt change so shorter height can accomodate under long tree
        {
            parent[y] = x;
        }
        else if(rank[y] > rank[x])
        {
           parent[x] = y;
        }
        else  //when the height of both the tree are equal then make anyone of them parent but if we are making parent to a node icrease its rank by 1 as the height of the tree will increase on addition of children example on making union of 1,2 they both have height 0 now if i make 1 as parent then 2 will come under it and become its part thus 1 have increase in height by 1
        {
            parent[y] = x;
            rank[x]++;
        }
    }
    public static void main(String[] args) 
    {
       Scanner sc = new Scanner(System.in);
       System.out.println("enter the total number of elements to represent in set");
       n = sc.nextInt();
       int i = 0;

       

    }
 
}

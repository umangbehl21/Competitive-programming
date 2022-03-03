package recursion;

import java.util.ArrayList;

public class allindex {
    private static ArrayList<Integer> allindexoccurence(int input[],int elem,int startindex,ArrayList<Integer> list)
    {
        if(input[startindex] == elem)
        {
            list.add(startindex);
        }
        if(startindex == input.length-1)
        {
            if(list.isEmpty())
            {
                list.add(-1);
            }
            return list;
        }
       return allindexoccurence(input, elem, startindex+1, list);
    }
    public static ArrayList<Integer> allindexoccurence(int input[],int elem)
    {
        ArrayList<Integer> list = new ArrayList<>();
        return allindexoccurence(input, elem,0,list);
    }
    public static void main(String[] args) {
        int input[] = {9,8,9,10,9};
        ArrayList<Integer> ar = allindexoccurence(input,9);
        for(int i = 0;i<ar.size();i++)
        {
            System.out.print(ar.get(i)+" ");
        }
    }
}

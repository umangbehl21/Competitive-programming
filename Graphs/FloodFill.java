package Graphs;

public class FloodFill {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean visited[][] = new boolean[image.length][image[0].length];
    int find = image[sr][sc];
    help(image, sr, sc, color,visited,find);
     return image;
   
}
 public void help(int image[][],int sr,int sc,int color,boolean visited[][],int find)
   {
       if(sr < 0 || sc < 0 || sr >= image.length||sc >= image[0].length || visited[sr][sc] == true || image[sr][sc] != find)
       {
           return;
       }
       image[sr][sc] = color; 
       visited[sr][sc] = true;
       help(image,sr-1,sc,color,visited,find);
       help(image,sr,sc+1,color,visited,find);
       help(image,sr+1,sc,color,visited,find);
       help(image,sr,sc-1,color,visited,find);
   }
    }


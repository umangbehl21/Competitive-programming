package Graphs;

public class KnightTour {
    public static void knightTour(int chess[][],int r,int c,int move)  //given a position can knight travel the whole chessboard on different 25 positions without visiting same position twice if yes display all the moves 
    {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess[0].length || chess[r][c] > 0) //if our position of row or column is out of the chess board or we have came to a position second time then there will be some move on it greater than 0 than return 
        {
            return;
        }   
        else if(move == chess.length * chess[0].length)  //if it is the knights 25th move then set it first and call display for the printing of all the moves
        {
           chess[r][c] = move;
           display(chess);
           chess[r][c] = 0;
           return;
        }
        chess[r][c] = move;  //on making new move set that move number on the position n
        knightTour(chess, r-2, c+1,move + 1);  //all the steps a knight can move if it is placed in centre 2,2
        knightTour(chess, r-1, c+2, move + 1);
        knightTour(chess, r+1, c+2, move + 1);
        knightTour(chess, r+2, c+1, move + 1);
        knightTour(chess, r+2, c-1, move + 1);
        knightTour(chess, r+1, c-2, move + 1);
        knightTour(chess, r-1, c-2, move + 1);
        knightTour(chess, r-2, c-1, move + 1);
        chess[r][c] = 0;
    }

    private static void display(int[][] chess) {
        for(int i = 0;i<chess.length;i++)
        {
            for(int j = 0;j<chess[0].length;j++)
            {
               System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int chess[][] = new int[5][5];
        knightTour(chess, 2, 2, 1);
    }
}

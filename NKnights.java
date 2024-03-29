public class NKnights {
    public static void main(String[] args) {
        int tar = 4;
        System.out.println(knights(new boolean[tar][tar], 0, 0, tar, 0));
    }

    static int knights(boolean[][] board, int r, int c, int tar, int count){
        if (r==board.length || tar == 0) {
            display(board);
            System.out.println();
            return count + 1;
        }

        if(r==board.length-1 && c == board.length) return count;

        if(c == board.length){
            return knights(board, r+1, 0, tar, count);
        }

        if(isSafe(board, r, c)){
            board[r][c] = true;
            count = knights(board, r, c+1, tar-1, count);
            board[r][c]=false;
        }

        count = knights(board, r, c+1, tar, count);
        return count;
    }

    private static boolean isSafe(boolean[][] board, int r, int c) {

        if (r>0 && c>1 && board[r-1][c-2]) return false;

        if(r<board.length-1 && c>1 && board[r+1][c-2]) return false;

        if(r>1 && c>0 && board[r-2][c-1]) return false;

        if(r<board.length -2 && c>1 && board[r+2][c-1]) return false;

        if (r>0 && c<board.length-2 && board[r-1][c+2]) return false;
        
        if(r<board.length-1 && c<board.length-2 && board[r+1][c+2]) return false;

        if(r>1 && c<board.length-1 && board[r-2][c+1]) return false;

        if(r<board.length -2 && c<board.length-1 && board[r+2][c+1]) return false;

        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for(boolean ele : row){
                if(ele){
                    System.out.print("K");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}

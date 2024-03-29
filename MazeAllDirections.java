import java.util.ArrayList;
import java.util.Scanner;

public class MazeAllDirections {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        in.close();

        ArrayList<String> lst = lst(new boolean[row][column], "", row-1, column-1);

        System.out.println(lst);
        System.out.println(lst.size());

        // str(new boolean[row][column], "", row-1, column-1);

        // ArrayList<String> res = lst("", row, column);
        // System.out.println(res);
    }

    // static int count(int r, int c){
    //     if(r==1 || c==1) return 1;
    //     return count(r-1, c)+count(r, c-1);
    // }
    static void str(boolean[][] mark, String p, int r, int c) {
        if (r < 0 || c < 0 || r >= mark.length || c >= mark[0].length || mark[r][c]) {
            return;
        }
        
        if (r == 0 && c == 0) {
            System.out.println(p);
            return;
        }
        
        mark[r][c] = true;
        str(mark, p + "R", r - 1, c);
        str(mark, p + "D", r, c - 1);
        str(mark, p + "U", r + 1, c);
        str(mark, p + "L", r, c + 1);
        
        mark[r][c] = false;
    }



    static ArrayList<String> lst(boolean[][] mark, String p, int r, int c){

        if (r < 0 || c < 0 || r >= mark.length || c >= mark[0].length || mark[r][c]) {
            ArrayList<String> lst = new ArrayList<>();
            return lst;
        }

        if(r==0 && c==0){
            ArrayList<String> lst = new ArrayList<>();
            lst.add(p);
            return lst;
        }

        ArrayList<String> ans = new ArrayList<>();

        mark[r][c] = true;
        ans.addAll(lst(mark, p + "R", r - 1, c));
        ans.addAll(lst(mark, p + "D", r, c - 1));
        ans.addAll(lst(mark, p + "U", r + 1, c));
        ans.addAll(lst(mark, p + "L", r, c + 1));
        
        mark[r][c] = false;

        return ans;
    }
}

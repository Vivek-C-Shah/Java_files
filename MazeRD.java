import java.util.*;

public class MazeRD {
    // for the maze for only right and down
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        in.close();
        ArrayList<String> res = lst("", row, column);
        System.out.println(res);
    }

    static int count(int r, int c){
        if(r==1 || c==1) return 1;
        return count(r-1, c)+count(r, c-1);
    }
    static void str(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1) str(p+"R", r-1, c);
        if(c>1) str(p+"D", r, c-1);
    }

    static ArrayList<String> lst(String p, int r, int c){
        if(r==1 && c==1){
            ArrayList<String> lst = new ArrayList<>();
            lst.add(p);
            return lst;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(r>1){
           ans.addAll(lst(p+"R", r-1, c)); 
        }
        if (c>1) {
            ans.addAll(lst(p+"D", r, c-1));
        }
        return ans;
    }

    // for the maze for only right and down
}

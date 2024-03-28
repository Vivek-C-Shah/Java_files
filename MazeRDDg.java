public class MazeRDDg {

    public static void main(String[] args) {
        str("", 3, 3);
        // System.out.println(count(3, 3));
    }
    static int count(int r, int c){
        if(r==1 || c==1) return 1;
        return count(r-1, c)+count(r, c-1)+count(r-1,c-1);
    }
    static void str(String p, int r, int c){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if (r>1 && c>1) {
            str(p+"Dg", r-1, c-1);
        }
        if(r>1) str(p+"R", r-1, c);
        if(c>1) str(p+"D", r, c-1);
    }
}

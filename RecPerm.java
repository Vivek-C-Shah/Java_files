import java.util.ArrayList;

/**
 * RecPerm
 */
public class RecPerm {

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println("Using prefix");
        ArrayList<String> ans = permList("", str);
        System.out.println(ans);
        // perm("", str);
        // System.out.println();
        // System.out.println("Using left and right");
        // permUsingLR(str, 0, str.length() - 1);
    }

    public static void perm(String p, String up){
        int n = up.length();
        if (n == 0) {
            System.out.println(p);
        } else {
            for (int i = 0; i < n; i++) {
                String newP = p + up.charAt(i);
                String newUP = up.substring(0, i) + up.substring(i+1);
                perm(newP, newUP);                
            }
        }
    }


    public static ArrayList<String> permList(String p, String up){
        int n = up.length();

        if (n == 0) {
            ArrayList<String> lst = new ArrayList<>();
            lst.add(p);
            return lst;
        } 
        
        ArrayList<String> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String newP = p + up.charAt(i);
            String newUP = up.substring(0, i) + up.substring(i+1);
            ans.addAll(permList(newP, newUP));
        }
        return ans;
        
    }

    public static void permUsingLR(String str, int l, int r) {
        if (l == r) {
            System.out.println(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permUsingLR(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
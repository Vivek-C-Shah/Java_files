import java.util.*;

public class RecStrings {
    public static void main(String[] args) {
//        System.out.println(skipAs(new StringBuilder("abbaaacnda"), 0));
        allSubseq("abcd", "");
    }
    public static StringBuilder skipAs(StringBuilder sb, int i){
        if(i==sb.length()) return sb;
        if(sb.charAt(i) == 'a') return skipAs(sb.deleteCharAt(i), i);
        else return skipAs(sb, ++i);
    }

    public static void allSubseq(String up, String sb){
        if (up.isEmpty()) {
            System.out.println(sb);
            return;
        }

        allSubseq(up.substring(1), sb+up.charAt(0));
        allSubseq(up.substring(1), sb);
    }

    public static ArrayList<String> arraySubseq(String up, String sb){
        if (up.isEmpty()) {
            ArrayList<String> fn = new ArrayList<String>();
            fn.add(sb);
            return fn;
        }

        ArrayList<String> left = arraySubseq(up.substring(1), sb+up.charAt(0));
        ArrayList<String> rght = arraySubseq(up.substring(1), sb);

        left.addAll(rght);
        return left;
    }

    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n = outer.size();
            for (List<Integer> integers : outer) {
                List<Integer> internal = new ArrayList<>(integers);
                internal.add(num);
                outer.add(internal);
            }
        }


        return outer;
    }
}

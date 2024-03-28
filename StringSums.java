import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringSums {
    public static void main(String[] args) {
        System.out.println(shifts('b', 3));
    }

    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        String[] srtarr = arr.clone();
        Arrays.sort(srtarr);
        int m = srtarr[n-1].length();
        char[][] chrarr = new char[m][n];
        List<String> vertStr = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i<arr[j].length()) chrarr[i][j] = arr[j].charAt(i);
                else chrarr[i][j] = ' ';
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < m; j++) {
                sb.append(chrarr[j][i]);
            }
            while (!sb.isEmpty() && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
                sb.deleteCharAt(sb.length() - 1);
            }
            vertStr.add(String.valueOf(sb));
        }
        return vertStr;
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int[] costs = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int i = 0, res = 0;
        while (i < costs.length) {
            int cost = 0;
            int temp = 0;
            while (i < costs.length && cost < maxCost) {
                cost += costs[i];
                i++;
                temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        for (int i = 1; i < n; i++) {
            StringBuilder s = ops(sb);
            sb.append('1');
            sb.append(s);
        }
        return sb.charAt(k-1);
    }
    public StringBuilder ops(StringBuilder s){
        s.reverse();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') s.setCharAt(i, '1');
            else s.setCharAt(i, '0');
        }
        return s;
    }

    public String shiftingLetters(String s, int[] shifts) {
        for (int i = 0; i < shifts.length; i++) {
            shifts[i] %= 26;
        }
        int sum = Arrays.stream(shifts).sum();
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
           char ch = str.charAt(i);
           ch=shifts(ch,sum%26);
           str.setCharAt(i, ch);
           sum-=shifts[i];
        }
        return str.toString();
    }
    static char shifts(char c, int times){
        for (int i = 0; i < times; i++) {
            if (c == 'z') c = 'a';
            else c++;
        }
        return c;
    }
    public int countHomogenous(String s){
        long total = 0, mod = 1_000_000_007;
        for (int i = 0; i < s.length(); i++){
            int count= 1;
            for (int j = i; j < s.length(); j++) {
                if(s.charAt(j) == s.charAt(j+1)){
                    total+=count*(count+1)/2;
                    i++;
                }
            }
        }
        return (int) (total%mod);
    }
    public static int numSub(String s) {

        int num = 0;
        int i = 0;
        while(i<s.length()){
            int n = 0;
            while(i<s.length() && s.charAt(i) == '1'){
                n++;
                i++;
            }
            num += n*(n+1)/2;
            i++;
        }
        return num;
    }
    public static boolean checkPalindromeFormation(String a, String b) {
        StringBuilder ar = new StringBuilder();
        ar.append(a);
        ar.reverse();
        StringBuilder br = new StringBuilder();
        br.append(b);
        br.reverse();
        if(b.contentEquals(br) && a.contentEquals(ar)) return true;

        if (checkPal(b, ar)) return true;
        return checkPal(a, br);
    }

    public int minimumLength(String s){
        int n=s.length();

        int lftptr=0,rghtptr=s.length()-1;

        while(s.charAt(lftptr)==s.charAt(rghtptr)&&rghtptr>lftptr)
        {
            char temp=s.charAt(lftptr);
            while(s.charAt(lftptr)==temp&&lftptr<n) lftptr++;
            while(s.charAt(rghtptr)==temp&&rghtptr>0) rghtptr--;
            if(rghtptr<lftptr)
            {
                return 0;
            }
        }
        return rghtptr-lftptr+1;
    }
    public static int minimumLength1(String str) {
        if(isPal(str)) return str.length()%2;
//        for (int i = 0; i < s.length()/2-1; i++) {
//            if (!(s.charAt(i) == s.charAt(s.length()-1-i))) break;
//            else count++;
//        }
        int i = 0, count = 0;
        StringBuilder s = new StringBuilder(str);
        int n = s.length();
        while(i<n/2){
            StringBuilder pre = new StringBuilder();
            StringBuilder suf = new StringBuilder();
            for (int j = i; j < s.length()/2; j++) {
                pre.setLength(0);
                pre.append(s.charAt(j));
                if (s.charAt(j+1) == pre.charAt(0)) {
                    pre.append(s.charAt(j));
                }
                else break;
            }
            for (int j = s.length()-1-i; j > s.length()/2-1; j--) {
                suf.setLength(0);
                suf.append(s.charAt(j));
                if (s.charAt(j-1) == suf.charAt(0)) {
                    suf.append(s.charAt(j));
                }
                else break;
            }
            System.out.println(pre);
            System.out.println(suf);
            if (pre.isEmpty() || suf.isEmpty()) break;
            if(pre.charAt(0) == suf.charAt(0)){
                count = pre.length()+suf.length();
            }
            else break;
        }
        return s.length()-count;
    }
    
    public static boolean isPal(String s){
        StringBuilder sr = new StringBuilder();
        sr.append(s);
        sr.reverse();
        return s.contentEquals(sr);
    }

    public static boolean checkPal(String a, StringBuilder br) {
        for (int i = 0; i < br.length(); i++) {
            StringBuilder x = new StringBuilder("");
            x.append(br.charAt(i));
            if (a.contains(x) && (a.indexOf(x.toString()) == 0 || a.lastIndexOf(x.toString()) == a.length() - x.length()))  return true;
        }
        return false;
    }
}

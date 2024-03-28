/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

    }

    public static int minOperations(int k){
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, i+(k-i)/(i+1));
        }
        return ans;
    }

}
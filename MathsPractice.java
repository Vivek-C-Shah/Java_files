import java.lang.reflect.Array;
import java.util.*;

public class MathsPractice {
    public static void main(String[] args) {
//        System.out.println(climbStairs(2));
//        System.out.println(selfDividingNumbers(1,22));
//        System.out.println(permute(3,7));
//        System.out.println(numSquares(12));
//        System.out.println(myAtoi("   -23"));
//        System.out.println(Arrays.toString(factors(9)));
        System.out.println((char) ('s' + 5));
    }

    public int integerBreak(int n) {
//        if((n%2 == 0) && (n%3 == 1) ){
//            return (int) Math.pow(2, n /2);
//        }
//        else{
//            return( (int) Math.pow(3, n/3) * (n%3==0 ? 1 : n%3));
//        }
        if (n==2) return 1;
        if (n==3) return 2;
        if(n%3 == 0){
            return ( (int) Math.pow(3,n/3));
        }
        else if(n%3 == 1){
            return ( (int) Math.pow(3,(n/3 -1)) * 4);
        }
        else{
            return ( (int) Math.pow(3, n/3) * 2);
        }
    }



    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int pro = 1;
        for (int i = 0; i < nums.length; i++) {
            pro = pro * nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                int temp = 1;
                for(int j = 0;j<nums.length;j++){
                    if(i!=j){
                        temp = temp*nums[j];
                    }
                }
                ans[i] = temp;
            }else{
                ans[i] = pro/nums[i];
            }
        }
        return ans;
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] count = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int xCenter = queries[i][0];
            int yCenter = queries[i][1];
            int radius = queries[i][2];
            count[i] = 0;

            for (int[] point : points) {
                int x = point[0];
                int y = point[1];
                if (Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2) <= Math.pow(radius, 2)) {
                    count[i]++;
                }
            }
        }
        return count;
    }

    public static int kthFactor(int n, int k) {
        if(n == 1) {
            int[] arr = new int[]{1};
            if(k==1) return 1;
            else return -1;
        }
        int[] arr = factors(n);
        if (arr.length<k) return -1;
        return (arr[k-1]);
    }
    public static int[] factors(int a){
        ArrayList <Integer> lst = new ArrayList<>();
        int i = 1;
        while(i*i<=a){
            if(a%i==0){
                lst.add(i);
                if (i != a/i) {
                    lst.add(a/i);
                }
            }
            i++;
        }
        Collections.sort(lst);
        return lst.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int myAtoi(String s) {
            int num = 0, i = 0, sign = 1;
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                sign = s.charAt(i) == '+' ? 1 : -1;
                i++;
            }
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && s.charAt(i) > '7')) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            return num * sign;
        }
    public double angleClock(int hour, int minutes) {
        double h = hour%12;
        double m = minutes;
        double a = Math.abs((6*m) - ((30*h) + (m/2)));
        return (a > 180 ? 360-a : a);
    }

    private void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void reverse(char[] arr, int i, int j){
        while(i<j)
            swap(arr, i++, j--);
    }
    public int nextGreaterElement(int c) {
        char[] arr = (""+c).toCharArray();

        int n = arr.length;
        int i = n-2;
        while(i >= 0 && arr[i+1] <= arr[i]) i--;
        if(i<0) return -1;
        int j = n-1;
        while(j>=0 && arr[j] <= arr[i]){
            j--;
        }
        swap(arr, i, j);
        reverse(arr, i+1, n-1);
        long result = Long.parseLong(new String(arr));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i+1; j++) {
                int sq = j*j;
                if (i-sq < 0){
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i-sq] + 1);
            }
        }
        return dp[n];
    }

    public static int minSq(int n){
        return((int) Math.pow(n,0.5));
    }

    public static boolean isPrime(int a){
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if(a%i == 0) return false;
        }
        return true;
    }
    
    public static int PerfSq(int n){
        double a = Math.pow(n, 0.5);
        return( (a - (int) a == 0) ? (int) a : -1);
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int case1 = nums[0]*nums[1]*nums[nums.length-1];
        int case2 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];

        return Integer.max(case1, case2);
    }

    public static int climbStairs(int n) {
        int ways = 1;

        for (int i = 1; i <= n / 2; i++) {
            double sum = 1;

            for (int j = i; j < 2 * i; j++) {
                sum *= (double)(n - j) / (j - i + 1);
            }

            ways += (int) sum;
        }

        return ways;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            StringBuilder s = new StringBuilder(Integer.toString(i));
            boolean flag = true;
            while (!s.isEmpty()){
                if (s.charAt(0) == '0' || i%(s.charAt(0)-'0') != 0){
                    flag = false;
                    break;
                }
                s.deleteCharAt(0);
            }
            if (flag) lst.add(i);
        }
        return lst;
    }

    public static int permute(int m, int n) {
        m=m-1;
        n=n-1;
        double a = 1;
        for (int i = m; i > 0; i--) {
            a*= (double) (i + n) / i;
        }
        a = Math.round(a);
        return (int) a;
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char c = (char) ('A' + columnNumber % 26);
            sb.insert(0, c);
            columnNumber /= 26;
        }
        return sb.toString();
    }
}

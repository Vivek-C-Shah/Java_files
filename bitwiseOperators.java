import java.util.*;
import java.util.stream.IntStream;

public class bitwiseOperators {
    public static void main(String[] args) {
        System.out.println(grayCode(2));
        System.out.println(1<<2);
    }
    public static boolean checkNiceString(String s){
        int lower = 0;
        int upper = 0;
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper |= 1 << 'a' + Character.toLowerCase(c);
            } else {
                lower |= 1 << 'a' + c;
            }
        }
        return upper == lower;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if(res.contains(temp)) return;
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(res, temp, nums, i + 1);
            temp.removeLast();
        }
    }

    public int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (final int num : nums) {
                sum += num >> i & 1;
            }
            sum %= 3;
            ans |= sum << i;
        }

        return ans;
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
            // explain the above line's logic
            // 0 0 0
            // 0 0 1
            // 0 1 1
            // 0 1 0
            // 1 1 0
            // 1 1 1
            // 1 0 1
            // 1 0 0
        }
        return res;
    }
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0;
        for (int x = 31; x >= 0; x--) {
            if ((a >>> x) - b >= 0) {
                res += 1 << x;
                a -= b << x;
            }
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;
    }

    public int xorOperation(int n, int start) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = start+2*i;
        }
        int res = arr[0];
        for (int i = 1; i < n; i++) {
            res^=arr[i];
        }
        return res;
    }

    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        int dp[][] = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            dp[i][0] = arr[i];
            dp[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(dp, Comparator.comparingDouble(o -> o[1]));
        for(int i=0; i<arr.length; i++){
            arr[i] = dp[i][0];
        }
        return arr;
    }

    public static int numberOfSteps(int n) {
        int count=0;
        while (n!=0){
            if((n&1)==0) {
                n=n>>1;
                count++;
            } else {
                n^=1;
                count++;
            }
        }
        return count;
    }

    public static int binaryGap(int n) {
        int count = 0, fin = 0;
        while(n!=0){
            if((n&1)==1 && count==0){
                count++;
            } else if ((n & 1) == 1) {
                fin=Math.max(count,fin);
                count=1;
            } else if ((n&1)==0 && count!=0) {
                count++;
            }
            n=n>>1;
        }
        return fin;
    }

    public boolean hasAlternatingBits(int n) {
        while(n!=0){
            int s1 = n&1;
            n=n>>1;
            int s2 = n&1;
            if(s1==s2) return false;
        }
        return true;
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (checkPrimeBits(countSetBits(i))) count++;
        }
        return count;
    }

    public static int countSetBits(int n){
        int count = 0;
        while(n!=0){
            if ((n&1) == 1) count++;
            n=n>>1;
        }
        return count;
    }

    public static boolean checkPrimeBits(int n){
        return n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13 || n == 17 || n == 19 || n == 23 || n == 29 || n == 31;
    }

    public int findComplement(int num) {
        int n = (int) Math.ceil(Math.log(num)/Math.log(2));
        int mask = (1<<n)-1;
        return ~num & mask;
    }

    public static int hammingWeight(int n) {
        int res = 0;
        String ns = "" + n;
        System.out.println(ns);
        for (int i = 0; i < ns.length(); i++) {
            if((n & 1) == 1) res++;
            n=n>>>1;
        }
        return res;
    }

    public static int hammingDistance(int x, int y) {
        int ans = x^y;
        return countOneBits(ans);
    }

    public static int countOneBits(int n){
        int count=0;
        while(n>0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static int[] countBits(int n) {
        return IntStream.range(0,n+1).map(Integer::bitCount).toArray();
    }

    public static int convertBinaryToString(int num){
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);
        return num;
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return new String(sb.reverse());
    }
}
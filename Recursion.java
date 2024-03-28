import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
//        System.out.println(fibo(7));
        int[] arr = new int[]{1, 4, 7, 9, 12, 16, 19, 25, 29};
        System.out.println(binSearch(arr, 0, arr.length, 26));
    }
        public int kthGrammar(int n, int k) {
            if (n == 1) {
                return 0;
            } else if (n == 2) {
                if (k == 1) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                int previous = kthGrammar(n - 1, (k % 2 == 0) ? k / 2 : (k + 1) / 2);
                if (previous == 0) {
                    return (k % 2 == 0) ? 1 : 0;
                } else {
                    return (k % 2 == 0) ? 0 : 1;
                }
            }
        }

    public int countGoodNumbers(long n) {
        long MOD = 1_000_000_007;
        if (n == 0) return 1;
        if(n%2 == 0) return (int) (4*countGoodNumbers(n-1) % MOD);
        else return (int) (5*countGoodNumbers(n-1) % MOD);
    }
    public double myPow(double x, int n) {
        if(n<0) {
            x = 1 / x;
            n=Math.abs(n);
        }
        if(n==0) return 1;
        return x*myPow(x,n-1);
    }



    public static int fibo(int n){
        if(n<=1) return n;
        return fibo(n-1) + fibo(n-2);
    }
    public static int binSearch(int[] arr, int s, int e, int target){
        if(s>e) return -1;
        int m = s+(e-s)/2;
        if (arr[m] < target){
            s=m+1;
            return binSearch(arr,s,e,target);
        }
        else if(arr[m] > target){
            e=m-1;
            return binSearch(arr,s,e,target);
        }
        else return m;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recFindTarget(nums, target, 0, 0);
    }
    public int recFindTarget(int[] nums, int target, int i, int sum){
        if(i == nums.length && sum==target) return 1;
        else if(i>= nums.length) return 0;
        return recFindTarget(nums, target, i+1, sum+nums[i]) + recFindTarget(nums, target, i+1, sum-nums[i]);
    }


    public char findKthBit(int n, int k) {
        return recKthBit("0", 0).charAt(k-1);
    }
    public String recKthBit(String s, int idx){
        if(idx==s.length()) return s;
        s = s.replace("1", "*");
        s = s.replace("0", "1");
        s = s.replace("*", "1");
        StringBuilder sb = new StringBuilder(s);
        s=s+"1"+sb.reverse().toString();
        return recKthBit(s, idx+1);
    }
    
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> lst = new ArrayList<>();
//        Arrays.sort(candidates);
//        resComb(res, lst, candidates, target, 0);
//        return res;
//    }
//    public List<List<Integer>> resComb(List<List<Integer>> res, List<Integer> lst,int[] arr, int tar, int i){
//        if(tar == 0) {
//            res.add(new ArrayList<>(lst));
//            return res;
//        }
//        for (int j = i; j < arr.length-1 && arr[i] <= tar; j++) {
//            lst.add(arr[i]);
//            resComb(res, lst, arr, tar-arr[i], j);
//            lst.removeLast();
//        }
//    }

}

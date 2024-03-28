import java.util.Scanner;

public class Searching {
    public static void main(String[] args) {

        int[][] nums = arrInitialize();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the element to search");
        int k = in.nextInt();
        int[] ans = linearSearch(nums, k);
        if (ans[0]==-1) {
            System.out.println(k+" was not found in the array");
        }
        else {
            System.out.println(k+" was found at position ("+(ans[0])+", "+(ans[1])+")");
        }
//        int ans = min(nums);
//        System.out.println(ans+" is the minimum value of the array");
    }
    public static int[] linearSearch(int[][] nums, int k){
        int[] ans = new int[] {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (k == nums[i][j]) {
                    ans[0] = i + 1;
                    ans[1] = j + 1;
                    break;
                }
            }
        }
        return ans;
    }
    public static int[][] arrInitialize(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of array elements");
        int n = in.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter element at position ("+i+","+j+")");
                nums[i][j] = in.nextInt();
            }
        }
        return nums;
    }
    public static int min(int[] nums){
        int min = nums[0];
        for (int num : nums) {
            if (num < min) min = num;
        }
        return min;
    }
    public int numOfEvenDigits(int[] nums){
        int count = -1;
        for (int i : nums) {
            String temp = Integer.toString(i);
            if(temp.length() % 2 == 0) count++;
        }
        return count;
    }
    public int maximumWealth(int[][] accounts) {
        int[] money = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[0].length; j++) {
                money[i] = money[i] + accounts[i][j];
            }
        }
        int max = 0;
        for(int num: money){
            if(num>max){
                max = num;
            }
        }
        return max;
    }

    public int search(int[] nums, int target){
        int end = nums.length -1, begin = 0;
        while(begin<=end){
            int mid = begin + (end-begin)/2;
            if(nums[mid] < target){
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
    public int ceilSearch(char[] nums, char tar){
        int end = nums.length -1, begin = 0;
        if((int) tar > (int) nums[nums.length-1]) return -1;
        while(begin<=end){
            int mid = begin + (end-begin)/2;
            if((int) nums[mid] < (int) tar){
                begin = mid + 1;
            } else if ((int) nums[mid] > (int) tar) {
                end = mid - 1;
            } else{
                return mid;
            }
        }
        return begin;
    }

    public int floorSearch(int[] nums, int target){
        int end = nums.length -1, begin = 0;
        if(target<nums[0]) return -1;
        while(begin<=end){
            int mid = begin + (end-begin)/2;
            if(nums[mid] < target){
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else{
                return mid;
            }
        }
        return end;
    }
}
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public static void main(String[] args) {
//        System.out.println(nextGreaterElement(9310));
        System.out.println(maximumRemovals("rqmvwezfxczzeqokjww", "rezxczzeqw", new int[]{18,1,3,7,4,16,14,2,15,0,6,12,17,11,13,5,9}));
    }
    public static int maximumRemovals(String s, String p, int[] removable) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for (int j : removable) {
            sb.setCharAt(j, '0');
            if (check(sb.toString(), p)) count++;
            else break;
        }
        return count;
    }

    public int minimumBoxes(int[] apple, int[] capacity) {
        int count  = 0, sum = 0, num = 0;
        Arrays.sort(capacity);
        sum = Arrays.stream(apple).sum();
        System.out.println(sum);
        for (int j = capacity.length - 1; j>=0; j--) {
            count += capacity[j];
            num++;
            if (count>=sum) return num;
        }
        return 0;

    }


    public static boolean check(String s, String p){
        int[] arr = new int[p.length()];
        Arrays.fill(arr,-1);
        for (int i = 0; i < p.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if(p.charAt(i) == s.charAt(j)) {
                    if(i>0 && j>arr[i-1]) {
                        arr[i] = j;
                        break;
                    }
                    if(i==0){
                        arr[i] = j;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            if((!(arr[i] < arr[i+1])) || arr[i] == -1) return false;
        }
        return !(arr[0] == -1);
    }

    public String multiply(String num1, String num2) {
        int n1 = Integer.parseInt(num1), n2 = Integer.parseInt(num2);
        return String.valueOf(n1*n2);
    }
    public static int nextGreaterElement(int n) {
        char[] arr = (Integer.toString(n)).toCharArray();
        char[] sarr = arr.clone();
        Arrays.sort(sarr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sarr.length; j++) {
                if(arr[i] == sarr[j]){
                    if(j< sarr.length-1){
                        swap(sarr, j+1, i);
                    } else if (j==sarr.length-1) {
                        swap(sarr, j, i);
                    }
                }
            }
        }
        return Integer.parseInt(new String(sarr));
    }


    public static void swap(char[] arr, int num1, int num2){
        char temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
    }

    public static boolean areSentencesSimilar(String str1, String str2) {
        String[] sstr1 = new String[(str1.split(" ")).length];
        sstr1 = str1.split(" ");
        String[] sstr2 = new String[(str2.split(" ")).length];
        sstr2 = str2.split(" ");
        if(sstr2.length< sstr1.length) areSentencesSimilar(str2,str1);
        int i = 0;
        while (i < sstr1.length && sstr1[i].equals(sstr2[i])) {
            ++i;
        }
        while (i < sstr1.length && sstr1[i].equals(sstr2[sstr2.length - sstr1.length + i])) {
            ++i;
        }
        return i == sstr1.length;
    }

    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        StringBuilder s = new StringBuilder();
        while(!(s.toString().contains(b))){
            if(count >= b.length()) return -1;
            s.append(a);
            count++;
        }
        return count;
    }

    public static int setbits(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') count++;
        }
        return count;
    }

    public int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int distance = Math.min(Math.abs(i - j), Math.min(Math.abs(i - x) + 1 + Math.abs(y - j), Math.abs(i - y) + 1 + Math.abs(x - j)));
                    if (distance == k) {
                        result[k - 1] += 2;
                    }
                }
            }
        }

        return result;
    }

    public static int minimumPushes(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : word.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Character> sortedChars = new ArrayList<>(freq.keySet());
        sortedChars.sort((a, b) -> freq.get(b) - freq.get(a));

        int keyPresses = 0;
        int keyPosition = 1;
        int keyNumber = 2;
        for (char c : sortedChars) {
            keyPresses += freq.get(c) * keyPosition;
            if (keyNumber < 9) {
                keyNumber++;
            } else {
                keyNumber = 2;
                keyPosition++;
            }
        }

        return keyPresses;
    }
    public static boolean canReach(String s, int minJump, int maxJump) {
        if(!(s.contains("1")) && (s.length()%minJump <= maxJump-minJump)) return true;
        int i = 0;
        int sn = s.length();
        for(int j = 0;j < sn;j++){
            if(s.charAt(j) == '0'){
                if(i+minJump <= j && j<=Math.min(i+maxJump, sn - 1)) i = j;
            }
        }
        if(i == sn - 1) return true;
        return false;
    }
//
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        // Sort the array
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            // Skip duplicate elements for i
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//
//            int j = i + 1;
//            int k = nums.length - 1;
//
//            while (j < k) {
//                int sum = nums[i] + nums[j] + nums[k];
//
//                if (sum == 0) {
//                    // Found a triplet with zero sum
//                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
//
//                    // Skip duplicate elements for j
//                    while (j < k && nums[j] == nums[j + 1]) {
//                        j++;
//                    }
//
//                    // Skip duplicate elements for k
//                    while (j < k && nums[k] == nums[k - 1]) {
//                        k--;
//                    }
//
//                    // Move the pointers
//                    j++;
//                    k--;
//                } else if (sum < 0) {
//                    // Sum is less than zero, increment j to increase the sum
//                    j++;
//                } else {
//                    // Sum is greater than zero, decrement k to decrease the sum
//                    k--;
//                }
//            }
//        }
//        return ans;
//    }
//
//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int fSum = nums[0]+nums[1]+nums[2];
//        for (int i = 0; i < nums.length-2; i++){
//            int j = i+1, k = nums.length-1;
//            while(j<k){
//                int sum = nums[i] + nums[j] + nums[k];
//                if(Math.abs(sum - (target)) < Math.abs(fSum-(target))) fSum = sum;
//                if (sum < target) {
//                    j++; // Increment j to increase the sum
//                } else {
//                    k--; // Decrement k to decrease the sum
//                }
//            }
//        }
//        return fSum;
//    }
//
//    public List<List<Integer>> fourSum(int[] nums,int target) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        // Sort the array
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 3; i++) {
//
//            // Skip duplicate elements for i
//            for (int j = i+1; j < nums.length-2; j++) {
//
//                int l = j+1;
//                int k = nums.length - 1;
//
//                while (j < l && l<k) {
//                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
//
//                    if (sum == target) {
//                        // Found a triplet with zero sum
//                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[k]));
//                        // Move the pointers
//                        l++;
//                        k--;
//                    } else if (sum < target) {
//                        // Sum is less than zero, increment j to increase the sum
//                        l++;
//                    } else {
//                        // Sum is greater than zero, decrement k to decrease the sum
//                        k--;
//                    }
//
//                }
//            }
//
//        }
//        return ans;
//    }
//
//    public int[][] merge(int[][] intervals) {
//        List<List<Integer>> arrayList = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            int a = intervals[i][0];
//            int b = intervals[i][1];
//            for (int j = intervals.length-1; j > i; j--) {
//                if(b > intervals[j][0] && b < intervals[j][1]){
//                    a = Math.min(a,intervals[j][0]);
//                    b = Math.max(b,intervals[j][1]);
//                }
//            }
//            arrayList.add(Arrays.asList(a,b));
//        }
//        Integer[][] array2D = new Integer[arrayList.size()][];
//        for (int i = 0; i < arrayList.size(); i++) {
//            List<Integer> row = arrayList.get(i);
//            array2D[i] = row.toArray(new Integer[row.size()]);
//        }
//        return Arrays.stream(array2D)
//                .map(row -> Arrays.stream(row).mapToInt(Integer::intValue).toArray())
//                .toArray(int[][]::new);
//    }
}
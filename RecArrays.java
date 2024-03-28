import java.util.*;

public class RecArrays {
    //    array sorted or not
    public static void main(String[] args) {
//        System.out.println(isSorted(new int[]{1,2,3,6,8}));
//        linearSearch();
//        System.out.println(Arrays.toString(searchAll(new int[]{1, 2, 3, 5, 3, 8, 3}, 3)));
//        System.out.println(binarySearch(new int[]{1,3,5,7,8,10,13}, 4));
        int[] arr = new int[]{5, 1, 2, 3, 4};
        System.out.println(searchBinaryRotatedHelper(arr, 1, 0, arr.length - 1));
    }

    // public static ArrayList<Integer> subseq(ArrayList<Integer> outer, int[] arr) { //subsequences of a string with
    //     // dublicate elements
        
    // }

    public static int searchBinaryRotatedHelper(int[] a, int tar, int s, int h) {
        if (s > h) return -1;
        int i = s - (s - h) / 2;
        if (a[i] == tar) return i + 1;
        if (a[s] <= a[i]) { //sorted
            if (tar < a[i] && tar >= a[s]) h = i - 1;
            else s = i + 1;
        } else if ((tar >= a[s] && tar > a[i]) || (tar < a[s] && tar < a[i])) {
            h = i - 1;
        } else s = i + 1;
        return searchBinaryRotatedHelper(a, tar, s, h);
    }

    public static int[] searchAll(int[] arr, int tar) {
        ArrayList<Integer> list = searchAllHelper(new ArrayList<>(), arr, tar, 0);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static ArrayList<Integer> searchAllHelper(ArrayList<Integer> lst, int[] arr, int tar, int i) {
        if (i == arr.length) return lst;
        if (arr[i] == tar) lst.add(i + 1);
        return searchAllHelper(lst, arr, tar, ++i);
    }

    public static int binarySearch(int[] arr, int tar) {
        return binarySearchHelper(arr, tar, 0, arr.length - 1);
    }

    public static int binarySearchHelper(int[] arr, int tar, int s, int h) {
        if (s > h) return -1;
        int index = s - (s - h) / 2;
        if (arr[index] == tar) return index + 1;
        else if (arr[index] < tar) return binarySearchHelper(arr, tar, index + 1, h);
        else return binarySearchHelper(arr, tar, s, index - 1);
    }

    public static void linearSearch() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter target value:");
        int tar = in.nextInt();
        System.out.println("Enter length of the array:");
        int len = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.println("Enter array index " + (i + 1));
            arr[i] = in.nextInt();
        }

        System.out.printf("The %s is at index %s", tar, linearSearchHelper(arr, tar, 0));
        
        in.close(); // Close the Scanner object
    }

    public static int linearSearchHelper(int[] arr, int tar, int i) {
        if (i == arr.length) return -1;
        if (arr[i] == tar) return i + 1;
        return linearSearchHelper(arr, tar, ++i);
    }

    public static boolean isSorted(int[] arr) {
        return isSortedHelper(arr, 0);
    }

    public static boolean isSortedHelper(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        if (arr[i] >= arr[i + 1]) return false;
        return isSortedHelper(arr, ++i);
    }
}

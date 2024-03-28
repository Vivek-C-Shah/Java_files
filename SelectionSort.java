import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1,2,3,-1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int max = arr[0];
            int maxi = 0;
            for (int j = 1; j < n-i; j++) {
                if(max < arr[j]) maxi = j;
                max = Math.max(max,arr[j]);
            }
            swap(arr, maxi, n-i-1);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

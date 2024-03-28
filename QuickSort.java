import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int lo, int hi){
        if(lo>=hi) return;

        int s=lo,e=hi, m = s+(e-s)/2;
        int pivot = arr[m];
        while(s<=e) {
            while (arr[s] < pivot) s++;
            while (arr[e] > pivot) e--;
            if(s<=e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        quickSort(arr, lo, e);
        quickSort(arr, s, hi);

    }
}

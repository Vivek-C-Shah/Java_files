import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void cyclicSort(int[] arr){
        int i =0;
        while(i<arr.length){
            int exp = arr[i] - 1;
            if(arr[i] == arr[exp]) i++;
            else swap(arr, i, exp);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

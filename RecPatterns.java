import java.util.Arrays;

public class RecPatterns {
    public static void main(String[] args) {
//        pattern1(4,0);
        int[] arr = new int[]{4,3,2,1};
//        bubbleSort(arr, arr.length-1, 0);
        selectionSort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
//    1
//    ****
//    ***
//    **
//    *
    public static void pattern1(int row, int column){
        if (row == 0) return;
        if (row>column) {
            System.out.print("*");
            pattern1(row, ++column);
        }else {
            System.out.println();
            pattern1(--row, 0);
        }
    }

    public static void selectionSort(int[] arr, int i, int j, int max){
        if (i == 0) return;
        if (i>j) {
            if (arr[j]>arr[max]) selectionSort(arr,i,j+1, j);
            else selectionSort(arr, i, ++j, max);
        }else {
            int temp = arr[i-1];
            arr[i-1] = arr[max];
            arr[max] = temp;
            selectionSort(arr, --i, 0, 0);
        }
    }

    public static void bubbleSort(int[] arr, int i, int j){
        if (i == 0) return;
        if (i>j) {
//            System.out.print("*");
            if (arr[j]>arr[j+1]){
//                swap
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            bubbleSort(arr, i, ++j);

        }else {
//            System.out.println();
            bubbleSort(arr, --i, 0);
        }
    }

}

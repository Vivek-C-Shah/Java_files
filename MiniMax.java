import java.util.Arrays;

public class MiniMax{
    public static void main(String[] args) {
        System.out.println(miniMax(new int[]{1, 4, 2, 5, 3, 6, 7, 8}, true)[0]);
    }
    public static int[] miniMax(int[] arr, boolean max){
        if(arr.length < 2){
            return arr;
        }
        int[] res = new int[arr.length/2];
        for (int i = 0; i < arr.length; i=i+2) {
            if(max){
                res[(i+1)/2] = Math.max(arr[i], arr[i+1]);
            }
            else{
                res[(i+1)/2] = Math.min(arr[i], arr[i+1]);
            }
        }
        return miniMax(res, !max);
    }
}
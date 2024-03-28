import java.util.ArrayList;
import java.util.List;

class CyclicApps {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cyclicSort(nums);
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i+1) arr.add(nums[i]);
        }
        return arr;

    }
    public static void cyclicSort(int[] arr){
        int i =0;
        while(i<arr.length){
            int exp = arr[i] - 1;
            if(arr[i]< arr.length && arr[i] == arr[exp]) i++;
            else swap(arr, i, exp);
        }
    }

    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
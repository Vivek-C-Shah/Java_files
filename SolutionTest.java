import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testMinimumSubarrayLength() {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3};
        int k1 = 2;
        int expected1 = 1;
        int result1 = solution.minimumSubarrayLength(nums1, k1);
        assertEquals(expected1, result1);

        int[] nums2 = {2, 1, 8};
        int k2 = 10;
        int expected2 = 3;
        int result2 = solution.minimumSubarrayLength(nums2, k2);
        assertEquals(expected2, result2);

        int[] nums3 = {1, 2};
        int k3 = 0;
        int expected3 = 1;
        int result3 = solution.minimumSubarrayLength(nums3, k3);
        assertEquals(expected3, result3);

        int[] nums4 = {2, 1, 6, 32, 86, 56};
        int k4 = 123;
        int expected4 = 2;
        int result4 = solution.minimumSubarrayLength(nums4, k4);
        assertEquals(expected4, result4);
    }
}
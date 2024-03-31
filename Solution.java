import java.util.*;
class Solution {
    public int minimumDistance(int[][] points) {
        int n = points.length;
        int[] max = new int[4];
        int[] min = new int[4];
        Arrays.fill(min, Integer.MAX_VALUE);
        
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            max[0] = Math.max(max[0], x + y);
            max[1] = Math.max(max[1], x - y);
            max[2] = Math.max(max[2], -x + y);
            max[3] = Math.max(max[3], -x - y);
            min[0] = Math.min(min[0], x + y);
            min[1] = Math.min(min[1], x - y);
            min[2] = Math.min(min[2], -x + y);
            min[3] = Math.min(min[3], -x - y);
        }
        
        int res = Integer.MAX_VALUE;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int maxDist = Math.max(Math.max(max[0] - x - y, max[1] - x + y), Math.max(max[2] + x - y, max[3] + x + y));
            res = Math.min(res, maxDist);
        }
        
        return res;
    }
}

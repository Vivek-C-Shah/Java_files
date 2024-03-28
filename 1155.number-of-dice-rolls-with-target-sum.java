/*
 * @lc app=leetcode id=1155 lang=java
 *
 * [1155] Number of Dice Rolls With Target Sum
 */

// @lc code=start
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        if(n==1) return(target<=k?1:0);
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        int mod = 1000000007;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int d = 1; d <= k; d++) {
                    if (j >= d) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - d]) % mod; // Update this line to use the variable mod
                    }
                }
            }
        }

        return dp[n][target];
    }
}
// @lc code=end


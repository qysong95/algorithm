class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null) {
            return false;
        }
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        // corner case
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]] || dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length][sum / 2];
    }
}

/*
use DP to solve the problem
- maintain a 2D matrix dp[i][j]
- dp[i][j] means whether we can get j value by picking subsequence of the first i elements

initial:
- i is range [0, nums.length], j is range [0, sum/2]
- corner base: dp[0][j] = false, dp[i][0] = true
- rule:
    - dp[i][j] = true, if d[i-1][j-nums[i]] = true or dp[i-1][j] = true
    - dp[i][j] = false, otherwise

complexity:
- time: O(n*sum)
- space: O(n*sum)
*/

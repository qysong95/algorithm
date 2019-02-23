package lime;

public class LongestContinuousIncreasingSubsequence {

	/*
	 * 1. use dp
	 * 2. dp[i] represents the length of the longest continuous increasing subsequence
	 * 		that ends at i
	 * 3. initial:
	 * 		- dp[0] = 1
	 * 4. update rule:
	 * 		- if a[i] > a[i-1]: dp[i] = dp[i-1] + 1;
	 * 		- else: dp[i] = 1
	 * 5. complexity:
	 * 		- time: linear scan, O(n)
	 * 		- space: O(n), but can optimized to O(1), since we always use the last one
	 */
	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int lastLength = 1;
		int globalMax = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				lastLength++;
			} else {
				lastLength = 1;
			}
			globalMax = Math.max(globalMax, lastLength);
		}
		return globalMax;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

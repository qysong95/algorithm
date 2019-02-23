package lime;

public class LCISWithKBreak {
	
	/*
     * - [left, right) (not including right)
     * - if nums[right] > nums[right - 1], right++
     * - else:
     *      - if bk < k, bk++, right++
     *      - else: left++ until nums[left] <= nums[left - 1], bk--, right++
     *
     * general:
     *      - if nums[right] <= nums[right - 1], bk++
     *      - if bk > k, left++ until nums[left] >= nums[left + 1], left++, bk--
     *      - right++
     *      - globalMax = max(globalMax, right - left)
     */
    public int findLCISWithKBreak(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // sliding window
        int left = 0;
        int right = 1;
        int globalMax = 1;
        int bk = 0;
        while (right < nums.length) {
            if (nums[right] <= nums[right - 1]) {
                bk++;
            }
            if (bk > k) {
                while (nums[left + 1] >= nums[left]) {
                    left++;
                }
                left++;
                bk--;
            }
            right++;
            globalMax = Math.max(globalMax, right - left);
        }
        return globalMax;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 3, 0, 1, 2, 3, 4, -1, -2, 0, 1, 3, 4, 5, 7, 8, 9, -4, 1, 3};
		int[] nums1 = {5, 4, 3, 2, 1, 2, 1, 0};
		System.out.println(new LCISWithKBreak().findLCISWithKBreak(nums, 2));
	}

}

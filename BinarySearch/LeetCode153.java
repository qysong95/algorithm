class Solution {
    public int findMin(int[] nums) {
        // assume nums is not null and has at least 1 elements
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) {
            return nums[left];
        }
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            return nums[right];
        }
    }
}

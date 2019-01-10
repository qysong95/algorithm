class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else {
                if (nums[mid] < nums[right]) {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else if (nums[left] < nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[left] == target) {
                        return true;
                    } else {
                        left++;
                    }
                }
            }
        }
        return false;
    }
}
/*
1. if nums[mid] < nums[right]: means nums[mid...right] is in ascending order
    Case 1.1: if nums[mid] < target <= nums[right]: left = mid + 1
    Case 1.2: else: right = mid - 1
2. if nums[left] < nums[mid]: means nums[left...mid] is in ascending order
    Case 2.1: if nums[left] <= target < nums[mid]: right = mid - 1
    Case 2.2: else: left = mid + 1
3. else: cannot make sure which part is in ascending order: 
    Case 3.1: if nums[left] == target: true
    Case 3.2: else: left++
*/

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            int i = index + 1;
            while (i < nums.length && nums[index] < nums[i]) {
                i++;
            }
            int temp = nums[index];
            nums[index] = nums[i - 1];
            nums[i - 1] = temp;
        }
        reverse(nums, index + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}

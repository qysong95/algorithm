class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }
    }
}
/*
two pointers:
    - slow: the left hand side of the slow (not including slow) have been processed and should be kept
    - fast: the current processing index
initialization:
    - slow = 0
    - fast = 0
algorithm:
    - if a[fast] == 0: fast++
    - if a[fast] != 0: a[slow] = a[fast], slow++, fast++
complexity:
    - time: O(n)
    - space: O(1)
*/

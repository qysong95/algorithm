class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;
        while (one <= two) {
            if (nums[one] == 0) {
                swap(nums, zero++, one++);
            } else if (nums[one] == 1) {
                one++;
            } else {
                swap(nums, one, two--);
            }
        }
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
/*
three pointers:
    - zero: the left hand side of zero index (not including zero) is zero. [0...zero)
    - one: the left hand side of one index (not including one) and behind the zero (including zero) is one [zero, one)
    - two: the right hand side of two index (not including two) is 2, (two...]
    - [one, two] is the area we not yet process
initial:
    - zero = one = 0
    - two = nums.length - 1
algorithm:
    - a[one] == 0: swap(zero, one), zero++, one++
    - a[one] == 1: one++
    - a[one] == 2: swap(one, two), two--
complexity:
    - time = O(n)
    - space = O(1)
*/

class Solution {
    // public int missingNumber(int[] nums) {
    //     if (nums == null || nums.length == 0) {
    //         return 0;
    //     }
    //     Set<Integer> set = new HashSet<>();
    //     for (int num: nums) {
    //         set.add(num);
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (!set.contains(i)) {
    //             return i;
    //         }
    //     }
    //     return nums.length;
    // }
    
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index || nums[index] == nums.length) {
                index++;
            } else {
                swap(nums, index, nums[index]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

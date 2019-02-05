class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int[] result = new int[target + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    result[i] += result[i - nums[j]];
                }
            }
        }
        return result[target];
    }
//     public int combinationSum4(int[] nums, int target) {
//         if (nums == null) {
//             return 0;
//         }
//         int[] count = new int[1];
//         count[0] = 0;
//         helper(nums, target, count);
//         return count[0];
//     }
    
//     private void helper(int[] nums, int target, int[] count) {
//         if (target == 0) {
//             count[0]++;
//             return;
//         }
//         for (int i = 0; i < nums.length; i++) {
//             if (target >= nums[i]) {
//                 helper(nums, target - nums[i], count);
//             }
//         }
//     }
}

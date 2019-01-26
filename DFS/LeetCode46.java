class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, 0, result);
        return result;
    }
    
    private void helper(int[] nums, int level, List<List<Integer>> result) {
        if (level == nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int num: nums) {
                res.add(num);
            }
            result.add(res);
            return;
        }
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            helper(nums, level + 1, result);
            swap(nums, level, i);
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
/*
recursion tree:
    - #levels: nums.length
    - #branches: n - 1, n - 2, n - 3, ..., 1
    - base case: level == nums.length
complexity:
    - time: n + n*(n-1) + n*(n-1)*(n-2) + ... + n! -> O(n!)
    - space: O(nums.length) -> O(n)
*/

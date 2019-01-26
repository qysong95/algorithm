class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        helper(nums, 0, buffer, result);
        return result;
    }
    
    private void helper(int[] nums, int level, List<Integer> buffer, List<List<Integer>> result) {
        if (level == nums.length) {
            result.add(new ArrayList<Integer>(buffer));
            return;
        }
        // add
        buffer.add(nums[level]);
        helper(nums, level + 1, buffer, result);
        buffer.remove(buffer.size() - 1);
        
        // not add
        helper(nums, level + 1, buffer, result);
    }
}
/*
recursion tree:
    - #levels: nums.length
    - #branchs: two, add or not add
complexity:
    - time: O(2^n)
    - space: O(nums.length)
*/

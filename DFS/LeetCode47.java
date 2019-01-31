class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        helper(nums, 0, result);
        return result;
    }
    
    private void helper(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> res = new ArrayList<>();
            for (int num: nums) {
                res.add(num);
            }
            result.add(res);
            return;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.add(nums[i])) {
                swap(nums, index, i);
                helper(nums, index + 1, result);
                swap(nums, index, i);
            }
        }
    }
    
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

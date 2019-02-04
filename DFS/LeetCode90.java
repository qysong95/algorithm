class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> buffer = new ArrayList<>();
        helper(nums, 0, buffer, result);
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> buffer, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        
        // add
        buffer.add(nums[index]);
        helper(nums, index + 1, buffer, result);
        buffer.remove(buffer.size() - 1);
        
        // not add
        while (index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index++;
        }
        helper(nums, index + 1, buffer, result);
    }
}

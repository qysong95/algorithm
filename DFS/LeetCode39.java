class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        helper(candidates, candidates.length - 1, target, buffer, result);
        return result;
    }
    
    private void helper(int[] can, int level, int target, List<Integer> buffer, List<List<Integer>> result) {
        if (level < 0) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(buffer));
            }
            return;
        }
        
        for (int i = 0; i <= target / can[level]; i++) {
            for (int j = 0; j < i; j++) {
                buffer.add(can[level]);
            }
            helper(can, level - 1, target - i * can[level], buffer, result);
            for (int j = 0; j < i; j++) {
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
/*
recursion tree:
    - #levels: candidates.length
    - #branches: at most left target / camdodates[level]
complexity:
    - time: O(branch^candidates.length)
    - space: O(candidates.length)
*/

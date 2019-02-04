class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> buffer = new ArrayList<>();
        helper(candidates, 0, target, buffer, result);
        return result;
    }
    
    private void helper(int[] candidates, int index, int target, List<Integer> buffer, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        // add
        if (target >= candidates[index]) {
            buffer.add(candidates[index]);
            helper(candidates, index + 1, target - candidates[index], buffer, result);
            buffer.remove(buffer.size() - 1);
        }
        
        // not add
        while (index < candidates.length - 1 && candidates[index + 1] == candidates[index]) {
            index++;
        }
        helper(candidates, index + 1, target, buffer, result);
    }
}

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > 9 || k <= 0) {
            return result;
        }
        List<Integer> buffer = new ArrayList<>();
        helper(k, 1, n, buffer, result);
        return result;
    }
    
    private void helper(int k, int index, int n, List<Integer> buffer, List<List<Integer>> result) {
        if (n == 0 && buffer.size() == k) {
            result.add(new ArrayList<>(buffer));
            return;
        }
        if (index >= 10) {
            return;
        }
        // add
        if (n >= index) {
            buffer.add(index);
            helper(k, index + 1, n - index, buffer, result);
            buffer.remove(buffer.size() - 1);
        }
        // not add
        helper(k, index + 1, n, buffer, result);
    }
}

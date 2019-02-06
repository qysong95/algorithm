class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 1) {
            return result;
        }
        List<Integer> factors = getSet(n);
        List<Integer> sol = new ArrayList<>();
        helper(factors, 0, n, sol, result);
        return result;
    }
    
    private void helper(List<Integer> factors, int index, int n, List<Integer> sol, List<List<Integer>> result) {
        if (index == factors.size()) {
            if (n == 1) {
                result.add(new ArrayList<>(sol));
            }
            return;
        }
        int factor = factors.get(index);
        // get # of branches
        int count = 0;
        int val = n;
        while (val > 1 && val % factor == 0) {
            count++;
            val = val / factor;
        }
        
        for (int i = 0; i <= count; i++) {
            for (int j = 0; j < i; j++) {
                sol.add(factor);
            }
            helper(factors, index + 1, (int) (n / Math.pow(factor, i)), sol, result);
            for (int j = 0; j < i; j++) {
                sol.remove(sol.size() - 1);
            }
        }
    }
    
    private List<Integer> getSet(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i > 1; i--) {
            if (n % i == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
/*
first: need do get the factors set

recursion tree:
- #level: set.length
- #branch: how many the factor can be selected

complexty:
- time: O(#branch^#level)
- space: O(#level + set.size)
*/

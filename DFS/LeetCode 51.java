class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        int[] sol = new int[n];
        helper(0, sol, result);
        return result;
    }
    
    private void helper(int index, int[] sol, List<List<String>> result) {
        if (index == sol.length) {
            List<String> res = getResult(sol);
            result.add(res);
            return;
        }
        for (int i = 0; i < sol.length; i++) {
            if (isValid(sol, index, i)) {
                sol[index] = i;
                helper(index + 1, sol, result);
            }
        }
    }
    
    private boolean isValid(int[] sol, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (sol[i] == col || Math.abs(sol[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
    
    private List<String> getResult(int[] sol) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < sol.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sol.length; j++) {
                if (j == sol[i]) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
/*
rule: n length array, index for row, value a[i] for column
    - a[i] != any of a[j], and abs(i - j) != abs(a[i] - a[j]) for any j in array

recursion tree:
- # of level: n, each row put a queen
- # of branches: n, each col is possible
- base case: when row == n

in each recursion level, use the rule

complexity:
- time: worse case O(n^n*n) n to the power of n
- space: O(n^n for chess + n call stack)
*/

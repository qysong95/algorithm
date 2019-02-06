class Solution {
    public int totalNQueens(int n) {
        int[] count = new int[1];
        if (n <= 0) {
            return count[0];
        }
        int[] sol = new int[n];
        helper(0, sol, count);
        return count[0];
    }
    
    private void helper(int index, int[] sol, int[] count) {
        if (index == sol.length) {
            count[0]++;
            return;
        }
        for (int i = 0; i < sol.length; i++) {
            if (isValid(sol, index, i)) {
                sol[index] = i;
                helper(index + 1, sol, count);
            }
        }
    }
    
    private boolean isValid(int[] sol, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (sol[i] == col || row - i == Math.abs(sol[i] - col)) {
                return false;
            }
        }
        return true;
    }
}

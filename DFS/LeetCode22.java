class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(n, n, sb, result);
        return result;
    }
    
    private void helper(int left, int right, StringBuilder sb, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }
        // add left parenthesis
        if (left > 0) {
            sb.append('(');
            helper(left - 1, right, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // add right parenthesis
        if (right > left) {
            sb.append(')');
            helper(left, right - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
/*
recursion tree:
    - #levels: 2*n
    - #branches: two, add left or right
complexity:
    - time: O(2^2n)
    - space: O(2n)
*/

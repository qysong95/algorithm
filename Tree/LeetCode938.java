/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int[] sum = new int[1];
        sum[0] = 0;
        helper(root, L, R, sum);
        return sum[0];
    }
    
    private void helper(TreeNode root, int L, int R, int[] sum) {
        if (root == null) {
            return;
        }
        if (root.val >= L && root.val <= R) {
            sum[0] += root.val;
        }
        helper(root.left, L, R, sum);
        helper(root.right, L, R, sum);
    }
}

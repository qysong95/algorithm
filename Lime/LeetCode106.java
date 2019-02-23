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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
    }
    
    private TreeNode helper(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight, Map<Integer, Integer> indexMap) {
        if (iLeft > iRight) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pRight]);
        int leftSize = indexMap.get(postorder[pRight]) - iLeft;
        TreeNode left = helper(inorder, iLeft, iLeft + leftSize - 1, postorder, pLeft, pLeft + leftSize - 1, indexMap);
        TreeNode right = helper(inorder, iLeft + leftSize + 1, iRight, postorder, pLeft + leftSize, pRight - 1, indexMap);
        root.left = left;
        root.right = right;
        return root;
    }
}

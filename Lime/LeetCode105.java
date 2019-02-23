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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != preorder.length) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }
    
    private TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight, Map<Integer, Integer> indexMap) {
        if (iLeft > iRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pLeft]);
        int leftSize = indexMap.get(preorder[pLeft]) - iLeft;
        TreeNode left = helper(preorder, pLeft + 1, pLeft + leftSize, inorder, iLeft, iLeft + leftSize - 1, indexMap);
        TreeNode right = helper(preorder, pLeft + leftSize + 1, pRight, inorder, iLeft + leftSize + 1, iRight, indexMap);
        root.left = left;
        root.right = right;
        return root;
    }
}

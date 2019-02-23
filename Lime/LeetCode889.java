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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            indexMap.put(post[i], i);
        }
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1, indexMap);
    }
    
    private TreeNode helper(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int postRight, Map<Integer, Integer> indexMap) {
        if (preLeft > preRight) {
            return null;
        }
        if (preLeft == preRight) {
            return new TreeNode(pre[preLeft]);
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int leftSize = indexMap.get(pre[preLeft + 1]) - postLeft + 1;
        TreeNode left = helper(pre, preLeft + 1, preLeft + leftSize, post, postLeft, postLeft + leftSize - 1, indexMap);
        TreeNode right = helper(pre, preLeft + leftSize + 1, preRight, post, postLeft + leftSize, postRight - 1, indexMap);
        root.left = left;
        root.right = right;
        return root;
    }
}

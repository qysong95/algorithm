public List<Integer> rangeBST(TreeNode root, int min, int max) {
    List<Integer> result = new ArrayList<>();
    helper(root, min, max, result);
    return result;
}

private void helper(TreeNode root, int min, int max, List<Integer> result) {
    if (root == null) {
        return;
    }
    if (root.val > min) {
        helper(root.left, min, max, result);
    }
    if (root.val >= min && root.val <= max) {
        result.add(root.val);
    }
    if (root.val < max) {
        result.add(root.val);
    }
}

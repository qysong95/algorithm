public List<String> validParentheses(int m, int n, int k) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    Deque<Character> stack = new ArrayDeque<>();
    helper(m, n, k, stack, sb, result);
    return result;
}

private void helper(int m, int n, int k, Deque<Character> stack, StringBuilder sb, List<String> result) {
    if (m == 0 && n == 0 && k == 0) {
        result.add(sb.toString());
    }
    Character top = stack.peekFirst();
    // add left {
    if (m > 0 && (top == null || top != '[' && top != '(')) {
        stack.offerFirst('{');
        sb.append('{');
        helper(m - 1, n, k, stack, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        stack.pollFirst();
    }
    // add right }
    if (top != null && top == '{') {
        stack.pollFirst();
        sb.append('}');
        helper(m, n, k, stack, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        stack.offerFirst('{');
    }
    // add left [
    if (n > 0 && (top == null || top != '(')) {
        stack.offerFirst('[');
        sb.append('[');
        helper(m, n - 1, k, stack, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        stack.pollFirst();
    }
    // add right ]
    if (top != null && top == '[') {
        stack.pollFirst();
        sb.append(']');
        helper(m, n, k, stack, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        stack.offerFirst('[');
    }
    // add left (
    if (k > 0) {
        stack.offerFirst('(');
        sb.append('(');
        helper(m, n, k - 1, stack, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        stack.pollFirst();
    }
    // add right )
    if (top != null && top == '(') {
        stack.pollFirst();
        sb.append(')');
        helper(m, n, k, stack, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        stack.offerFirst('(');
    }
}

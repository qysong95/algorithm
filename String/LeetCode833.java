class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int[] match = new int[S.length()];
        Arrays.fill(match, -1);
        for (int i = 0; i < indexes.length; i++) {
            if (equalString(S, indexes[i], sources[i])) {
                match[indexes[i]] = i;
            }
        }
        
        int idx = 0;
        while (idx < S.length()) {
            if (match[idx] != -1) {
                sb.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            } else {
                sb.append(S.charAt(idx));
                idx++;
            }
        }
        return sb.toString();
    }
    
    private boolean equalString(String input, int start, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (start + i >= input.length() || input.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

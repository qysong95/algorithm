class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        if (words == null || pattern == null) {
            return result;
        }
        for (String word: words) {
            if (match(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }
    
    private boolean match(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(w) && !used.contains(p)) {
                map.put(w, p);
                used.add(p);
            } else if (map.containsKey(w)) {
                if (map.get(w) != p) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

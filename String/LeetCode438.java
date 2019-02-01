class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        
        int matches = 0;
        for (int i = 0; i < s.length(); i++) {
            // take a char in
            char ch = s.charAt(i);
            Integer count = map.get(ch);
            if (count != null) {
                if (count == 1) {
                    matches++;
                }
                map.put(ch, count - 1);
            }
            
            // take a char out
            if (i >= p.length()) {
                ch = s.charAt(i - p.length());
                count = map.get(ch);
                if (count != null) {
                    if (count == 0) {
                        matches--;
                    }
                    map.put(ch, count + 1);
                }
            }
            
            if (matches == map.size()) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}

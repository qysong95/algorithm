class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int globalMax = 0;
        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast++));
                globalMax = Math.max(globalMax, set.size());
            } else {
                set.remove(s.charAt(slow++));
            }
        }
        return globalMax;
    }
}
/*
sliding window:
- slow: my sw's left border (including slow)
- fast: my sw's right border (not including fast)

- data structure:
- use a set to check repeated characters

example: abcabcbb
initial:
- fast = 0;
- slow = 0;
- set = {}

algorithm:
- 2 step: a[f] not in set, add a[f] into set, f++
    - fast = 1, slow = 0, set = {a}
- 3 step: a[f] not in set, add a[f] into set, f++
    - fast = 2, slow = 0, set = {a, b}
- 4 step: a[f] not in set, add a[f] into set, f++
    - fast = 3, slow = 0, set = {a, b, c}
- 5 step: a[f] in set, remove a[s] from set, s++
    - fast = 3, slow = 1, set = {b, c}
- 6 step: a[f] not in set, add a[f] into set, f++
    - fast = 4, slow = 1, set = {b, c, a}

general step:
- if a[f] not in set, add a[f] into set, fast++
- if a[f] in set, remove a[s] from set, s++

complexity:
- time: O(n^2)
- space: O(n) for set
*/

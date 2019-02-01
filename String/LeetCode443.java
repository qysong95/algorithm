class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast < chars.length) {
            int start = fast;
            while (fast < chars.length && chars[fast] == chars[start]) {
                fast++;
            }
            chars[slow++] = chars[fast - 1];
            int count = fast - start;
            if (count > 1) {
                for (char ch: ("" + count).toCharArray()) {
                    chars[slow++] = ch;
                }
            }
        }
        return slow;
    }
}

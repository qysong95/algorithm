class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        reverse(str, 0, str.length - 1);
        int i = 0;
        while (i < str.length) {
            if (str[i] == ' ') {
                i++;
            } else {
                int end = i;
                while (end < str.length && str[end] != ' ') {
                    end++;
                }
                reverse(str, i, end - 1);
                i = end;
            }
        }
    }
    
    private void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
}

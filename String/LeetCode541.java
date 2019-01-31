class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int i = 0;
        while (i < array.length) {
            int end = Math.min(i + k - 1, array.length - 1);
            reverse(array, i, end);
            i += 2 * k;
        }
        return new String(array, 0, array.length);
    }
    
    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
/*
several situations: current index i
- kend = i + k - 1
- if kend <= s.length() - 1: reverse from i to kend
- if kend > s.length() - 1: reverse from i to s.length() - 1
- then i = i + 2k
*/

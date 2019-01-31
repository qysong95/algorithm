class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int i = 0;
        while (i < array.length) {
            if (array[i] == ' ') {
                i++;
            } else {
                int end = i;
                while (end < array.length && array[end] != ' ') {
                    end++;
                }
                reverse(array, i, end - 1);
                i = end;
            }
        }
        return new String(array, 0, array.length);
    }
    
    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}

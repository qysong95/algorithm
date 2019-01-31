public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int newEnd = reduceSpaces(array);
        
        reverse(array, 0, newEnd - 1);
        int i = 0;
        while (i < newEnd) {
            if (array[i] == ' ') {
                i++;
            } else {
                int end = i;
                while (end < newEnd && array[end] != ' ') {
                    end++;
                }
                reverse(array, i, end - 1);
                i = end;
            }
        }
        return new String(array, 0, newEnd);
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
    
    private int reduceSpaces(char[] array) {
        int fast = 0;
        int slow = 0;
        while (fast < array.length) {
            if (array[fast] == ' ') {
                if (slow == 0 || array[slow - 1] == ' ') {
                    fast++;
                } else {
                    array[slow++] = array[fast++];
                }
            } else {
                array[slow++] = array[fast++];
            }
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            slow--;
        }
        return slow;
    }
}

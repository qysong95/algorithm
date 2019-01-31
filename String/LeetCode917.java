class Solution {
    public String reverseOnlyLetters(String S) {
        if (S == null) {
            return S;
        }
        char[] array = S.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if ((array[left] < 'a' || array[left] > 'z') && (array[left] < 'A' || array[left] > 'Z')) {
                left++;
            } else if ((array[right] < 'a' || array[right] > 'z') && (array[right] < 'A' || array[right] > 'Z')) {
                right--;
            } else {
                char temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        return new String(array, 0, array.length);
    }
}

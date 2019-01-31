class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        while (left < right) {
            if (!set.contains(array[left])) {
                left++;
            } else if (!set.contains(array[right])) {
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

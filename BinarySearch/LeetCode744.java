class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (letters[mid] - 'a' <= target - 'a') {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        // post-processing
        if (letters[left] - 'a' > target - 'a') {
            return letters[left];
        } else if (letters[right] - 'a' > target - 'a') {
            return letters[right];
        } else {
            return letters[0];
        }
    }
}

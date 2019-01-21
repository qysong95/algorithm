class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null) {
            return null;
        }
        int[] result = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (A[mid] < 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (right >= A.length || left >= 0 && Math.abs(A[left]) <= Math.abs(A[right])) {
                result[i] = A[left] * A[left];
                left--;
            } else {
                result[i] = A[right] * A[right];
                right++;
            }
        }
        return result;
    }
}

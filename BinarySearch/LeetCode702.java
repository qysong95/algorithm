class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == Integer.MAX_VALUE) {
            return -1;
        }
        int left = 0;
        int rightBound = 1;
        while (reader.get(rightBound) < target) {
            left = rightBound;
            rightBound = rightBound * 2;
        }
        while (left <= rightBound) {
            int mid = left + (rightBound - left) / 2;
            int mval = reader.get(mid);
            if (mval == target) {
                return mid;
            } else if (mval < target) {
                left = mid + 1;
            } else {
                rightBound = mid - 1;
            }
        }
        return -1;
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int left = 0;
        int right = x / 2;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (right * right <= x) {
            return right;
        } else {
            return left;
        }
    }
}

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int left = 0;
        int right = 31;
        while (left < right) {
            int lbit = (n >> left) & 1;
            int rbit = (n >> right) & 1;
            if (lbit != rbit) {
                n = n ^ ((1 << right) | (1 << left));
            }
            left++;
            right--;
        }
        return n;
    }
}

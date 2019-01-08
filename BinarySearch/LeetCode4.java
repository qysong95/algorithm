class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m == 0) {
            return n % 2 == 1 ? (double) nums2[n / 2] : (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
        }
        if (n == 0) {
            return m % 2 == 1? (double) nums1[m / 2] : (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
        }
        int[] median = new int[2];
        kth(nums1, 0, nums2, 0, (m + n) / 2 + 1, median);
        if ((m + n) % 2 == 1) {
            return (double) median[1];
        } else {
            return (median[0] + median[1]) / 2.0;
        }
    }
    
    private void kth(int[] a, int aleft, int[] b, int bleft, int k, int[] median) {
        if (aleft >= a.length) {
            median[1] = b[bleft + k - 1];
            if (bleft + k - 2 < 0) {
                median[0] = a[a.length - 1];
            } else {
                median[0] = Math.max(a[a.length - 1], b[bleft + k - 2]);
            }
            return;
        }
        if (bleft >= b.length) {
            median[1] = a[aleft + k - 1];
            if (aleft + k - 2 < 0) {
                median[0] = b[b.length - 1];
            } else {
                median[0] = Math.max(b[b.length - 1], a[aleft + k - 2]);
            }
            return;
        }
        if (k == 1) {
            if (a[aleft] <= b[bleft]) {
                median[1] = a[aleft];
                if (bleft == 0 || aleft > 0 &&  a[aleft - 1] >= b[bleft - 1]) {
                    median[0] = a[aleft - 1];
                } else {
                    median[0] = b[bleft - 1];
                }
            } else {
                median[1] = b[bleft];
                if (aleft == 0 || bleft > 0 && b[bleft - 1] >= a[aleft - 1]) {
                    median[0] = b[bleft - 1];
                } else {
                    median[0] = a[aleft - 1];
                }
            }
            return;
        }
        
        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;
        
        int aval = amid >= a.length ? Integer.MAX_VALUE : a[amid];
        int bval = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
        
        if (aval <= bval) {
            kth(a, amid + 1, b, bleft, k - k / 2, median);
        } else {
            kth(a, aleft, b, bmid + 1, k - k / 2, median);
        }
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[]{};
        }
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        Set<Integer> set = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }
        List<Integer> common = new ArrayList<>();
        for (int num: nums2) {
            if (set.contains(num)) {
                common.add(num);
                set.remove(num);
            }
        }
        int[] result = new int[common.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = common.get(i);
        }
        return result;
    }
}

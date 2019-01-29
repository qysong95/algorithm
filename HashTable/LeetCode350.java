class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> common = new ArrayList<>();
        for (int num: nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                common.add(num);
                map.put(num, count - 1);
            }
        }
        
        int[] result = new int[common.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = common.get(i);
        }
        return result;
    }
}

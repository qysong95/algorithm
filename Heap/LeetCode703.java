class KthLargest {
    
    PriorityQueue<Integer> minHeap;
    int capacity;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.offer(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < capacity) {
            minHeap.offer(val);
        } else {
            if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

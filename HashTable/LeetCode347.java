class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>(k);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (map.get(o1) == map.get(o2)) {
                    return 0;
                }
                return map.get(o1) < map.get(o2) ? -1 : 1;
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry.getKey());
            } else {
                if (entry.getValue() > map.get(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.offer(entry.getKey());
                }
            }
        }
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }
}

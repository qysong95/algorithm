/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
 
public Map<Integer, Double> highFive(Record[] students) {
    Map<Integer, PriorityQueue<Record>> map = new HashMap<>();
    for (Record stu: students) {
        if (!map.containsKey(stu.id)) {
            PriorityQueue<Record> minHeap = new PriorityQueue<>(5, new Comparator<Record>() {
                @Override
                public int compare(Record r1, Record r2) {
                    if (r1.score == r2.score) {
                        return 0;
                    }
                    return r1.score < r2.score ? -1 : 1;
                }
            });
            minHeap.offer(stu);
            map.put(stu.id, minHeap);
        } else {
            PriorityQueue<Record> minHeap = map.get(stu.id);
            if (minHeap.size() < 5) {
                minHeap.offer(stu);
            } else if (minHeap.peek().score < stu.score) {
                minHeap.poll();
                minHeap.offer(stu);
            }
        }
    }
    
    Map<Integer, Double> result = new HashMap<>();
    for (Map.Entry<Integer, PriorityQueue<Record>> entry: map.entrySet()) {
        PriorityQueue<Record> minHeap = entry.getValue();
        int sum = 0;
        while (!minHeap.isEmpty()) {
            sum += minHeap.poll().score;
        }
        result.put(entry.getKey(), (double) sum / 5.0);
    }
    return result;
}

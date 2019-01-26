class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.val == p2.val) {
                    return 0;
                }
                return p1.val < p2.val ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        minHeap.offer(new Pair(0, 0, matrix[0][0]));
        visited[0][0] = true;
        while (k > 1) {
            Pair p = minHeap.poll();
            if (p.x + 1 < matrix.length && !visited[p.x + 1][p.y]) {
                minHeap.offer(new Pair(p.x + 1, p.y, matrix[p.x + 1][p.y]));
                visited[p.x + 1][p.y] = true;
            }
            if (p.y + 1 < matrix.length && !visited[p.x][p.y + 1]) {
                minHeap.offer(new Pair(p.x, p.y + 1, matrix[p.x][p.y + 1]));
                visited[p.x][p.y + 1] = true;
            }
            k--;
        }
        return minHeap.poll().val;
    }
    
    class Pair {
        int x;
        int y;
        int val;
        Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}

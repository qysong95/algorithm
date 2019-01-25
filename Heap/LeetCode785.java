class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited.containsKey(i)) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited.put(i, 0);
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    int curCol = visited.get(node);
                    int neiCol = curCol == 0 ? 1 : 0;
                    for (int nei: graph[node]) {
                        if (!visited.containsKey(nei)) {
                            visited.put(nei, neiCol);
                            queue.offer(nei);
                        } else if (visited.get(nei) != neiCol) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

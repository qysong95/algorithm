public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.isEmpty()) {
        return;
    }
    LinkedList<Integer> buffer = new LinkedList<>();
    LinkedList<Integer> result = new LinkedList<>();
    while (!s1.isEmpty()) {
        int globalMin = Integer.MAX_VALUE;
        while (!s1.isEmpty()) {
            int temp = s1.pollFirst();
            globalMin = Math.min(globalMin, temp);
            buffer.offerFirst(temp);
        }
        while (!buffer.isEmpty()) {
            int temp = buffer.pollFirst();
            if (temp == globalMin) {
                result.offerFirst(temp);
            } else {
                s1.offerFirst(temp);
            }
        }
    }
    while (!result.isEmpty()) {
        s1.offerFirst(result.pollFirst());
    }
}

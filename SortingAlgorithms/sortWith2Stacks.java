public void sort(LinkedList<Integer> s1) {
    if (s1 == null || s1.isEmpty()) {
        return;
    }
    LinkedList<Integer> s2 = new LinkedList<>();
    while (!s1.isEmpty()) {
        int globalMin = Integer.MAX_VALUE;
        int size = s1.size();
        while (!s1.isEmpty()) {
            int temp = s1.pollFirst();
            globalMin = Math.min(globalMin, temp);
            s2.offerFirst(temp);
        }
        int count = 0;
        while (size > 0) {
            int temp = s2.pollFirst();
            if (temp == globalMin) {
                count++;
            } else {
                s1.offerFirst(temp);
            }
            size--;
        }
        while (count > 0) {
            s2.offerFirst(globalMin);
            count--;
        }
        while (!s2.isEmpty()) {
            s1.offerFirst(s2.pollFirst());
        }
    }
}

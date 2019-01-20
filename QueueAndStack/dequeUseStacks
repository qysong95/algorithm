class Deque {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    
    Deque() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void offerFirst(int x) {
        stack1.offerFirst(x);
    }
    
    public void offerLast(int x) {
        stack2.offerFirst(x);
    }
    
    public void pollFirst() {
        if (stack1.isEmpty()) {
            move(stack1, stack2);
        }
        stack1.pollFirst();
    }
    
    public void pollLast() {
        if (stack2.isEmpty()) {
            move(stack2, stack1);
        }
        stack2.pollFirst();
    }
    
    public int peekFirst() {
        if (stack1.isEmpty()) {
            move(stack1, stack2);
        }
        return stack1.peekFirst();
    }
    
    public int peekLast() {
        if (stack2.isEmpty()) {
            move(stack2, stack1);
        }
        return stack2.peekFirst();
    }
    
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

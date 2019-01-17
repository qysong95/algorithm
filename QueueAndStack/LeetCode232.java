class MyQueue {
    
    LinkedList<Integer> in;
    LinkedList<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.offerFirst(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()) {
            helper();
        }
        return out.pollFirst();
    }
    
    /** Get the front element. */
    public int peek() {
        if (out.isEmpty()) {
            helper();
        }
        return out.peekFirst();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
    
    private void helper() {
        while (!in.isEmpty()) {
            out.offerFirst(in.pollFirst());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

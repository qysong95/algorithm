class MinStack {
    
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;
    LinkedList<Integer> index;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        index = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.offerFirst(x);
        if (minStack.isEmpty() || x < minStack.peekFirst()) {
            minStack.offerFirst(x);
            index.offerFirst(stack.size());
        }
    }
    
    public void pop() {
        stack.pollFirst();
        if (stack.size() < index.peekFirst()) {
            minStack.pollFirst();
            index.pollFirst();
        }
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

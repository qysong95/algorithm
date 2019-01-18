class MyStack {
    
    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue1.offerFirst(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (queue1.size() > 1) {
            queue2.offerFirst(queue1.pollLast());
        }
        LinkedList<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.pollLast();
    }
    
    /** Get the top element. */
    public int top() {
        while (queue1.size() > 1) {
            queue2.offerFirst(queue1.pollLast());
        }
        int res = queue1.pollLast();
        queue2.offerFirst(res);
        LinkedList<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack = new LinkedList<Integer>();
    
    public MinStack() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
    }
    
    public void pop() {
        int num = stack.pop();
        if(num == minStack.peek())
            minStack.remove();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
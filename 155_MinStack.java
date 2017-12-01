class MinStack {
    private long min;
    private Stack<Long> stack;

    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int x) {
        long value = x - min;

        stack.push(value);

        if (value < 0) {
            min = x;
        }
    }
    
    public void pop() {
        long value = stack.pop();

        if (value < 0) {
            min -= value;
        }
    }
    
    public int top() {
        long value = stack.peek();

        if (value > 0) {
            return (int)(value + min);
        } else {
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int)min;
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
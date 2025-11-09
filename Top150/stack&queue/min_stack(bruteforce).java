class MinStack {
    Stack<Integer> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        Stack<Integer> temp = new Stack<>();
        int min = Integer.MAX_VALUE;

        while(!st.isEmpty()) {
            min = Math.min(min, st.peek());
            temp.push(st.pop());
        }

        while(!temp.isEmpty()) {
            st.push(temp.pop());
        }

        return min;
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

// Time Complexity: O(1) for push, pop, top; O(n) for getMin
// Space Complexity: O(n)
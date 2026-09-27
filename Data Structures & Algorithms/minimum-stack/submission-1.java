/*
"They'll come loud and they'll come fast
But we shoot first and we can last"
- Keep your rifle by your side, Far Cry 5
*/

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    
    public void push(int value) {
        stack.push(value);
        
        if(minStack.size() == 0){
            minStack.push(value);
        }
        else if(minStack.peek() >= value){
            minStack.push(value);
        }
    }
    
    public void pop() {
        int popped = this.stack.pop();
        if(minStack.peek() == popped){
            minStack.pop();
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
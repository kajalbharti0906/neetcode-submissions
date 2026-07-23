class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        if(minStack.isEmpty()) {
            minStack.add(val);
        }
        else if(minStack.peek()>=val) {
            minStack.push(val);
        }
        stack.push(val);
        
    }
    
    public void pop() {
        System.out.println(stack.peek() + " " + minStack.peek());
        int val1 = stack.peek();
        int val2 = minStack.peek();
        if(val1 == val2) {
            System.out.println(minStack.peek());
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty()?null:stack.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty()?null:minStack.peek();
    }
}

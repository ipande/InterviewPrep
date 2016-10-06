package easy.stacks;


import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<Integer>();
        minStack  = new Stack<Integer>();
    }

    public void push(int x) {
        mainStack.push(x);

        if(minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        int x = mainStack.pop();

        if(!minStack.isEmpty()){
            if(x == minStack.peek())
                minStack.pop();
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        if(!minStack.isEmpty())
            return minStack.peek();
        else
            return 0;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(-3);
        minStack.push(0);
        System.out.println(minStack.getMin()); // should be -3
    }
}
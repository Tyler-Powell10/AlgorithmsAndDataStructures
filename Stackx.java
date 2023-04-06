// package stacksandqueues;

import static java.lang.System.exit;

class StackX {

    private int maxSize;        // size of stack array
    private char[] stackArray;
    private int top;            // top of stack

    public String toString() {
        String elements = "[ ";
        for (int i = 0; i < top; i++) {
            elements += stackArray[i] + " ";
        }
        elements += "]";
        return elements;
    }

//--------------------------------------------------------------
    public StackX(int s) // constructor
    {
        maxSize = s;             // set array size
        stackArray = new char[maxSize];  // create array
        top = -1;                // no items yet
    }
//--------------------------------------------------------------

    public void push(char j) // put item on top of stack
    {   
        if(isFull()){
            System.out.println("The STACK Is Full create a new one");
            exit(0);
        }
        stackArray[++top] = j;     // increment top, insert item
    }
//--------------------------------------------------------------

    public char pop() // take item from top of stack
    {   
        if(isEmpty()){
            System.out.println("The STACK Is Empty");
            exit(0);
        }
        return stackArray[top--];  // access item, decrement top
    }
//--------------------------------------------------------------

    public char peek() // peek at top of stack
    {
        return stackArray[top];
    }
//--------------------------------------------------------------

    public boolean isEmpty() // true if stack is empty
    {
        return (top == -1);
    }
//--------------------------------------------------------------

    public boolean isFull() // true if stack is full
    {
        return (top == maxSize - 1);
    }
//--------------------------------------------------------------

    private void Exit(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}  // end class StackX

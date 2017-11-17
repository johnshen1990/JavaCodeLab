package io.github.johnshen1990.javacodelab.javabasic.stack;

import java.util.EmptyStackException;

public class MyStack {
    private Object[] data;
    // 栈顶指针，空栈时为0
    private int top = 0;

    public MyStack() {
        this(10);
    }
    public MyStack(int size) {
        data = new Object[size];
    }

    public void push(Object obj) throws StackOverflowError {
        if(top >= data.length) {
            throw new StackOverflowError();
        }
        data[top] = obj;
        top ++;
    }

    public Object pop() throws EmptyStackException {
        if(top == 0) {
            throw new EmptyStackException();
        }
        top --;
        Object forReturn = data[top];
        data[top] = null; // help gc
        return forReturn;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("123");
        myStack.push("456");
        // myStack本次pop出的对象只是被打印了一下，没有用任何的变量存储这个对象引用。
        // 然而，这个对象却不会被GC，因为data[1]依然保存了这个对象的引用。虽然从程序逻辑上不可能再取到这个对象。
        System.out.println((String)myStack.pop());
    }
}

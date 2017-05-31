package main.algo.objects;

public class Stack {

    int[] a = new int[256];

    int top = 0;

    public static boolean stackEmpty(Stack s) {
        return s.top == 0? true : false;
    }

    public static void push(Stack s, int x) {
        s.top = s.top + 1;
        s.a[s.top] = x;
    }

    public static int pop(Stack s) {
        if(Stack.stackEmpty(s)) {
            throw new RuntimeException("error underflow");
        } else {
            s.top--;
        }
        return s.a[--s.top];
    }
}

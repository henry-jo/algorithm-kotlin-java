package impl;


import java.util.Scanner;
import java.util.Stack;

public class ATaleOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T> {
    private Stack firstStack;
    private Stack secondStack;

    MyQueue() {
        firstStack = new Stack();
        secondStack = new Stack();
    }

    void enqueue(int value) {
        firstStack.push(value);
    }

    void dequeue() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        secondStack.pop();
    }

    int peek() {
        if (secondStack.isEmpty()) {
            while (!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        return (int) secondStack.peek();
    }
}

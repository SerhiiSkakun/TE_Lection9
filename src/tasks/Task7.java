//7. Задать два стека, поменять информацию местами.
package tasks;

import java.util.Stack;

public class Task7 {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack1.push(i);
            stack2.push(i*2);
        }
        System.out.println(stack1.toString());
        System.out.println(stack2.toString());
        stacksChange(stack1,stack2);
        System.out.println(stack1.toString());
        System.out.println(stack2.toString());
    }

    public static void stacksChange(Stack<Integer> stack1, Stack<Integer> stack2) {
        int stack1Length = stack1.size();
        int stack2Length = stack2.size();
        Stack<Integer> sumStack = new Stack<>();
        for (int i = 0; i < stack1Length; i++) {
            sumStack.push(stack1.pop());
        }
        for (int i = 0; i < stack2Length; i++) {
            sumStack.push(stack2.pop());
        }
        for (int i = 0; i < stack2Length; i++) {
            stack1.push(sumStack.pop());
        }
        for (int i = 0; i < stack1Length; i++) {
            stack2.push(sumStack.pop());
        }
    }
}

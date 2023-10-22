import java.util.Stack;

public class three {
    public static void foldStack(Stack<Integer> stack) { //сворачиваем стек с помощью перевернутого
        Stack<Integer> newStack = new Stack<>();
        while (!stack.isEmpty()) {
            newStack.push(stack.pop());
        }
        while (!newStack.isEmpty()) {
            if (newStack.size() >= 2) {
                int first = newStack.pop();
                int second = newStack.pop();
                int sum = first + second;
                stack.push(sum);
            } else {
                stack.push(newStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Заданный стек: " + stack);
        foldStack(stack);
        System.out.println("Измененный стек: " + stack);
    }
}
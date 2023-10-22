import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class two {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(14);
        stack.push(9);

        System.out.print("Заданный стек: " + stack + "\n");

        duplicate(stack);

        System.out.print("Стейк с дубликатами: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void duplicate(Stack<Integer> stack) {
        Queue<Integer> queue = new LinkedList<>();

        while (!stack.isEmpty()) {
            int value = stack.pop();
            queue.add(value); //добавляем значение в очередь дважды для хранения удвоенных значений в обратном порядке
            queue.add(value);
        }

        while (!queue.isEmpty()) { //перекладываем значения обратно в стек.
            stack.push(queue.poll());
        }
    }
}
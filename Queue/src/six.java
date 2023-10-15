import java.util.*;

public class six {
    public static void main(String[] args) {
        //создание двух стеков
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        //добавление элементов в стеки
        stack1.push(8);
        stack1.push(6);
        stack1.push(4);

        stack2.push(2);
        stack2.push(33);
        stack2.push(15);

        //создание очереди для двух стеков
        Queue<Integer> queue = new LinkedList<>();
        while (!stack1.empty()) {
            queue.add(stack1.pop());
        }
        while (!stack2.empty()) {
            queue.add(stack2.pop());
        }

        //вывод содержимого очереди
        System.out.println("Очередь: " + queue);
    }
}
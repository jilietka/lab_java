import java.util.*;

public class seven {
    public static void main(String[] args) {
        //создание очереди с целыми числами
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(8);
        queue.add(5);
        queue.add(8);
        queue.add(1);

        //проверка, является ли очередь палиндромом
        boolean isPalindrome = isPalindrome(queue);

        //вывод результата
        if (isPalindrome) {
            System.out.println("Очередь является палиндромом");
        } else {
            System.out.println("Очередь не является палиндромом");
        }
    }

    public static boolean isPalindrome(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        //копирование элементов очереди в стек
        for (Integer element : queue) {stack.push(element);}

        //проверка на палиндром
        for (Integer element : queue) {
            if (element != stack.pop()) {return false;}
        }
        return true;
    }
}

import java.util.*;

public class two {
    public static void main(String[] args) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        //заполнение очередей фамилиями
        queue1.add("Морозов");
        queue1.add("Соколов");
        queue1.add("Васильев");

        queue2.add("Тарасов");
        queue2.add("Соколов");

        Queue<String> uniqueQueue = removeDuplicates(queue1, queue2); //вывод очереди без дубликатов
        System.out.println("Очередь без дубликатов:");
        System.out.println(uniqueQueue);
    }

    //метод, который удаляет повторяющиеся элементы
    public static Queue<String> removeDuplicates(Queue<String> queue1, Queue<String> queue2) {
        Queue<String> uniqueQueue = new LinkedList<>(queue2);

        while (!queue1.isEmpty()) { //если очередь не пустая, то присваиваем переменной "срезанный" элемент
            String client = queue1.poll();
            //если очередь не содержит отрезанный элемент, то добавляем
            if (!uniqueQueue.contains(client)) {uniqueQueue.add(client);}
        }
        return uniqueQueue;
    }
}

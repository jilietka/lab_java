import java.util.*;

public class one {
    public static void main(String[] args) {
        Queue<String> queue1 = new LinkedList<>(); //создание очередей
        Queue<String> queue2 = new LinkedList<>();

        //заполнение очередей фамилиями
        queue1.add("Морозов");
        queue1.add("Соколов");
        queue1.add("Васильев");

        queue2.add("Тарасов");
        queue2.add("Сергеев");

        Queue<String> mergeQueue = mergeQueues(queue1, queue2); //вывод соединенных очередей
        System.out.println("\nСлияние двух очередей:");
        System.out.println(mergeQueue);
    }

    //метод, который соединяет очереди
    public static Queue<String> mergeQueues(Queue<String> queue1, Queue<String> queue2) {
        Queue<String> mergeQueue = new LinkedList<>(); //создание очереди, в которую сольются две очереди

        while (!queue1.isEmpty() || !queue2.isEmpty()) { //если очереди не пустые, то в условие
            //добавляем в новую очередь элемент, который удалили сверху
            if (!queue1.isEmpty()) {mergeQueue.add(queue1.poll());}
            if (!queue2.isEmpty()) {mergeQueue.add(queue2.poll());}
        }
        return mergeQueue;
    }
}
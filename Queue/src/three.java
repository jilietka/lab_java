import java.util.LinkedList;
import java.util.Queue;

public class three {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        //заполнение очередей фамилиями
        queue.add("Антонов");
        queue.add("Тарасов");
        queue.add("Афанасьев");
        queue.add("Карпов");

        excludeElements(queue);
    }

    public static void excludeElements(Queue<String> queue) {
        int initialSize = queue.size(); //размер очереди
        int excludedCount = 0; //счетчик фамилий на А

        while (!queue.isEmpty()) { //если очередь не пустая, то срезаем
            String element = queue.poll();
            //если срезанный элемент начинается с А, то обновляем счетчик
            if (element.startsWith("А")) {excludedCount++;}
            //иначе выкидываем обратно в очередь
            else {queue.add(element);}
        }

        System.out.println("Длина очереди: " + (initialSize - excludedCount));
        System.out.println("Первый элемент: " + queue.peek());
        System.out.println("Последний элемент: " + queue.peek());
    }
}
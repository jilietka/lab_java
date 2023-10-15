package five;

import java.util.*;

public class five {
    public static void main(String[] args) {
        //создаем дек с 3 элементами дабл типа
        Deque<Triple<Double, Double, Double>> deque = new ArrayDeque<>();

        //заполняем дек
        deque.add(new Triple<>(1.8, 6.4, 9.7));
        deque.add(new Triple<>(3.5, 2.9, 10.1));
        deque.add(new Triple<>(4.2, 7.3, 8.6));

        //вводим значение, с которым будем проверять все значения в деке
        double maxValue = 3.0;

        //исключаем тройки жлементов, превышающих значение для сравнения
        Iterator<Triple<Double, Double, Double>> iterator = deque.iterator(); //создаем паттерн для дальнейших действий
        while (iterator.hasNext()) { //пока мы можем что-то считать
            Triple<Double, Double, Double> triple = iterator.next();//выбрасываем исключение для hasNext
            if (triple.getFirst() > maxValue && triple.getSecond() > maxValue && triple.getThird() > maxValue) {
                iterator.remove(); //если все три больше, то удаляем все 3 элемента
            }
        }

        //выводим длину и первый/последний элементы после удаления
        System.out.println("Длина дека: " + deque.size());
        if (!deque.isEmpty()) {
            Triple<Double, Double, Double> firstElement = deque.getFirst();
            Triple<Double, Double, Double> lastElement = deque.getLast();
            System.out.println("Первый элемент: " + firstElement);
            System.out.println("Последний элемент: " + lastElement);
        } else {
            System.out.println("Дек пуст");
        }
    }
}


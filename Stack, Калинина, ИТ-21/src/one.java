import java.util.Stack;

public class one{
    public static void minElement(Stack<Integer> stack){
        Stack<Integer> newStack = new Stack<>(); //стек для сохранения элементов исходного стека
        int minElem = Integer.MAX_VALUE;

        while (!stack.isEmpty()) { //поиск минимального элемента и заполнение временного стека
            int elem = stack.pop();
            if (elem < minElem) {minElem = elem;}
            newStack.push(elem);
        }
        //возвращаем элементы обратно в исходный стек, вставляя 0 после минимального элемента
        boolean minBool = false;
        while (!newStack.isEmpty()) {
            int elem = newStack.pop();
            if (elem == minElem && ! minBool){
                stack.push(elem);
                stack.push(0);
                minBool = true;
            } else {
                stack.push(elem);
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(6);
        stack.push(4);
        stack.push(2);
        stack.push(33);
        stack.push(15);

        System.out.println("Заданный стек: " + stack);
        minElement(stack);
        System.out.println("Измененный стек: " + stack);
    }
}
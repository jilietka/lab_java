package five;
//класс для хранения трех элементов разных типов (в классе five задали тип данных)
public class Triple<T1, T2, T3> {
    final T1 first;
    final T2 second;
    final T3 third;

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T1 getFirst() {return first;}

    public T2 getSecond() {return second;}

    public T3 getThird() {return third;}

    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}
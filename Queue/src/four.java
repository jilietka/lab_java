import java.util.*;

public class four {
    final String lastName;
    final int groupNumber;
    final int birthYear;

    public four(String lastName, int groupNumber, int birthYear) {
        this.lastName = lastName;
        this.groupNumber = groupNumber;
        this.birthYear = birthYear;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public static void main(String[] args) {
        Queue<four> studentsQueue = new LinkedList<>();

        //добавление студентов
        studentsQueue.add(new four("Кикишвили", 1, 2003));
        studentsQueue.add(new four("Казаков", 1, 2003));
        studentsQueue.add(new four("Морозов", 1, 2000));
        studentsQueue.add(new four("Тарасов", 2, 2004));

        int targetYear = 2003; //год рождения, кого записываем в очередь

        Queue<four> targetYearStudentsQueue = new LinkedList<>(); //очередь по введенному году рождения

        for (four student : studentsQueue) { //сравниваем год, если сходится, то записываем в новую очередь
            if (student.getBirthYear() == targetYear) {targetYearStudentsQueue.add(student);}
        }

        System.out.println("Студенты заданного года рождения:");
        for (four student : targetYearStudentsQueue) {
            System.out.println("Фамилия: " + student.getLastName() +
                    ", Группа: " + student.getGroupNumber() +
                    ", Год рождения: " + student.getBirthYear());
        }
    }
}
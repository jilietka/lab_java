import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите количество продавцов: ");
        final int prod = scan.nextInt(); // количество продавцов
        int[] seller = new int[prod];  //массив с продавцами
        int sum = 0; //общие продажи

        for (int i = 0; i < seller.length; i++) {
            System.out.print("Введите количество продаж для продавца " + (i + 1) + ": ");
            seller[i] = scan.nextInt();
        }

        System.out.println("\n\n");
        int max = seller[0];
        int min = seller[0];
        int idMax = 0;
        int idMin = 0;

        for (int i = 0; i < seller.length; i++) {
            System.out.println("Продажи продавца " + (i + 1) + ": " + seller[i]);
            sum += seller[i];
            if (seller[i] > max) {
                max = seller[i];
                idMax = i + 1;
            }

            if (seller[i] <= min) {
                min = seller[i];
                idMin = i + 1;
            }
        }

        System.out.println("Общие продажи: " + sum + "\n");
        System.out.println("Среднее количество продаж: " + (sum / prod) + "\n");
        System.out.println("Продавец " + idMax + " совершил самую большую продажу на " + max + " руб.");
        System.out.println("Продавец " + idMin + " совершил самую малую продажу на " + min + " руб.");

        System.out.print("\nВведите целое число для сравнения количества продаж: ");
        int simile = scan.nextInt();
        int count = 0;
        System.out.println("\nПродажи больше " + simile + " у ");

        for (int i = 0; i < seller.length; i++) {
            if (seller[i] > simile) {
                System.out.println("продавца " + (i + 1) + ": " + seller[i] + " руб.");
                count++;
            }
        }
        System.out.println("\nВсего продажи введенного значения превысили: " + count);
    }
}

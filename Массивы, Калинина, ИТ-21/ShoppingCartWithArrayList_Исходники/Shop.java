import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();
        double totalPrice = 0.0; //общая стоимость покупок
        Scanner scan = new Scanner(System.in);
        String ans = "Да";

        do {
            System.out.print("\nВведите название товара: ");
            String itemName = scan.nextLine();

            System.out.print("Введите цену за единицу: ");
            double itemPrice = scan.nextDouble();

            System.out.print("Введите количество: ");
            int quantity = scan.nextInt();
            scan.nextLine();

            Item item = new Item(itemName, itemPrice, quantity); //создаем новый товар и добавляем его в корзину
            cart.add(item);

            System.out.println("\nТовары в корзине:");
            for (Item product: cart) {
                System.out.println(product.toString());
                totalPrice += product.getPrice() * product.getQuantity();
            }

            System.out.println("\nОбщая стоимость: " + totalPrice);

            System.out.print("\nПродолжим покупки(Да/Нет)? ");
            ans = scan.nextLine();

        } while (ans.equalsIgnoreCase("Да"));
    }
}

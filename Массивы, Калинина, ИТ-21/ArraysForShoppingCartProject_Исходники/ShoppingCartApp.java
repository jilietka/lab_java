import java.text.NumberFormat;
import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        String ans = "Да";

        do {
            System.out.print("\nВведите название товара: ");
            String itemName = scan.nextLine();

            System.out.print("Введите цену товара: ");
            double price = scan.nextDouble();

            System.out.print("Введите количество товара: ");
            int quantity = scan.nextInt();
            scan.nextLine();

            cart.addToCart(itemName, price, quantity); //добавляем товары

            System.out.println(cart.toString());

            if (cart.itemCount == cart.capacity) {cart.increaseSize();} // Увеличение размера корзины

            System.out.print("Хотите добавить еще товары? (Да/Нет): ");
            ans = scan.nextLine();

        } while (ans.equalsIgnoreCase("Да"));

        double tPrice = cart.totalPrice; //общая стоимость
        NumberFormat fmt = NumberFormat.getCurrencyInstance(); //используется для форматирования (приведение к денежному типу)
        System.out.print("\nИтоговая стоимость корзины " + fmt.format(tPrice));
    }
}



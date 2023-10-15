import java.text.NumberFormat;
import java.util.Scanner;

public class ShoppingCart {
    int itemCount; //количество товаров в корзине
    double totalPrice; //стоимость товаров в корзине
    int capacity; //вместимость корзины
    private Item[] cart; //товары

    // Создает пустую корзину для покупок, вмещающую 5 товаров.
    public ShoppingCart() {
        capacity = 5;
        itemCount = 0;
        totalPrice = 0.0;
        cart = new Item[capacity]; //обозначаем вместимость корзины
    }

    // добавляет товар в корзину.
    public void addToCart(String itemName, double price, int quantity) {
        Item newItem = new Item(itemName, price, quantity);
        cart[itemCount] = newItem; //добавляем товар
        itemCount++;
        totalPrice += price * quantity; //общая стоимость за товары в корзине
    }

    //Возвращает содержимое корзины вместе с итоговой информацией.
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(); //используется для форматирования (приведение к денежному типу)
        String contents = "\nКорзина\n";
        contents += "\nItem\t\tUnit Price\t\tQuantity\t\tTotal\n";
        for (int i = 0; i < itemCount; i++){
            System.out.println(cart[i]);
            contents += cart[i].toString() + "\n";
        }
        contents += "\nОбщая цена: " + fmt.format(totalPrice);
        contents += "\n";
        return contents;
    }

    /// Увеличивает вместимость корзины
    void increaseSize() {

        Scanner scan = new Scanner(System.in);
        System.out.print("В корзине закончилось место. Давайте увеличим ее на: ");
        int num = scan.nextInt();

        int newCapacity = capacity + num; //увеличение вместимости корзины
        Item[] newCart = new Item[newCapacity]; //корзина с увеличением вместимости

        for (int i = 0; i < itemCount; i++) {newCart[i] = cart[i];}

        cart = newCart;
        capacity = newCapacity;
    }
}

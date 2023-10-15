import java.text.NumberFormat;

public class Item {
    final String name;
    final double price;
    final int quantity;

    // Конструктор для создания нового объекта
    public Item(String itemName, double itemPrice, int numPurchased) {
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
    }

    // Метод возвращает информацию о товаре
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return (name + "\t" + fmt.format(price) + "\t" + quantity + "\t"
                + fmt.format(price * quantity));
    }
}

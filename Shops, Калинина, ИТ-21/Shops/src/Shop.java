import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Shop {
    ArrayList<Item> shop = new ArrayList<>();

    public void addItem(Item item) {
        shop.add(item);
    }

    public void deleteProd() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nВведите номер товара, который следует удалить: ");
        int number = scan.nextInt();
        scan.nextLine();

        if ((number - 1) <= shop.size()) {
            shop.remove((number - 1));
            System.out.println("Товар успешно удален");
        } else {
            System.out.println("Введенный номер больше количества товаров в магазине, повторите попытку");
        }
    }

    public void printProd() {
        for (Item item : shop) {
            System.out.println("ID: " + item.getId() + "\nТовар: " + item.getName() + "\nЦена: " + item.getPrice() +
                    "\nКоличество: " + item.getCount() + "\nДата поставки: " + item.getArrivingDate());
        }
    }

    public double getTotalPrice(String name) {
        double totalPrice = 0.0;
        for (Item item : shop) {
            if (item.getName().equals(name)) {
                totalPrice += item.getPrice() * item.getCount() * 1.13;
            }
        }
        if (totalPrice == 0.0) {
            System.out.println("Не найден товар с данным названием");
        }
        return totalPrice;
    }

    public void printDate(Date date) {
        boolean hasProd = false;
        for (Item item : shop) {
            if (item.getArrivingDate().equals(date)) {
                System.out.println("\nТовары, прибывшие в указанную дату:");
                System.out.println("ID: " + item.getId() + "\nТовар: " + item.getName() + "\nЦена: " + item.getPrice() +
                        "\nКоличество: " + item.getCount() + "\nДата поставки: " + item.getArrivingDate());
                hasProd = true;
            }
        }

        if (!hasProd) {
            System.out.println("Товары, прибывшие в указанную дату, отсутствуют");
        }
    }

    public static void main(String[] args) throws java.text.ParseException {

        Shop shop = new Shop();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy");

        Item fish = new Item("Рыба", 130.0, format.parse("13-09-23"), 4, 1);
        Item meat = new Item("Мясо", 120.0, format.parse("14-09-23"), 13, 2);
        Item milk = new Item("Молоко", 80.0, format.parse("15-09-23"), 15, 3);
        Item cheese = new Item("Сыр", 340.0, format.parse("12-09-23"), 6, 4);

        shop.addItem(fish);
        shop.addItem(meat);
        shop.addItem(milk);
        shop.addItem(cheese);

        shop.deleteProd();
        System.out.println("\nСписок товаров после удаления:");
        shop.printProd();
        shop.printDate(format.parse("12-09-2023"));

    }
}
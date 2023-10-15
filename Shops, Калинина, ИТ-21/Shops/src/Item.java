import java.util.Date;
import java.text.NumberFormat;
public class Item {
    final String name;
    final double price;
    final Date ArrivingDate;
    final int count;
    final int id;
    public Item(String itemName, double itemPrice, Date newDate, int newCount, int newID) {
        name = itemName;
        price = itemPrice;
        ArrivingDate = newDate;
        count = newCount;
        id = newID;
    }

    public String Info() {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance();
        return (name + "\t" + fmt.format(price) + "\t" + count + "\t"
                + fmt.format(price * count) + "\t" + ArrivingDate);
    }

    public double getPrice() {return price;}
    public String getName() {return name;}
    public int getCount() {return count;}
    public Date getArrivingDate() {return ArrivingDate;}
    public int getId() {return id;}
}
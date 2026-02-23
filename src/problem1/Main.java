import java.text.NumberFormat;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args) 
    {
        ArrayList<Item> cart = new ArrayList<>();

        Item item1 = new Item("Apple", 0.99, 5);
        Item item2 = new Item("Milk", 1.49, 2);
        Item item3 = new Item("Bread", 2.5, 1);

        cart.add(item1);
        cart.add(item2);
        cart.add(item3);

        System.out.println("Current Cart:");
        double totalPrice = 0.0;
        for (Item i : cart) {
            System.out.println(i);
            totalPrice += i.getPrice() * i.getQuantity();
        }

        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("Total: " + fmt.format(totalPrice));
    }
}
import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
public class Shop
{
    public static void main (String[] args)
    {
        ArrayList<Item> cart = new ArrayList<>();
        String itemName;
        double itemPrice;
        int quantity;
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";
        do
        {
            System.out.print ("Enter the name of the item: ");
            itemName = scan.nextLine();

            System.out.print ("Enter the unit price: ");
            itemPrice = scan.nextDouble();

            System.out.print ("Enter the quantity: ");
            quantity = scan.nextInt();

            scan.nextLine(); 
// *** create a new item and add it to the cart
        Item item = new Item(itemName, itemPrice, quantity);
            cart.add(item);
            // *** print the contents of the cart object using println
            System.out.println("\nCurrent Cart:");
            double totalPrice = 0.0;
            for (Item i : cart) 
            {
                System.out.println(i);
                totalPrice += i.getPrice() * i.getQuantity();
            }

            NumberFormat fmt = NumberFormat.getCurrencyInstance();
            System.out.println("Total: " + fmt.format(totalPrice));

            System.out.print ("Continue shopping (y/n)? ");
            keepShopping = scan.nextLine();
            System.out.println();
        }
        while (keepShopping.equals("y"));
        System.out.println("Thank you for shopping!");
        scan.close();
    }
}
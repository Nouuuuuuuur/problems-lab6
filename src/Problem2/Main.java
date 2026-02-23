public class Main 
{
    public static void main(String[] args) 
    {
        Bank bank = new Bank("MyBank");

        bank.addCustomer("Ali");
        bank.addCustomer("Sara");

        bank.addTransaction("Ali", 100.0);
        bank.addTransaction("Ali", -20.5);
        bank.addTransaction("Sara", 50.0);
        bank.addTransaction("Sara", -10.0);

        bank.listCustomers();

        System.out.println();
        bank.printStatement("Ali");
        System.out.println();
        bank.printStatement("Sara");

        if (!bank.addTransaction("Nour", 30.0)) {
            System.out.println("Customer Nour not found!");
        }
    }
}
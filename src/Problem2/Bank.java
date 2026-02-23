import java.util.ArrayList;

public class Bank 
{
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) 
    {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public boolean addCustomer(String customerName) 
    {
        if (findCustomer(customerName) == null) 
        {
            customers.add(new Customer(customerName));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double amount) 
    {
        Customer c = findCustomer(customerName);
        if (c != null) 
        {
            c.addTransaction(amount);
            return true;
        }
        return false;
    }

    public void printStatement(String customerName) 
    {
        Customer c = findCustomer(customerName);
        if (c == null) 
        {
            System.out.println("Customer not found!");
            return;
        }

        System.out.println("Statement for: " + c.getName());
        double total = 0.0;
        for (Double t : c.getTransactions()) 
        {
            double amount = t;
            System.out.println((amount >= 0 ? "Credit: " : "Debit: ") + amount);
            total += amount;
        }
        System.out.println("Balance: " + total);
    }

    private Customer findCustomer(String name) 
    {
        for (Customer c : customers) 
        {
            if (c.getName().equalsIgnoreCase(name)) 
            {
                return c;
            }
        }
        return null;
    }

    public void listCustomers() 
    {
        System.out.println("Customers in bank " + name + ":");
        for (Customer c : customers) 
        {
            System.out.println("- " + c.getName());
        }
    }
}
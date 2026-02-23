import java.util.Scanner;
public class Test
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the capacity of the library: ");
        int capacity = scan.nextInt();
        scan.nextLine();

        Library library = new Library(capacity);

        library.add(new Novel("Mechanika", "Doug Chiang", 328, 230));
        library.add(new Magazine("National Geographic", "February", 2026));

        boolean exit = false;
        while (!exit) {
            System.out.println("  --- Library Menu ---");
            System.out.println("1. Display all documents");
            System.out.println("2. Add a document");
            System.out.println("3. Delete a document");
            System.out.println("4. Find document by number");
            System.out.println("5. Display authors");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) 
            {
                case 1: library.displayDocuments(); 
                        break;
                case 2:
                    if (library.getSize() >= library.getCapacity()) 
                    {
                        System.out.println("Library is full!");
                        break;
                    }
                    System.out.print("Enter document type (Novel/Textbook/Magazine/Dictionary): ");
                    String type = scan.nextLine();
                    System.out.print("Enter title: ");
                    String title = scan.nextLine();
                    if (type.equalsIgnoreCase("Novel")) 
                    {
                        System.out.print("Author: "); String author = scan.nextLine();
                        System.out.print("Pages: "); int pages = scan.nextInt();
                        System.out.print("Price: "); double price = scan.nextDouble(); scan.nextLine();
                        library.add(new Novel(title, author, pages, price));
                    } 
                    else if (type.equalsIgnoreCase("Magazine")) 
                    {
                        System.out.print("Month: "); String month = scan.nextLine();
                        System.out.print("Year: "); int year = scan.nextInt(); scan.nextLine();
                        library.add(new Magazine(title, month, year));
                    } 
                    else if (type.equalsIgnoreCase("Dictionary")) 
                    {
                        System.out.print("Language: "); String lang = scan.nextLine();
                        library.add(new Dictionary(title, lang));
                    } 
                    else if (type.equalsIgnoreCase("Textbook")) 
                    {
                        System.out.print("Author: "); String author = scan.nextLine();
                        System.out.print("Pages: "); int pages = scan.nextInt(); scan.nextLine();
                        System.out.print("Level: "); String level = scan.nextLine();
                        library.add(new Textbook(title, author, pages, level));
                    }
                    System.out.println("Document added.");
                    break;
                case 3:
                    System.out.print("Enter document number to delete: ");
                    int numDel = scan.nextInt(); scan.nextLine();
                    Document docDel = library.document(numDel);
                    if (docDel != null && library.delete(docDel)) System.out.println("Document deleted.");
                    else 
                        System.out.println("Document not found.");
                    break;
                case 4:
                    System.out.print("Enter document number to find: ");
                    int numFind = scan.nextInt(); scan.nextLine();
                    Document docFind = library.document(numFind);
                    System.out.println(docFind != null ? docFind : "Document not found.");
                    break;
                case 5: library.displayAuthors(); 
                    break;
                case 6: exit = true; System.out.println("Exiting..."); 
                    break;
                default: System.out.println("Invalid choice."); 
                    break;
            }
        }
        scan.close();
    }
}
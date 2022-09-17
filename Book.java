import java.util.Scanner;
public class Book {

    public int sNo;
    public String bookName;
    public String authorName;
    public int bookQty;
    public int availQty;

    Scanner sc = new Scanner(System.in);

    public Book()
    {
        System.out.println("Enter Serial No of Book:");
        this.sNo = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Book Name:");
        this.bookName = sc.nextLine();

        System.out.println("Enter Author Name:");
        this.authorName = sc.nextLine();

        System.out.println("Enter Quantity of Books:");
        this.bookQty = sc.nextInt();
        availQty= this.bookQty;
    }
}
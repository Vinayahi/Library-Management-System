import java.util.Scanner;

public class BookOperations {

    // Class data members
    Book[] theBooks = new Book[50];
    public static int count;

    Scanner sc = new Scanner(System.in);
    public int compareBookObjects(Book b1, Book b2)
    {

        if (b1.bookName.equalsIgnoreCase(b2.bookName)) {
            System.out.println("Book of this Name Already Exists.");
            return 0;
        }
        if (b1.sNo == b2.sNo) {

            // Print book exists
            System.out.println(
                    "Book of this Serial No Already Exists.");

            return 0;
        }
        return 1;
    }

    // Method 2
    // To add book
    public void addBook(Book b)
    {

        for (int i = 0; i < count; i++) {

            if (this.compareBookObjects(b, this.theBooks[i])
                    == 0)
                return;
        }

        if (count < 50) {

            theBooks[count] = b;
            count++;
        }
        else {

            System.out.println(
                    "No Space to Add More Books.");
        }
    }

    // Method 3
    // To search book by serial number
    public void searchBySno()
    {

        // Display message
        System.out.println(
                "\t\t\t\tSEARCH BY SERIAL NUMBER\n");

        // Class data members
        int sNo;
        System.out.println("Enter Serial No of Book:");
        sNo = sc.nextInt();

        int flag = 0;
        System.out.println(
                "S.No\t\tName\t\ttAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                System.out.println(
                        theBooks[i].sNo + "\t\t"
                                + theBooks[i].bookName+"\t\t"
                                + theBooks[i].authorName + "\t\t"
                                + theBooks[i].availQty + "\t\t"
                                + theBooks[i].bookQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Book for Serial No "+ sNo + " Found.");
    }

    public void searchByAuthorName()
    {
        System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");

        sc.nextLine();

        System.out.println("Enter Author Name:");
        String authorName = sc.nextLine();

        int flag = 0;

        System.out.println(
                "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            if (authorName.equalsIgnoreCase(
                    theBooks[i].authorName)) {

                System.out.println(
                        theBooks[i].sNo + "\t\t"
                                + theBooks[i].bookName + "\t\t"
                                + theBooks[i].authorName + "\t\t"
                                + theBooks[i].availQty + "\t\t"
                                + theBooks[i].bookQty);
                flag++;
            }
        }

        if (flag == 0)
            System.out.println("Book Not Found.");
    }

    public void showAllBooks()
    {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println(
                "S.No\t\tName\t\t\t\tAuthor\t\t\t\tAvailable Qty\t\t\t\tTotal Qty");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    theBooks[i].sNo + "\t\t\t"
                            + theBooks[i].bookName + "\t\t\t\t\t"
                            + theBooks[i].authorName + "\t\t\t\t"
                            + theBooks[i].availQty + "\t\t\t\t"
                            + theBooks[i].bookQty);
        }
    }

    public void upgradeBookQty()
    {

        System.out.println(
                "\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");

        int sNo = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (sNo == theBooks[i].sNo) {

                System.out.println("Enter No of Books to be Added:");

                int addingQty = sc.nextInt();
                theBooks[i].bookQty += addingQty;
                theBooks[i].availQty += addingQty;

                return;
            }
        }
    }

    public void menu()
    {

        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Enter 1 to Add new Book.");
        System.out.println("Enter 2 to Update Quantity of a Book.");
        System.out.println("Enter 3 to Search a Book.");
        System.out.println("Enter 4 to Display All Books.");
        System.out.println("Enter 5 to Register New Student.");
        System.out.println("Enter 6 to Display All Students.");
        System.out.println("Enter 7 to Borrow Book. ");
        System.out.println("Enter 8 to Return Book");
        System.out.println("Enter 0 to Exit");
        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

    public int isAvailable(int sNo)
    {

        for (int i = 0; i < count; i++) {
            if (sNo == theBooks[i].sNo) {
                if (theBooks[i].availQty > 0) {

                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;
            }
        }

        System.out.println("Not Available in Library.");
        return -1;
    }

    public Book borrowBook()
    {

        System.out.println("Enter Serial No of Book to Borrow.");
        int sNo = sc.nextInt();

        int bookIndex = isAvailable(sNo);

        if (bookIndex != -1) {
            theBooks[bookIndex].availQty--;
            return theBooks[bookIndex];
        }
        return null;
    }

    public void returnBook(Book b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theBooks[i])) {
                theBooks[i].availQty++;
                return;
            }
        }
    }
}

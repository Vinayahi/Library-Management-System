import java.util.Scanner;
public class LMS {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------MENU-------------------------");
        System.out.println("-----------------Select Any option-----------------");

        BookOperations ob = new BookOperations();
        StudentOperations obStudent = new StudentOperations();
        int option;
        int search;
        do {

            ob.menu();
            option= sc.nextInt();

            switch (option) {
                case 0:
                    break;

                case 1:
                    Book b = new Book();
                    ob.addBook(b);
                    break;

                case 2:
                    ob.upgradeBookQty();
                    break;

                case 3:

                    System.out.println(
                            " Enter 1 to Search with Book Serial No.");
                    System.out.println(
                            " Enter 2 to Search with Author Name.");
                    search = sc.nextInt();

                    switch (search) {

                        case 1:
                            ob.searchBySno();
                            break;

                        case 2:
                            ob.searchByAuthorName();
                    }
                    break;

                case 4:
                    ob.showAllBooks();
                    break;

                case 5:
                    Student s = new Student();
                    obStudent.addStudent(s);
                    break;

                case 6:
                    obStudent.showAllStudents();
                    break;
                case 7:
                    obStudent.checkOutBook(ob);
                    break;
                case 8:
                    obStudent.checkInBook(ob);
                    break;

                default:
                    System.out.println("PLEASE ENTER A VALID CHOICE BETWEEN 0 TO 8.");
            }

        }
        while (option != 0);
    }
}
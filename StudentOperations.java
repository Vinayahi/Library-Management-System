import java.util.Scanner;

public class StudentOperations {
    Scanner sc = new Scanner(System.in);
    Student[] Students = new Student[50];

    public static int count = 0;

    public void addStudent(Student s)
    {
        for (int i = 0; i < count; i++) {

            if (s.regNum.equalsIgnoreCase(Students[i].regNum)) {
                System.out.println("Student with Reg Num : " + s.regNum
                                + " is Already Registered.");

                return;
            }
        }

        if (count <= 50) {
            Students[count] = s;
            count++;
        }
    }

    public void showAllStudents()
    {

        System.out.println("Student Name\t\tReg Number\t\tBooks Borrowed");
        for (int i = 0; i < count; i++) {

            System.out.println(Students[i].studentName
                    + "\t\t\t\t"
                    + Students[i].regNum+ "\t\t\t\t"+ Students[i].booksCount);
        }
    }

    public int isStudent()
    {

        System.out.println("Enter Reg Number:");

        String regNum =sc.nextLine();

        for (int i = 0; i < count; i++) {

            if (Students[i].regNum.equalsIgnoreCase(regNum)) {
                return i;
            }
        }

        System.out.println("Student is not Registered.");
        System.out.println("Please Register First.");

        return -1;
    }

    public void checkOutBook(BookOperations book)
    {
        int studentIndex = this.isStudent();

        if (studentIndex != -1) {
            System.out.println("checking out");

            book.showAllBooks();
            Book b = book.borrowBook();

            System.out.println("checking out");
            if (b != null) {

                if (Students[studentIndex].booksCount < 3) {

                    Students[studentIndex].borrowedBooks[Students[studentIndex].booksCount]= b;
                    Students[studentIndex].booksCount++;

                    return;
                }
                else {

                    System.out.println(
                            "Student cannot Borrow more than 3 Books.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }

    public void checkInBook(BookOperations book)
    {
        int studentIndex = this.isStudent();
        if (studentIndex != -1) {
            System.out.println(
                    "S.No\t\t\tBook Name\t\t\tAuthor Name");

            Student s = Students[studentIndex];

            for (int i = 0; i < s.booksCount; i++) {

                System.out.println(s.borrowedBooks[i].sNo + "\t\t\t"
                                + s.borrowedBooks[i].bookName + "\t\t\t"
                                + s.borrowedBooks[i].authorName);
            }
            System.out.println("Enter Serial Number of Book to be returned:");

            int sNo = sc.nextInt();

            for (int i = 0; i < s.booksCount; i++) {
                if (sNo == s.borrowedBooks[i].sNo) {
                    book.returnBook(s.borrowedBooks[i]);
                    s.borrowedBooks[i] = null;

                    return;
                }
            }

            System.out.println("Book of Serial No not Found");
        }
    }
}
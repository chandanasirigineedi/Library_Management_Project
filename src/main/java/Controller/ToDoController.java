package Controller;

import DTO.BookStatus;
import Entity.Book;
import Entity.Borrower;
import Entity.Member;
import Service.Implementation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoController {
    List<Book> listOfBooks = new ArrayList<>();
    List<Member> listOfMembers=new ArrayList<>();
    List<Borrower> listOfBorrower= new ArrayList<>();
    BookService bookService = new BookServiceImpl();
    MemberService memberService = new MemberServiceImpl();
    BorrowerService borrowerService= new BorrowerServiceImpl() ;
    private Scanner scanner = new Scanner(System.in);
    public void runToDoApp(){
        while(true){
            showMenu();
            System.out.println("\nEnter the Action Number");
            String userAction = scanner.nextLine();
            performAction(Integer.parseInt(userAction));
        }
    }
    private void showMenu(){
        System.out.println("\t\t\t\t\t\t\t***********Welcome to the Library Managemet App!*************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t1. Manage Book (CRUD)");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t2. Manage member (CRUD)");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t3. Manage Borrower (CRUD)");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t4. Exit");
    }
    private void performAction(int action){
        switch(action){
            case 1:
                System.out.println("Action Menu: ");
                System.out.println("1.Register Book ");
                System.out.println("2.View Books");
                System.out.println("3.Update Books");
                System.out.println("4.Delete books");
                System.out.println("Enter the Action Number");
                String userAction = scanner.nextLine();
                ManageBooks(Integer.parseInt(userAction));
            break;
            case 2:System.out.println("Action Menu");
                System.out.println("1.Register Member ");
                System.out.println("2.View Members");
                System.out.println("3.Update Members");
                System.out.println("4.Delete Member");
                System.out.println("Enter the Action Number");
                String userAction1= scanner.nextLine();
                ManageMembers(Integer.parseInt(userAction1));
            break;
            case 3:System.out.println("1.Register Borrower ");
                   System.out.println("2.View Borrowers");
                   System.out.println("3.Return/Lost/Renewal Borrowers");
                   System.out.println("Enter the Action Number");
                   String userInput1= scanner.nextLine();
                   ManageBorrowers(Integer.parseInt(userInput1));
            break;
            case 4: System.exit(200);
            break;
            default:
                System.out.println("Invalid Action");
        }
    }




    private boolean ManageBooks(int action){
        switch(action){
            case 1: System.out.println("Register the Book ");
                System.out.print("BookID :");
                Integer sBookId= Integer.parseInt(scanner.nextLine());
                System.out.print("Title :");
                String sTitle=scanner.nextLine();
                System.out.print("Author :");
                String sAuthor=scanner.nextLine();
                System.out.print("ISBN :");
                Integer sISBN= Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the no of Copies:");
                Integer copies=Integer.parseInt(scanner.nextLine());
                Boolean isIssued=false;
                System.out.println(bookService.addBook(new Book(sBookId,sISBN,sAuthor,sTitle,isIssued,copies))+"\t\t Book added successfully");
                return true;
            case 2: System.out.println("View the Book");
                    List<Book> bookList=bookService.getBook();
                    for(Book ebook:bookList){
                     System.out.println(ebook.getBookId()+" , "+ebook.getISBN()+" , "+ebook.getTitle()+" , "+ebook.getAuthor()+" , "+ebook.isIssued()+" , "+ebook.getCopies());
                    }
                    return true;
            case 3: System.out.println("Update the book");
                    System.out.println("Enter Book ID : ");
                    Integer id= Integer.parseInt(scanner.nextLine());
                    System.out.println("Title :");
                    String title1=scanner.nextLine();
                    System.out.println("Author :");
                    String author=scanner.nextLine();
                    System.out.println(" ");
                    String s=bookService.updateBook(id,author,title1);
                    System.out.println(s);
                     return true;

            case 4: System.out.println("Enter Book ID to delete: ");
                    Integer bid = Integer.parseInt(scanner.nextLine());
                    List<Book> booklist=bookService.deleteBook(bid);

                    if (booklist != null) {
                        booklist.stream().forEach(book ->System.out.println(book.getAuthor()));
                        System.out.println(" Book deleted successfully!");

                      } else
                        System.out.println("Book not found.");
                System.out.println(" ");
                    return true;

            case 5: System.exit(200);
                    return true;
            default:
                System.out.println("Invalid Action");

        }
        return false;
    }
    private boolean ManageMembers(int action) {
        switch(action){
            case 1: System.out.println("Register the Member ");
                System.out.print("Enter memberID :");
                Integer sMemberId= Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Name :");
                String sName=scanner.nextLine();
                System.out.print("Enter MemberType :");
                String sMemberType=scanner.nextLine();
                System.out.print("Enter PhoneNumber :");
                Integer sPhoneNumber= Integer.parseInt(scanner.nextLine());
                Member  member= new Member(sMemberId,sName,sMemberType,sPhoneNumber);
                memberService.addMember(member);
                System.out.println("Member added successfully");
                break;
            case 2: System.out.println("View the Member");
                for(Member emember:memberService.getMember()){
                    System.out.println(emember.getMemberId()+" , "+emember.getName()+" , "+emember.getMemberType()+" , "+emember.getPhoneNumber());
                }
                break;
            case 3:
                System.out.println("Update the Member");
                System.out.println("Enter Member ID to update: ");
                Integer id= Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Member Type = " );
                String memberType=scanner.nextLine();
                System.out.println("Enter phoneNumber = ");
                Integer phoneNumber=Integer.parseInt(scanner.nextLine());

                if(memberService.updateMember(id,memberType,phoneNumber))
                {
                    System.out.println(" Member updated successfully!");
                } else {
                    System.out.println(" Member not found.");
                }
                break;
            case 4: System.out.println("Enter Member ID to delete: ");
                Integer mid = Integer.parseInt(scanner.nextLine());
                try {
                    if (memberService.deleteMember(mid)) {
                        System.out.println(mid + " Member deleted successfully!");
                    } else {
                        System.out.println("Member not found.");
                    }
                }catch (Exception e){
                    System.out.println("Exception raised");
                }
                break;
            case 5: System.exit(200);
                break;
            default:
                System.out.println("Invalid Action");

        }
        return false;

    }
    private boolean ManageBorrowers(int action){
        switch(action){
            case 1: System.out.println("Borrow the Book ");
                System.out.println("Enter BookID :");
                Integer sBookId= Integer.parseInt(scanner.nextLine());
                System.out.println("Enter memberID :");
                Integer sMemberId=Integer.parseInt(scanner.nextLine());
                System.out.println("Enter whether Book issued or not :");
                String status=scanner.nextLine();
                System.out.println(status);
                LocalDate borrowDate= LocalDate.now();
                LocalDate dueDate = borrowDate.plusDays(14);

                Borrower  borrower= new Borrower(sBookId,sMemberId,borrowDate,dueDate,null,status,0);
                borrowerService.addBorrower(borrower);
                System.out.println("Book Issued successfully");
                return true;
            case 2: System.out.println("View all Borrower");

                for(Borrower borrower1:borrowerService.viewAllBorrower()){
                    System.out.println(borrower1.getBookId()+","+borrower1.getMemberId()+" , "+
                            borrower1.getBorrowDate()+" , "+borrower1.getDueDate()+" , "+
                            borrower1.getReturnDate()+","+borrower1.getStatus()+","+borrower1.getFine());
                }
                return true;
            case 3:
                System.out.println("Return the book");
                System.out.println("Enter Member ID to update: ");
                Integer mid= Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Book ID to update: ");
                Integer bid= Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Book ISBN to update: ");
                Integer ISBN= Integer.parseInt(scanner.nextLine());
                System.out.println("Do you want return/renewal/Lost :");
                String status1=scanner.nextLine();
                Integer bid1=bookService.getBookId(bid,ISBN);
                Integer mid1= memberService.getMemberId(mid);
                if(borrowerService.updateBorrower(status1,bid,mid))
                    System.out.println("updated Book success");
                else
                    System.out.println("Member Not Found");

                return true;
            case 5: System.exit(200);
                return true;
            default:
                System.out.println("Invalid Action");

        }
        return false;

    }
}

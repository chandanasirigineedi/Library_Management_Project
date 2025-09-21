package Controller;

import DTO.BookStatus;
import Entity.Book;
import Entity.Borrower;
import Entity.Member;
import Service.Implementation.BookService;
import Service.Implementation.BookServiceImpl;
import Service.Implementation.MemberService;
import Service.Implementation.MemberServiceImpl;

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
    private Scanner scanner = new Scanner(System.in);
    public void runToDoApp(){
        while(true){
            showMenu();
            System.out.println(" \t\t\t\t\t\t\t\t**********Enter the Action Number************");
            String userAction = scanner.nextLine();
            performAction(Integer.parseInt(userAction));
        }
    }
    private void showMenu(){
        System.out.println("\t\t\t\t\t\t\t***********Welcome to the Library Managemet App!*************");
        System.out.println("1. Manage Book (CRUD)");
        System.out.println("2. Manage member (CRUD)");
        System.out.println("3. Manage Borrower (CRUD)");
        System.out.println("4. Exit");
    }
    public  String getUserInput(String inputMessage){
        System.out.println(inputMessage+":");
        return System.console().readLine();
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
                String userInput= scanner.nextLine();
                ManageMembers(Integer.parseInt(userInput));
            break;
            case 3:System.out.println("1.Register Borrower ");
                   System.out.println("2.View Borrowers");
                   System.out.println("3.Update Borrowers");
                   System.out.println("4.Delete Borrower");
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
            case 3:
                System.out.println("Update the book");
                System.out.print("Enter Book ID : ");
                Integer id= scanner.nextInt();
                System.out.print("Title :");
                String title=scanner.nextLine();
                System.out.print("Author :");
                String author=scanner.nextLine();
                System.out.println( bookService.updateBook(id,author,title));
                return true;
            case 4: System.out.print("Enter Book ID to delete: ");
                    Integer bid = scanner.nextInt();
                    List<Book> booklist=bookService.deleteBook(bid);
//                  Book ebook1 =listOfBooks.stream().filter(b->b.getBookId()==bid).findFirst().orElse(null); ;
                    if (booklist != null) {
                        System.out.println(" Book deleted successfully!");
                    } else {
                            System.out.println("Book not found.");
                    }
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
                System.out.print("memberID :");
                Integer sMemberId= Integer.parseInt(scanner.nextLine());
                String sName=getUserInput("Enter name");
                String sMemberType=getUserInput("Enter memberType");
                Integer sPhoneNumber= Integer.parseInt(getUserInput("Enter the phoneNumber"));
                Member  member= new Member(sMemberId,sName,sMemberType,sPhoneNumber);
                memberService.addMember(member);
                System.out.println("Member added successfully");
                return true;
            case 2: System.out.println("View the Member");
                for(Member emember:listOfMembers){
                    System.out.println(emember.getMemberId()+" , "+emember.getName()+" , "+emember.getMemberType()+" , "+emember.getPhoneNumber());
                }
                return true;
            case 3:
                System.out.println("Update the Member");
                System.out.print("Enter Member ID to update: ");
                Integer id= scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter new MemberType: ");
                String memberType = scanner.nextLine();
                System.out.print("Enter new PhoneNumber: ");
                Integer phoneNumber= Integer.parseInt(scanner.nextLine());
                if(memberService.updateMember(id,memberType,phoneNumber))
                {
                    System.out.println(" Member updated successfully!");
                } else {
                    System.out.println(" Member not found.");
                }
                return true;
            case 4: System.out.print("Enter Member ID to delete: ");
                Integer mid = scanner.nextInt();
                if (memberService.deleteMember(mid)) {
                  System.out.println(mid+" Member deleted successfully!");
                } else {
                    System.out.println("Member not found.");
                }
                return true;
            case 5: System.exit(200);
                return true;
            default:
                System.out.println("Invalid Action");

        }
        return false;

    }
    private boolean ManageBorrowers(int action){
        switch(action){
            case 1: System.out.println("Borrow the Book ");
                Integer sBookId= Integer.parseInt(getUserInput("Enter bookID"));
                Integer sMemberId=Integer.parseInt(getUserInput("Enter MemberId"));
                LocalDate borrowDate= LocalDate.now();
                LocalDate dueDate = borrowDate.plusDays(14);
                String status=getUserInput("Enter Status");
                Borrower  borrower= new Borrower(sBookId,sMemberId,borrowDate,dueDate,null,status,0);
                listOfBorrower.add(borrower);
                System.out.println("Book Issued successfully");
                return true;
            case 2: System.out.println("View all Borrower");
                for(Borrower borrower1:listOfBorrower){
                    System.out.println(borrower1.getBookId()+","+borrower1.getMemberId()+" , "+
                            borrower1.getBorrowDate()+" , "+borrower1.getDueDate()+" , "+
                            borrower1.getReturnDate()+","+borrower1.getStatus()+","+borrower1.getFine());
                }
                return true;
            case 3:
                System.out.println("Return the book");
                System.out.print("Enter Member ID to update: ");
                Integer mid= scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Book ID to update: ");
                Integer bid= scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Book ISBN to update: ");
                Integer ISBN= scanner.nextInt();
                scanner.nextLine();
                Member emember=listOfMembers.stream().filter(b->b.getMemberId()==mid).findFirst().orElse(null);
                Book ebook=listOfBooks.stream().filter(b->b.getBookId()==bid &&b.getISBN()==ISBN).findFirst().orElse(null);
                Borrower eborrower=listOfBorrower.stream().filter(b->b.getBookId()==ebook.getBookId() ).findFirst().orElse(null);
                if(eborrower!=null)
                {
                    LocalDate edueDate = eborrower.getDueDate();
                    LocalDate returnDate = LocalDate.now();
                    if(edueDate.isAfter(returnDate)||edueDate.isEqual(returnDate)){
                            eborrower.setReturnDate(returnDate);
                            eborrower.setStatus("Returned");
                    }
                    if (edueDate.isBefore(returnDate)) {
                        eborrower.setReturnDate(returnDate);
                        eborrower.setFine((Period.between(edueDate, returnDate).getDays())*30);
                        eborrower.setStatus("returned");

                    }
                    System.out.println(" Book returned successfully!");
                } else {
                    System.out.println(" Member not found.");
                }
                return true;
            case 5: System.exit(200);
                return true;
            default:
                System.out.println("Invalid Action");

        }
        return false;

    }
}

package Controller;

import Entity.Book;
import Entity.Borrower;
import Entity.Member;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoController {
    List<Book> listOfBooks = new ArrayList<>();
    List<Member> listOfMembers=new ArrayList<>();
    List<Borrower> listOfBorrower= new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void runToDoApp(){
        while(true){
            showMenu();
            String userAction=getUserInput("ENter the Action Number");
            performAction(Integer.parseInt(userAction));
        }
    }
    private void showMenu(){
        System.out.println("Welcome to the Library Managemet App!");
        System.out.println("Action Menu: ");
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
                ManageBooks(Integer.parseInt(getUserInput("Enter the Action Number")));
            break;
            case 2:System.out.println("Action Menu");
                System.out.println("1.Register Member ");
                System.out.println("2.View Members");
                System.out.println("3.Update Members");
                System.out.println("4.Delete Member");
                ManageMembers(Integer.parseInt(getUserInput("Enter the Action Number")));
            break;
            case 3:System.out.println("1.Register Borrower ");
                   System.out.println("2.View Borrowers");
                   System.out.println("3.Update Borrowers");
                   System.out.println("4.Delete Borrower");
                   ManageBorrowers(Integer.parseInt(getUserInput("Enter the Action Number")));
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
                Long sBookId= Long.parseLong(getUserInput("Enter BookID"));
                String sTitle=getUserInput("Enter Title");
                String sAuthor=getUserInput("Enter Author");
                String sISBN= getUserInput("Enter the ISBN");
                Integer copies=Integer.parseInt(getUserInput("Enter the no of Copies"));
                Boolean isIssued=false;
                Book book= new Book(sBookId,sISBN,sAuthor,sTitle,isIssued,copies);
                listOfBooks.add(book);
                System.out.println("Book added successfully");
                return true;
            case 2: System.out.println("View the Book");
                    for(Book ebook:listOfBooks){
                     System.out.println(ebook.getBookId()+" , "+ebook.getISBN()+" , "+ebook.getTitle()+" , "+ebook.getAuthor()+" , "+ebook.isIssued()+" , "+ebook.getCopies());
                    }
                return true;
            case 3:
                System.out.println("Update the book");
                System.out.print("Enter Book ID to update: ");
                long id= scanner.nextLong();
                scanner.nextLine();
                Book ebook=listOfBooks.stream().filter(b->b.getBookId()==id).findFirst().orElse(null);
                if(ebook!=null)
                {
                    System.out.print("Enter new title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String author = scanner.nextLine();
                    ebook.setTitle(title);
                    ebook.setAuthor(author);

                System.out.println(" Book updated successfully!");
                } else {
                         System.out.println(" Book not found.");
                       }
                return true;
            case 4: System.out.print("Enter Book ID to delete: ");
                    long bid = scanner.nextLong();
                    Book ebook1 =listOfBooks.stream().filter(b->b.getBookId()==bid).findFirst().orElse(null); ;
                    if (ebook1 != null) {
                        listOfBooks.remove(ebook1);
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
                Long sMemberId= Long.parseLong(getUserInput("Enter memberID"));
                String sName=getUserInput("Enter name");
                String sMemberType=getUserInput("Enter memberType");
                Long sPhoneNumber= Long.parseLong(getUserInput("Enter the phoneNumber"));
                Member  member= new Member(sMemberId,sName,sMemberType,sPhoneNumber);
                //memberService.add(member);
                listOfMembers.add(member);
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
                long id= scanner.nextLong();
                scanner.nextLine();
                Member emember=listOfMembers.stream().filter(b->b.getMemberId()==id).findFirst().orElse(null);
                if(emember!=null)
                {
                    System.out.print("Enter new MemberType: ");
                    String memberType = scanner.nextLine();
                    System.out.print("Enter new PhoneNumber: ");
                    Long phoneNumber= Long.parseLong(scanner.nextLine());
                    emember.setMemberType(memberType);;
                    emember.setPhoneNumber(phoneNumber);

                    System.out.println(" Member updated successfully!");
                } else {
                    System.out.println(" Member not found.");
                }
                return true;
            case 4: System.out.print("Enter Member ID to delete: ");
                long mid = scanner.nextLong();
                Member emember1 =listOfMembers.stream().filter(b->b.getMemberId()==mid).findFirst().orElse(null); ;
                if (emember1 != null) {
                    listOfBooks.remove(emember1);
                    System.out.println(" Member deleted successfully!");
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
                Long sBookId= Long.parseLong(getUserInput("Enter bookID"));
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
                long mid= scanner.nextLong();
                scanner.nextLine();
                System.out.print("Enter Book ID to update: ");
                long bid= scanner.nextLong();
                scanner.nextLine();
                System.out.print("Enter Book ISBN to update: ");
                long ISBN= scanner.nextLong();
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

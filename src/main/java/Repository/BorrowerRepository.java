package Repository;

import Entity.Borrower;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class BorrowerRepository  {
    List<Borrower> listOfBorrower= new ArrayList<>();
    public boolean addBorrower(Borrower borrower){
        listOfBorrower.add(borrower);
        return true;
    }
    public boolean updateBorrower(String bookStatus,Integer bookID,Integer memberId){
        Borrower eborrower=listOfBorrower.stream().filter(b->b.getBookId()==bookID &&b.getMemberId()==memberId)
                .findFirst().orElse(null);

        if(eborrower!=null)
        {
            LocalDate edueDate = eborrower.getDueDate();
            LocalDate returnDate = LocalDate.now();
           if(bookStatus.equalsIgnoreCase("return")) {

               if (edueDate.isAfter(returnDate) || edueDate.isEqual(returnDate)) {
                   eborrower.setReturnDate(returnDate);
                   eborrower.setStatus("Returned");
               }
               if (edueDate.isBefore(returnDate)) {
                   eborrower.setReturnDate(returnDate);
                   eborrower.setFine((Period.between(edueDate, returnDate).getDays()) * 30);
                   eborrower.setStatus("returned");

               }
               System.out.println(" Book returned successfully!");
           }else if(bookStatus.equalsIgnoreCase("Renewal"))
           {
               LocalDate borrowDate= LocalDate.now();
               LocalDate dueDate = borrowDate.plusDays(14);
               eborrower.setDueDate(dueDate);
               eborrower.setStatus("Renewed");
               System.out.println(" Book Renewed successfully!");
           }else if(bookStatus.equalsIgnoreCase("Lost")){
               eborrower.setReturnDate(returnDate);
               eborrower.setFine((Period.between(edueDate, returnDate).getDays()) * 30+ 700) ;
               eborrower.setStatus("Lost");
           }

        }
        else {
            System.out.println(" Member not found.");
            return false;
        }
        return true;

    }
    public List<Borrower> viewAllBorrower(){
//        for(Borrower borrower1:listOfBorrower){
//            System.out.println(borrower1.getBookId()+","+borrower1.getMemberId()+" , "+
//                    borrower1.getBorrowDate()+" , "+borrower1.getDueDate()+" , "+
//                    borrower1.getReturnDate()+","+borrower1.getStatus()+","+borrower1.getFine());
//        }
        return listOfBorrower;
    }

}

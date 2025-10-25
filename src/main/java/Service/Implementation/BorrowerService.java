package Service.Implementation;

import Entity.Book;
import Entity.Borrower;

import java.util.List;

public interface BorrowerService {
    public boolean addBorrower(Borrower borrower);
    public boolean updateBorrower(String bookStatus,Integer bookID,Integer memberId);
    public List<Borrower> viewAllBorrower();

}

package Service.Implementation;

import Entity.Borrower;
import Repository.BorrowerRepository;

import java.util.List;

public class BorrowerServiceImpl implements BorrowerService{

    BorrowerRepository borrowerRepository;

    public BorrowerServiceImpl() {
        this.borrowerRepository = new BorrowerRepository();
    }

    @Override
    public boolean addBorrower(Borrower borrower) {
        borrowerRepository.addBorrower(borrower);
        return true;
    }

    @Override
    public boolean updateBorrower(String bookStatus,Integer bookID,Integer memberId) {
        borrowerRepository.updateBorrower(bookStatus,bookID,memberId);
        return true;
    }

    @Override
    public List<Borrower> viewAllBorrower() {

        return borrowerRepository.viewAllBorrower();
    }


}

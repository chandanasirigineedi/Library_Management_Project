package Entity;

import java.time.LocalDate;

public class Borrower {

    private Long bookId;
    private Integer memberId;
    private LocalDate borrowDate; //When the borrower checked it out
    private LocalDate dueDate; //The date by which the item should have been returned
    private LocalDate returnDate; //When the borrower actually returned the item
    private String status; //Returned, Overdue, Lost, or Renewed
    private Integer fine; //Penalties for late returns or lost items

    public Borrower(Long bookId, Integer memberId, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, String status, Integer fine) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
        this.fine = fine;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }
}

package Entity;

public class Book {
    private Long bookId;
    private String title;
    private Integer ISBN;
    private String author;
    private boolean isIssued;
    private Integer copies;

    public Book(Long sBookId, String sISBN, String sAuthor, String sTitle, Boolean isIssued, Integer copies) {
    }

    public Book(Long sMemberId, String sName, String sMemberType, String sPhoneNumber) {
    }

    Book(Long sBookId,Integer sISBN,String sAuthor,String sTitle,boolean isIssued,Integer copies){
        this.bookId=sBookId;
        this.ISBN=sISBN;
        this.author=sAuthor;
        this.title=sTitle;
        this.isIssued=isIssued;
        this.copies=copies;
    }


    public Long getBookId(){
        return this.bookId;
    }
    public void setBookId(Long bookId){
        this.bookId=bookId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }




}

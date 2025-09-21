package Entity;

public class Book {
    private Integer bookId;
    private String title;
    private Integer ISBN;
    private String author;
    private boolean isIssued;
    private Integer copies;


    public Book(Integer sBookId,Integer sISBN,String sAuthor,String sTitle,boolean isIssued,Integer copies){
        this.bookId=sBookId;
        this.ISBN=sISBN;
        this.author=sAuthor;
        this.title=sTitle;
        this.isIssued=isIssued;
        this.copies=copies;
    }
    public Integer getBookId(){
        return this.bookId;
    }
    public void setBookId(Integer bookId){
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

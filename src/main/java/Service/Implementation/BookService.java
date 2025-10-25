package Service.Implementation;

import Entity.Book;

import java.util.List;

public interface BookService {
    public Integer addBook(Book book);
    public String updateBook(Integer bookId,String author,String title  );
    public List<Book> deleteBook(Integer bookId);
    public List<Book> getBook();
    public Integer getBookId(Integer bookId,Integer ISBN );


}

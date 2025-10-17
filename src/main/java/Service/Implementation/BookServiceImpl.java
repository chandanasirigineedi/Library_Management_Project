package Service.Implementation;

import Entity.Book;
import Repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository;

    public BookServiceImpl() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public Integer addBook(Book book) {
            return bookRepository.addBook(book);

    }

    @Override
    public String updateBook(Integer bookId, String author,String title ) {
        return bookRepository.updateBook(bookId,author,title);

    }

    @Override
    public List<Book> deleteBook(Integer bookId) {
        return bookRepository.deleteBook(bookId);
    }

    @Override
    public List<Book> getBook() {
       return bookRepository.get();
      //  return null;
    }
    //add, update,delete,get

}

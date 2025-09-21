package Repository;


import Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
        List<Book>  bookDB= new ArrayList<>();


        public Integer addBook(Book book){
          //  bookDB.add(new Book(578,1234,"warts","chemistry",false,5));
            bookDB.add(book);
            return book.getBookId();
        }
        public  String updateBook(Integer bookId,String title,String author){
            Book ebook=  bookDB.stream().filter(b->b.getBookId()==bookId).findFirst().orElse(null);
            if(ebook!=null){
                ebook.setTitle(title);
                ebook.setAuthor(author);
                return new String(ebook.getBookId()+" Book updated successfully!");
            }
            else {
                  return new String(ebook.getBookId()+" Book not found.");
                 }
        }
        public List<Book> deleteBook(Integer bookId){
            Book ebook1 =bookDB.stream().filter(b->b.getBookId()==bookId).findFirst().orElse(null);
            if (ebook1 != null) {
                bookDB.remove(ebook1);
                return bookDB;
            } else{
                return null;
            }

        }
        public List<Book> get(){
            bookDB.add(new Book(578,1234,"warts","chemistry",false,5));
            System.out.println(bookDB.get(0).getBookId());
            return bookDB;
        }



}

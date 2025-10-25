package Repository;


import Entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
        List<Book>  bookDB= new ArrayList<>();


        public Integer addBook(Book book){
          //  bookDB.add(new Book(578,1234,"warts","chemistry",false,5));
            bookDB.add(new Book(10,01,"Edburg","physics",false,3));
            bookDB.add(new Book(11,111,"meyer","Mathametics",false,3));
            bookDB.add(book);
            return book.getBookId();
        }
        public  String updateBook(Integer bookId,String title,String author){
           bookDB.add(new Book(16,61,"ytru","Science",false,7));
            bookDB.add(new Book(17,71,"rfgh","Biology",false,7));
            Book ebook=  bookDB.stream().filter(b->b.getBookId()==bookId).findFirst().orElse(null);
            if(ebook!=null){
                System.out.println("bookId = " + ebook.getBookId()+ ", title = " + ebook.getTitle()+ ", author = " +ebook.getAuthor());
                ebook.setTitle(title);
                ebook.setAuthor(author);
                System.out.println("bookId = " + ebook.getBookId()+ ", title = " + ebook.getTitle()+ ", author = " +ebook.getAuthor());
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
            bookDB.add(new Book(12,21,"warts","chemistry",false,5));
            bookDB.add(new Book(13,31,"Edburg","physics",false,3));
            bookDB.add(new Book(14,41,"meyer","Mathametics",false,3));
            System.out.println(bookDB.get(0).getBookId());
            return bookDB;
        }
        public Integer getBookId(Integer bookId,Integer ISBN ){
            Book ebook=bookDB.stream().filter(b->b.getBookId()==bookId ).findFirst().orElse(null);
            return ebook.getBookId();
        }


}

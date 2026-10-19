package zafarjon.uz.servise;

import org.postgresql.util.OSUtil;
import zafarjon.uz.Contaner.CompanentContaner;
import zafarjon.uz.dto.Book;
import zafarjon.uz.dto.Category;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class BookServes {
    public void add(Book book){
    //chek
    if (!isValid(book)){
        System.out.println("Title, author or availableDay are error!");
    }
    //category
    Category category= CompanentContaner.categoryRepository.getById(book.getCategory_id());
    if (category==null){
        System.out.println("Category is not");
    }
    book.setCreatedDate(LocalDateTime.now());
    book.setVisible(true);
    int effectedRow= CompanentContaner.bookRepository.save(book);
    if (effectedRow==1){
        System.out.println("Book is created!");
    }else {
        System.out.println("Book is not created!");
    }
    }
    public boolean isValid(Book book){
        if (book.getTitle()==null || book.getTitle().isBlank() || book.getTitle().length()<3){
            return false;
        }
        if (book.getAuthor()==null || book.getAuthor().isBlank() || book.getAuthor().length()<3){
            return false;
        }
        if (book.getAvailableDay()==null || book.getAvailableDay()<=0){
            return false;
        }
        return true;
    }
    public void list(){
        List<Book> bookList= CompanentContaner.bookRepository.getBooks();
        for (Book book:bookList){
            System.out.println(book.getId()+" - "+book.getTitle()+", "+book.getAuthor()+", ("+book.getCategory().getName()+")");
        }
    }
}

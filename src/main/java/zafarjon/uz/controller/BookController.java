package zafarjon.uz.controller;

import zafarjon.uz.Contaner.CompanentContaner;
import zafarjon.uz.dto.Book;

import java.time.LocalDate;

public class BookController {
    public void start(){
        boolean loop=true;
        while (loop){
            showMenu();
            int action=getAction();
            switch (action){
                case 1:
                    list();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    add();
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                case 6:
                    //
                    break;
                case 7:
                    //
                    break;
                case 0:
                    loop=false;
                    break;
                default:
                    System.out.println("Error");
            }
        }
    }
    public void showMenu(){
        System.out.println("****** Book ******");
        System.out.println("1- Book list");
        System.out.println("2- Search");
        System.out.println("3- Add book");
        System.out.println("4- Remove book");
        System.out.println("5- Books on hand");
        System.out.println("6- Book history");
        System.out.println("7- Best books");
        System.out.println("0- Exit");
    }
    public int getAction(){
        System.out.print("Enter Action:");
        return CompanentContaner.scannerNumber.nextInt();
    }
    public void add(){
        System.out.print("Enter title:");
        String title =CompanentContaner.scannerText.next();

        System.out.print("Enter author:");
        String author=CompanentContaner.scannerText.next();

        System.out.print("Enter category:");
        Integer category_id=CompanentContaner.scannerNumber.nextInt();

        System.out.print("Enter available day:");
        Integer available_day=CompanentContaner.scannerNumber.nextInt();

        System.out.print("Enter book publishDate (yyyy-MM-dd):");
        String publish_date =CompanentContaner.scannerText.next();

        Book book=new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory_id(category_id);
        book.setAvailableDay(available_day);
        book.setPublishDate(LocalDate.parse(publish_date));

        CompanentContaner.bookServes.add(book);
    }
    public void list(){
        CompanentContaner.bookServes.list();
    }
    public void Search(){
        System.out.print("Enter query:");
        String query=CompanentContaner.scannerText.next();
        CompanentContaner.bookServes.search(query);
    }
}

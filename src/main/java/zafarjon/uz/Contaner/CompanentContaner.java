package zafarjon.uz.Contaner;

import zafarjon.uz.controller.*;
import zafarjon.uz.repository.BookRepository;
import zafarjon.uz.repository.CategoryRepository;
import zafarjon.uz.repository.ProfileRepository;
import zafarjon.uz.servise.AuthServes;
import zafarjon.uz.servise.BookServes;
import zafarjon.uz.servise.CategoryServes;
import zafarjon.uz.servise.ProfileServes;
import zafarjon.uz.util.ProfileValidUtil;

import java.util.Scanner;

public class CompanentContaner {
    public static Scanner scannerNumber=new Scanner(System.in);
    public static Scanner scannerText =new Scanner(System.in);
    //Controller
    public static AdminController adminController=new AdminController();
    public static StaffController staffController=new StaffController();
    public static StudentController studentController=new StudentController();
    public static CatigoriyController catigoriyController=new CatigoriyController();
    public static BookController bookController=new BookController();
    public static ProfileController profileController=new ProfileController();
    //Repository
    public static ProfileRepository profileRepository=new ProfileRepository();
    public static CategoryRepository categoryRepository=new CategoryRepository();
    public static BookRepository bookRepository=new BookRepository();
    //Serves
    public static CategoryServes categoryServes=new CategoryServes();
    public static AuthServes authServes=new AuthServes();
    public static BookServes bookServes=new BookServes();
    public static ProfileServes profileServes=new ProfileServes();
}

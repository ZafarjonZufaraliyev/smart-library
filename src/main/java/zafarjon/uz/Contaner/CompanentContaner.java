package zafarjon.uz.Contaner;

import zafarjon.uz.controller.AdminController;
import zafarjon.uz.controller.CatigoriyController;
import zafarjon.uz.controller.StaffController;
import zafarjon.uz.controller.StudentController;
import zafarjon.uz.repository.CategoryRepository;
import zafarjon.uz.repository.ProfileRepository;
import zafarjon.uz.servise.AuthServes;
import zafarjon.uz.servise.CategoryServes;

import java.util.Scanner;

public class CompanentContaner {
    public static Scanner scannerNumber=new Scanner(System.in);
    public static Scanner scannerText =new Scanner(System.in);
    public static AdminController adminController=new AdminController();
    public static StaffController staffController=new StaffController();
    public static StudentController studentController=new StudentController();
    public static CatigoriyController catigoriyController=new CatigoriyController();
    public static ProfileRepository profileRepository=new ProfileRepository();
    public  static CategoryRepository categoryRepository=new CategoryRepository();
    public static CategoryServes categoryServes=new CategoryServes();
    public static AuthServes authServes=new AuthServes();
}

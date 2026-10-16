package zafarjon.uz.Contaner;

import zafarjon.uz.repository.ProfileRepository;
import zafarjon.uz.servise.AuthServes;

import java.util.Scanner;

public class CompanentContaner {
    public static Scanner scannerNumber=new Scanner(System.in);
    public static Scanner scannerText =new Scanner(System.in);
    public static ProfileRepository profileRepository=new ProfileRepository();
    public static AuthServes authServes=new AuthServes();
}

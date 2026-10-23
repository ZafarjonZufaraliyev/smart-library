package zafarjon.uz.controller;

import zafarjon.uz.Contaner.CompanentContaner;
import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.dto.Book;
import zafarjon.uz.dto.Profile;

import java.time.LocalDate;

public class ProfileController {
    public void start(){
        boolean loop=true;
        while (loop){
            showMenu();
            int action=getAction();
            switch (action){
                case 1:
                    //
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    //
                    break;
                case 4:
                    addProfile();;
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
        System.out.println("****** Profile ******");
        System.out.println("1- Profile list");
        System.out.println("2- Search profile");
        System.out.println("3- Change profile status");
        System.out.println("4- Profile add");
        System.out.println("0- Exit");
    }
    public int getAction(){
        System.out.print("Enter Action:");
        return CompanentContaner.scannerNumber.nextInt();
    }
    public void addProfile(){
        System.out.print("Enter name:");
        String name =CompanentContaner.scannerText.next();

        System.out.print("Enter surname:");
        String surname=CompanentContaner.scannerText.next();

        System.out.print("Enter login:");
        String login=CompanentContaner.scannerText.next();

        System.out.print("Enter password:");
        String password=CompanentContaner.scannerText.next();

        System.out.print("Enter phone:");
        String phone=CompanentContaner.scannerText.next();

        System.out.print("Enter role (STAFF OR ADMIN):");
        String role=CompanentContaner.scannerText.next();
        ProfileRole profileRole;

        Profile profile=new Profile();
        profile.setName(name);
        profile.setSurname(surname);
        profile.setLogin(login);
        profile.setPassword(password);
        profile.setPhone(phone);
        profile.setRole(ProfileRole.valueOf(role));

        CompanentContaner.profileServes.addProfile(profile);
    }

    public void search(){
        System.out.print("Enter query:");
        String query= CompanentContaner.scannerText.next();
        CompanentContaner.profileServes.search(query);
    }
}

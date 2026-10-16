package zafarjon.uz.controller;

import zafarjon.uz.servise.AuthServes;
import zafarjon.uz.dto.Profile;
import zafarjon.uz.repository.TableRepostory;
import zafarjon.uz.servise.initServise;

import java.util.Scanner;

public class MainController {
    public void start(){
        TableRepostory tableRepostory=new TableRepostory();
        initServise initServise=new initServise();
        tableRepostory.createTable();
        initServise.initAdmin();
        initServise.initStudent();
        initServise.initStaff();
        boolean loop=true;
        while (loop){
            showMenu();
            int action=getAction();
            switch (action){
                case 1:
                    //
                break;
                case 2:
                    //
                break;
                case 3:
                    //
                break;
                case 4:
                    login();
                break;
                case 5:
                    registration();
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
        System.out.println("******Menu******");
        System.out.println("1- BookList");
        System.out.println("2- Search");
        System.out.println("3- By category");
        System.out.println("4- Login");
        System.out.println("5- Registration");
        System.out.println("0- Exit");
    }
    public int getAction(){
        System.out.print("Enter Action:");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }

    public void login(){
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter login:");
        String login=scanner.next();

        System.out.print("Enter password:");
        String password=scanner.next();

        AuthServes authServes=new AuthServes();
        authServes.login(login,password);
    }

    public void registration(){
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter name:");
        String name=scanner.next();

        System.out.print("Enter surname:");
        String surname=scanner.next();

        System.out.print("Enter phone:");
        String phone=scanner.next();

        System.out.print("Enter login:");
        String login=scanner.next();

        System.out.print("Enter password:");
        String password=scanner.next();

        Profile profile =new Profile();
        profile.setName(name.trim());
        profile.setSurname(surname.trim());
        profile.setPhone(phone.trim());
        profile.setLogin(login.trim());
        profile.setPassword(password.trim());

        AuthServes authServes=new AuthServes();
        authServes.registration(profile);
    }
}

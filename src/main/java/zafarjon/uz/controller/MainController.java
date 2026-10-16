package zafarjon.uz.controller;

import zafarjon.uz.Contaner.CompanentContaner;
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
        return CompanentContaner.scannerNumber.nextInt();
    }

    public void login(){
        System.out.print("Enter login:");
        String login=CompanentContaner.scannerText.next();;

        System.out.print("Enter password:");
        String password=CompanentContaner.scannerText.next();;

        CompanentContaner.authServes.login(login,password);
    }

    public void registration(){
        System.out.print("Enter name:");
        String name=CompanentContaner.scannerText.next();

        System.out.print("Enter surname:");
        String surname=CompanentContaner.scannerText.next();

        System.out.print("Enter phone:");
        String phone=CompanentContaner.scannerText.next();;

        System.out.print("Enter login:");
        String login=CompanentContaner.scannerText.next();

        System.out.print("Enter password:");
        String password=CompanentContaner.scannerText.next();

        Profile profile =new Profile();
        profile.setName(name.trim());
        profile.setSurname(surname.trim());
        profile.setPhone(phone.trim());
        profile.setLogin(login.trim());
        profile.setPassword(password.trim());

        CompanentContaner.authServes.registration(profile);
    }
}

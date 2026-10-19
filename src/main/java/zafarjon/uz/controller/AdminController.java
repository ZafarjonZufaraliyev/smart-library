package zafarjon.uz.controller;

import zafarjon.uz.Contaner.CompanentContaner;

import java.util.Scanner;

public class AdminController {
    public void start(){
        boolean loop=true;
        while (loop){
            showMenu();
            int action=getAction();
            switch (action){
                case 1:
                    CompanentContaner.bookController.start();
                    break;
                case 2:
                    CompanentContaner.catigoriyController.start();
                    break;
                case 3:
                    //
                    break;
                case 4:
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
    public int getAction(){
        System.out.print("Enter Action:");
        return CompanentContaner.scannerNumber.nextInt();
    }
    public void showMenu(){
        System.out.println("******Admin Menu******");
        System.out.println("1- Book");
        System.out.println("2- Category");
        System.out.println("3- Student");
        System.out.println("4- Profile");
        System.out.println("0- Exit");
    }
}

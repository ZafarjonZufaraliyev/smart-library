package zafarjon.uz.controller;

import zafarjon.uz.Contaner.CompanentContaner;

import java.util.Scanner;

public class StudentController {
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
                    //
                    break;
                case 3:
                    //
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
        System.out.println("******Student Menu******");
        System.out.println("1- BookList");
        System.out.println("2- Search");
        System.out.println("3- Take book");
        System.out.println("4- Return book");
        System.out.println("5- Books on hand");
        System.out.println("5- Take book history");
        System.out.println("0- Exit");
    }
}

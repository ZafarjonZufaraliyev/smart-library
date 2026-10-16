package zafarjon.uz.controller;

import java.util.Scanner;

public class StaffController {
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
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }
    public void showMenu(){
        System.out.println("******Staff Menu******");
        System.out.println("1- Book");
        System.out.println("2- Student");
        System.out.println("0- Exit");
    }
}

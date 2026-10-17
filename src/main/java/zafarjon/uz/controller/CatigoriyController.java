package zafarjon.uz.controller;

import zafarjon.uz.Contaner.CompanentContaner;
import zafarjon.uz.dto.Category;

public class CatigoriyController {
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
                    addCategory();
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
        System.out.println("****** Category ******");
        System.out.println("1- Category list");
        System.out.println("2- Delete category");
        System.out.println("3- Add category");
        System.out.println("0- Exit");
    }
    public void addCategory(){
        System.out.print("Enter name: ");
        String name=CompanentContaner.scannerText.next();

        Category category=new Category();
        category.setName(name);
        CompanentContaner.categoryServes.created(category);
    }
}

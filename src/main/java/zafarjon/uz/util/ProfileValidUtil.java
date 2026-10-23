package zafarjon.uz.util;

import zafarjon.uz.dto.Profile;

public class ProfileValidUtil {
    public static boolean isValid(Profile profile){
        //name chek
        if(profile.getName()==null || profile.getName().isBlank() || profile.getName().length()<2){
            System.out.println("Name is error!");
            return false;
        }
        //surname chek
        if(profile.getSurname()==null || profile.getSurname().isBlank() || profile.getSurname().length()<2){
            System.out.println("Surname is error!");
            return false;
        }
        //login chek
        if(profile.getLogin()==null || profile.getLogin().isBlank() || profile.getLogin().length()<3){
            System.out.println("Login is error!");
            return false;
        }

        //998 90 163 00 21
        if(profile.getPhone()==null
                || profile.getPhone().isBlank()
                || profile.getPhone().length()!=12
                || !profile.getPhone().startsWith("998")
                || !isValidPhone(profile.getPhone())){
            System.out.println("Phone is error!");
            return false;
        }

        return true;
    }

    public static boolean isValidPhone(String input){
        char[] arr=input.toCharArray();
        for (char s:arr){
            if (!Character.isDigit(s)){
                return false;
            }
        }
        return true;
    }
}

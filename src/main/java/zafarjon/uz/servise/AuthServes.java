package zafarjon.uz.servise;

import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.Enums.ProfileStatus;
import zafarjon.uz.dto.Profile;
import zafarjon.uz.repository.ProfileRepository;
import zafarjon.uz.controller.AdminController;
import zafarjon.uz.controller.StaffController;
import zafarjon.uz.controller.StudentController;
import zafarjon.uz.util.MD5util;

import java.time.LocalDateTime;

public class AuthServes {

    public void login(String login,String password){
        ProfileRepository profileRepository=new ProfileRepository();
        Profile profile= profileRepository.getLogin(login);

        if(profile==null){
            System.out.println("Login or password wrong!");
            return;
        }
        String hashMD5= MD5util.encode(password);
        if(!profile.getPassword().equals(hashMD5)){
            System.out.println("Login or password wrong!");
            return;
        }
        if (!profile.getStatus().equals(ProfileStatus.ACTIVE)){
            System.out.println("Not ACTIVE mazgi!");
            return;
        }
        if (profile.getRole().equals(ProfileRole.STUDENT)){
            StudentController studentController=new StudentController();
            studentController.start();
        }else if (profile.getRole().equals(ProfileRole.ADMIN)){
            AdminController adminController=new AdminController();
            adminController.start();
        }else if(profile.getRole().equals(ProfileRole.STAFF)){
            StaffController staffController=new StaffController();
            staffController.start();
        }
    }

    public void registration(Profile profile){
        //chek
        if (!isValid(profile)){
            return;
        }

        //chek login
        ProfileRepository profileRepository=new ProfileRepository();
        Profile existProfile= profileRepository.getLogin(profile.getLogin());
        if(existProfile!=null){
            System.out.println("Login exists. Please choose other login.");
            return;
        }
        //save
        profile.setCreatedDate(LocalDateTime.now());
        profile.setRole(ProfileRole.STUDENT);
        profile.setStatus(ProfileStatus.ACTIVE);
        profile.setPassword(MD5util.encode(profile.getPassword()));

        int effectedRow= profileRepository.create(profile);
        if (effectedRow==1){
            System.out.println("Registration completed!");
        }
    }

    public boolean isValid(Profile profile){
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

    public boolean isValidPhone(String input){
        char[] arr=input.toCharArray();
        for (char s:arr){
            if (!Character.isDigit(s)){
                return false;
            }
        }
        return true;
    }
}

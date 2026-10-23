package zafarjon.uz.servise;

import zafarjon.uz.Contaner.CompanentContaner;
import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.Enums.ProfileStatus;
import zafarjon.uz.dto.Profile;
import zafarjon.uz.repository.ProfileRepository;
import zafarjon.uz.controller.AdminController;
import zafarjon.uz.controller.StaffController;
import zafarjon.uz.controller.StudentController;
import zafarjon.uz.util.MD5util;
import zafarjon.uz.util.ProfileValidUtil;

import java.time.LocalDateTime;

public class AuthServes {

    public void login(String login,String password){
        Profile profile= CompanentContaner.profileRepository.getLogin(login);
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
           CompanentContaner.studentController.start();
        }else if (profile.getRole().equals(ProfileRole.ADMIN)){
           CompanentContaner.adminController.start();
        }else if(profile.getRole().equals(ProfileRole.STAFF)){
            CompanentContaner.staffController.start();
        }
    }

    public void registration(Profile profile){
        //chek
        if (!ProfileValidUtil.isValid(profile)){
            return;
        }
        //chek login
        Profile existProfile= CompanentContaner.profileRepository.getLogin(profile.getLogin());
        if(existProfile!=null){
            System.out.println("Login exists. Please choose other login.");
            return;
        }
        //save
        profile.setCreatedDate(LocalDateTime.now());
        profile.setRole(ProfileRole.STUDENT);
        profile.setStatus(ProfileStatus.ACTIVE);
        profile.setPassword(MD5util.encode(profile.getPassword()));

        int effectedRow= CompanentContaner.profileRepository.create(profile);
        if (effectedRow==1){
            System.out.println("Registration completed!");
        }
    }

}

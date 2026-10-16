package zafarjon.uz;

import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.Enums.ProfileStatus;
import zafarjon.uz.util.MD5util;

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
        }
    }
}

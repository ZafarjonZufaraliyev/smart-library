package zafarjon.uz;

import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.Enums.ProfileStatus;
import zafarjon.uz.util.MD5util;

import java.time.LocalDateTime;

public class initServise {

    public void initAdmin(){
        String login="zafarjon";
        String input="12345";
        ProfileRepository profileRepository=new ProfileRepository();
        Profile profile= profileRepository.getLogin(login);
        if (profile==null){
            Profile admin=new Profile();
            admin.setName("Zafarjon");
            admin.setSurname("Zufaraliyev");
            admin.setPhone("998901630021");
            admin.setPassword(MD5util.encode(input));
            admin.setRole(ProfileRole.ADMIN);
            admin.setStatus(ProfileStatus.ACTIVE);
            admin.setCreatedDate(LocalDateTime.now());
            admin.setLogin(login);
            profileRepository.create(admin);
        }

    }
}

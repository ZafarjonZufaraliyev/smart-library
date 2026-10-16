package zafarjon.uz.servise;

import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.Enums.ProfileStatus;
import zafarjon.uz.dto.Profile;
import zafarjon.uz.repository.ProfileRepository;
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


    public void initStudent(){
        String login="ali";
        String input="12345";
        ProfileRepository profileRepository=new ProfileRepository();
        Profile profile= profileRepository.getLogin(login);
        if (profile==null){
            Profile student=new Profile();
            student.setName("Ali");
            student.setSurname("Valiyev");
            student.setPhone("998901630021");
            student.setPassword(MD5util.encode(input));
            student.setRole(ProfileRole.STUDENT);
            student.setStatus(ProfileStatus.ACTIVE);
            student.setCreatedDate(LocalDateTime.now());
            student.setLogin(login);
            profileRepository.create(student);
        }

    }

    public void initStaff(){
        String login="vali";
        String input="12345";
        ProfileRepository profileRepository=new ProfileRepository();
        Profile profile= profileRepository.getLogin(login);
        if (profile==null){
            Profile staff=new Profile();
            staff.setName("Vali");
            staff.setSurname("Aliyev");
            staff.setPhone("998901630021");
            staff.setPassword(MD5util.encode(input));
            staff.setRole(ProfileRole.STAFF);
            staff.setStatus(ProfileStatus.ACTIVE);
            staff.setCreatedDate(LocalDateTime.now());
            staff.setLogin(login);
            profileRepository.create(staff);
        }

    }
}

package zafarjon.uz.servise;

import zafarjon.uz.Contaner.CompanentContaner;
import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.Enums.ProfileStatus;
import zafarjon.uz.dto.Book;
import zafarjon.uz.dto.Profile;
import zafarjon.uz.util.MD5util;
import zafarjon.uz.util.ProfileValidUtil;

import java.time.LocalDateTime;
import java.util.List;

public class ProfileServes {
    public void addProfile(Profile profile){
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
        profile.setStatus(ProfileStatus.ACTIVE);
        profile.setPassword(MD5util.encode(profile.getPassword()));

        int effectedRow= CompanentContaner.profileRepository.create(profile);
        if (effectedRow==1){
            System.out.println("Registration completed!");
        }
    }
    public void search(String query){
        List<Profile> queryList= CompanentContaner.profileRepository.search(query);
        for (Profile profile:queryList){
            System.out.println(profile.getId()+" - "+profile.getName()+", "+profile.getSurname()+", "+profile.getLogin()+
                    ", "+profile.getStatus()+", "+profile.getCreatedDate());
        }
    }
}

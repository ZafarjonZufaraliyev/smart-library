package zafarjon.uz.servise;

import zafarjon.uz.Contaner.CompanentContaner;
import zafarjon.uz.dto.Category;

import java.time.LocalDateTime;
import java.util.List;

public class CategoryServes {

    public void created(Category category){
       if (!chek(category)){
           System.out.println("Category is wrong.");
           return;
       }
       Category exists= CompanentContaner.categoryRepository.getByName(category.getName());
       if (exists!=null){
           System.out.println("Category name exists");
           return;
       }
       category.setCreatedDate(LocalDateTime.now());
       category.setVisible(true);
       int effectedRow= CompanentContaner.categoryRepository.save(category);
       if (effectedRow!=0){
           System.out.println("Category is crated");
       }
    }

    public boolean chek(Category category){
        if (category.getName()==null || category.getName().isBlank() || category.getName().length()<3){
            return false;
        }
        return true;
    }
    public void list(){
        List<Category> categoryList= CompanentContaner.categoryRepository.getList();
        for (Category category:categoryList){
            System.out.println(category.getId()+" - "+category.getName()+" ("+category.getCreatedDate()+")");
        }
    }
}

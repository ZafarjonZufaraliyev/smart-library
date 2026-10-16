package zafarjon.uz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnactionRepository {
   public static Connection connectionDataBase(){
       Connection connection;
       {
           try {
           return connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/libray_store", "libray_people", "1234");
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
   }
}

package zafarjon.uz.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableRepostory {
   public void createTable(){
       String sql="create  table if not exists profile("+
               " id serial primary key,"+
               "name varchar(25) not null,"+
               "surname varchar(25) not null,"+
               "login varchar(25) not null unique,"+
               "password varchar(30) not null,"+
               "phone varchar(25) not null,"+
               "status varchar(25) not null,"+
               "role varchar(25) not null,"+
               "createdDate timestamp default now()"+
               ");";
       {
           try {
               Connection connection= ConnactionRepository.connectionDataBase();
               Statement statement = connection.createStatement();
               statement.executeUpdate(sql);
               connection.close();
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
       }
   }

}

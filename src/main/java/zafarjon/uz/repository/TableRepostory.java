package zafarjon.uz.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableRepostory {
   public void createTable(){
       String profile="create  table if not exists profile("+
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
       executeSQL(profile);
       String category="create  table if not exists category("+
               " id serial primary key,"+
               "name varchar(25) not null unique,"+
               "createdDate timestamp default now(),"+
               "visible boolean default true"+
               ");";
        executeSQL(category);
   }

   public  void executeSQL(String sql){
       Connection connection= ConnactionRepository.connectionDataBase();
       try {
           Statement statement = connection.createStatement();
           statement.executeUpdate(sql);
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           try {
               connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
}

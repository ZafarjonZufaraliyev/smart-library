package zafarjon.uz.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableRepostory {

    public void createTable() {
        String profile = "CREATE TABLE IF NOT EXISTS profile (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(25) NOT NULL, " +
                "surname VARCHAR(25) NOT NULL, " +
                "login VARCHAR(25) NOT NULL UNIQUE, " +
                "password VARCHAR(30) NOT NULL, " +
                "phone VARCHAR(25) NOT NULL, " +
                "status VARCHAR(25) NOT NULL, " +
                "role VARCHAR(25) NOT NULL, " +
                "createdDate TIMESTAMP DEFAULT NOW()" +
                ")";
        executeSQL(profile);

        String category = "CREATE TABLE IF NOT EXISTS category (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(25) NOT NULL UNIQUE, " +
                "visible BOOLEAN DEFAULT TRUE, " +
                "createdDate TIMESTAMP DEFAULT NOW()" +
                ")";
        executeSQL(category);

        String book = "CREATE TABLE IF NOT EXISTS book (" +
                "id SERIAL PRIMARY KEY, " +
                "title VARCHAR(100) NOT NULL, " +
                "author VARCHAR(100) NOT NULL, " +
                "category_id INT NOT NULL, " +
                "publishDate DATE, " +
                "availableDay INT, " +
                "visible BOOLEAN DEFAULT TRUE, " +
                "createdDate TIMESTAMP DEFAULT NOW(), " +
                "CONSTRAINT fk_category_id FOREIGN KEY (category_id) " +
                "REFERENCES category(id)" +
                ")";
        executeSQL(book);
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

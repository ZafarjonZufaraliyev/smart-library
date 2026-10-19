package zafarjon.uz.repository;

import zafarjon.uz.dto.Book;
import zafarjon.uz.dto.Category;

import java.sql.*;

public class BookRepository {
    public int save(Book book){
        Connection connection= ConnactionRepository.connectionDataBase();
        try {
            String sql="insert into book(title,author,category_id,publishDate,availableDay,visible,createdDate) values (?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setInt(3,book.getCategory_id());
            preparedStatement.setDate(4, Date.valueOf(book.getPublishDate()));
            preparedStatement.setInt(5,book.getAvailableDay());
            preparedStatement.setBoolean(6,book.getVisible());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(book.getCreatedDate()));


            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  0;
    }
}

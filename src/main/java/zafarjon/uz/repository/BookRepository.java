package zafarjon.uz.repository;

import zafarjon.uz.dto.Book;
import zafarjon.uz.dto.Category;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public List<Book> getBooks() {
        Connection connection = ConnactionRepository.connectionDataBase();
        List<Book> list = new LinkedList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    "SELECT b.*, c.name AS category_name\n" +
                            " FROM book AS b\n" +
                            " INNER JOIN category AS c ON c.id = b.category_id\n" +
                            " WHERE b.visible = TRUE\n" +
                            " ORDER BY b.id ASC;"
            );

            while (resultSet.next()) {
                Book book = new Book();

                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));

//                book.setCategory_id(resultSet.getInt("category_id"));
                book.setPublishDate(
                        resultSet.getDate("publishDate").toLocalDate()
                );
                book.setAvailableDay(resultSet.getInt("availableDay"));
                book.setVisible(resultSet.getBoolean("visible"));

                Timestamp timestamp = resultSet.getTimestamp("createdDate");
                if (timestamp != null) {
                    book.setCreatedDate(timestamp.toLocalDateTime());
                }
                Category category=new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("category_name"));
                book.setCategory(category);
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public List<Book> search(String query){
        Connection connection = ConnactionRepository.connectionDataBase();
        List<Book> list = new LinkedList<>();
        try {
            String sql="SELECT b.*, c.name AS category_name\n" +
                    " FROM book AS b\n" +
                    " INNER JOIN category AS c ON c.id = b.category_id\n" +
                    " WHERE lower(title) LIKE ? OR lower(author) LIKE ? AND b.visible = TRUE\n" +
                    " ORDER BY b.id ASC;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String title="%"+query.toLowerCase()+"%";
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,title);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();

                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
//                book.setCategory_id(resultSet.getInt("category_id"));
                book.setPublishDate(
                        resultSet.getDate("publishDate").toLocalDate()
                );
                book.setAvailableDay(resultSet.getInt("availableDay"));
                book.setVisible(resultSet.getBoolean("visible"));

                Timestamp timestamp = resultSet.getTimestamp("createdDate");
                if (timestamp != null) {
                    book.setCreatedDate(timestamp.toLocalDateTime());
                }
                Category category=new Category();
                category.setId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("category_name"));
                book.setCategory(category);
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public int remove(Integer removeId){
        Connection connection=ConnactionRepository.connectionDataBase();
        try {
            String sql="UPDATE book SET visible = false WHERE id = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,removeId);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("Kitobni ochrishda xatolik",e);
            }
        }
        return 0;
    }
}

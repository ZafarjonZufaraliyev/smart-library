package zafarjon.uz.repository;

import zafarjon.uz.dto.Category;

import java.sql.*;

public class CategoryRepository {

    public Category getByName(String name) {
        Connection connection = ConnactionRepository.connectionDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where name=?");
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setVisible(resultSet.getBoolean("visible"));
                category.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime());

                return category;
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
        return null;
    }

    public int save(Category category){
        Connection connection= ConnactionRepository.connectionDataBase();
        try {
            String sql="insert into category(name,createdDate,visible) values (?,?,?)";

            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(category.getCreatedDate()));
            preparedStatement.setBoolean(3,category.isVisible());

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

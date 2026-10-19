package zafarjon.uz.repository;

import zafarjon.uz.dto.Category;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public Category getById(Integer id) {
        Connection connection = ConnactionRepository.connectionDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id=?");
            preparedStatement.setInt(1, id);

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

    public List<Category> getList(){
        Connection connection=ConnactionRepository.connectionDataBase();
        List<Category> list=new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from category where visible=true");
            while (resultSet.next()){
                Category category=new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                category.setVisible(resultSet.getBoolean("visible"));
                category.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime());
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int deleteById(Integer id){
        Connection connection=ConnactionRepository.connectionDataBase();
        try {
            String sql = "UPDATE category SET visible = false WHERE id = ?";

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            return preparedStatement.executeUpdate();

        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }


}

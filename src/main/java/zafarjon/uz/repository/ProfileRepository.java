package zafarjon.uz.repository;

import zafarjon.uz.Enums.ProfileRole;
import zafarjon.uz.Enums.ProfileStatus;
import zafarjon.uz.dto.Book;
import zafarjon.uz.dto.Category;
import zafarjon.uz.dto.Profile;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProfileRepository {
    public Profile getLogin(String login){
        try {
            Connection connection= ConnactionRepository.connectionDataBase();
            PreparedStatement preparedStatement=connection.prepareStatement("select id, name, surname,login, password,phone,status,role,createdDate from profile where login=?");
            preparedStatement.setString(1,login);

            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                Profile profile=new Profile();
                profile.setId(resultSet.getInt("id"));
                profile.setName(resultSet.getString("name"));
                profile.setSurname(resultSet.getString("surname"));
                profile.setLogin(resultSet.getString("login"));
                profile.setPassword(resultSet.getString("password"));
                profile.setPhone(resultSet.getString("phone"));
                profile.setStatus(ProfileStatus.valueOf(resultSet.getString("status")));
                profile.setRole(ProfileRole.valueOf( resultSet.getString("role")));
                profile.setCreatedDate(resultSet.getTimestamp("createdDate").toLocalDateTime());

                return profile;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int create(Profile profile){
        Connection connection= ConnactionRepository.connectionDataBase();
        try {
            String sql="insert into profile(name,surname,login,password,phone,status,role) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,profile.getName());
            preparedStatement.setString(2,profile.getSurname());
            preparedStatement.setString(3,profile.getLogin());
            preparedStatement.setString(4,profile.getPassword());
            preparedStatement.setString(5,profile.getPhone());
            preparedStatement.setString(6, profile.getStatus().name());
            preparedStatement.setString(7, profile.getRole().name());

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

    public List<Profile> search(String query){
        Connection connection = ConnactionRepository.connectionDataBase();
        List<Profile> list = new LinkedList<>();
        try {
            String sql = "SELECT * FROM profile " +
                    "WHERE (LOWER(name) LIKE ? " +
                    "OR LOWER(surname) LIKE ? " +
                    "OR LOWER(login) LIKE ? " +
                    "OR LOWER(phone) LIKE ?) " +
                    "AND status = 'ACTIVE'";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String title="%"+query.toLowerCase()+"%";
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,title);
            preparedStatement.setString(4,title);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Profile profile = new Profile();
                profile.setId(resultSet.getInt("id"));
                profile.setName(resultSet.getString("name"));
                profile.setSurname(resultSet.getString("surname"));
                profile.setLogin(resultSet.getString("login"));
                profile.setPhone(resultSet.getString("phone"));
                profile.setStatus(ProfileStatus.valueOf(resultSet.getString("status")));
                profile.setRole(ProfileRole.valueOf(resultSet.getString("role")));
                list.add(profile);
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
}

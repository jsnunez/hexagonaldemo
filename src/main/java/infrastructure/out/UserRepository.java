package infrastructure.out;

import domain.entity.User;
import domain.service.UserService;
import infrastructure.config.DatabaseConfig;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements UserService {

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserById(int id) {
        String sql = "SELECT id, name, email FROM users WHERE id = ?";
        User user = null;
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public int DeleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        int rowsUpdate = 0;
    
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setInt(1, id);
            rowsUpdate = statement.executeUpdate();
    
            System.out.println("Número de filas eliminadas: " + rowsUpdate);
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowsUpdate;
    }

    @Override
    public void updatUserById(User user) {
        String sql = "UPDATE users SET name = ?,email=? WHERE id = ?";
      
        try (Connection connection = DatabaseConfig.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setInt(3, user.getId());

           int rowsUpdate = statement.executeUpdate();
       System.out.println("Numero de filas actualizadas  " + rowsUpdate);
    
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
   
}}
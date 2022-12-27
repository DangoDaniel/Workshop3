package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.Arrays;


public class UserDao {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO workshop3.users(username, email, password) VALUES (?, ?, ?)";

    private static final String UPDATE_USER_QUERY =
            "update workshop3.users set email = ?, username = ?, password = ? where id = ?;";

    private static final String SELECT_USER_BY_ID_QUERY =
            "select * from workshop3.users where id = ?;";

    private static final String DELETE_USER_BY_ID_QUERY =
            "delete from workshop3.users where id = ?;";

    private static final String SELLECT_ALL_USER_QUERY =
            "select * from workshop3.users;";


    public User create(User user) {
        String hashPassword = hashPassword(user.getPassword());
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement preparedStatement=
                    conn.prepareStatement(CREATE_USER_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, hashPassword);
            user.setPassword(hashPassword); //zwracam do obiektu zahaszowane haslo

            preparedStatement.executeUpdate();

            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User read(int userId) {
        User user = new User();

        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement getUserByIDStatement =
                    conn.prepareStatement(SELECT_USER_BY_ID_QUERY);
            getUserByIDStatement.setInt(1, userId);

            try (ResultSet result = getUserByIDStatement.executeQuery()) {
                result.next();
                user.setId(result.getInt("id"));
                user.setEmail(result.getString("email"));
                user.setUserName(result.getString("username"));
                user.setPassword(result.getString("password"));
                return user;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(User user) {
// "update workshop3.users set email = ?, username = ?, password = ? where id = ?;"
        String hashPassword = hashPassword(user.getPassword());
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement updateUserStatement =
                    conn.prepareStatement(UPDATE_USER_QUERY);
            updateUserStatement.setString(1, user.getEmail());
            updateUserStatement.setString(2, user.getUserName());
            updateUserStatement.setString(3, hashPassword);
            updateUserStatement.setInt(4, user.getId());
            updateUserStatement.executeUpdate();
            user.setPassword(hashPassword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int userId) {
//        private static final String DELETE_USER_BY_ID_QUERY =
//                "delete from workshop3.users where id = ?;";
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement deleteUserByIDStatement =
                    conn.prepareStatement(DELETE_USER_BY_ID_QUERY);
            deleteUserByIDStatement.setInt(1, userId);
            deleteUserByIDStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User[] findAll(){
//        private static final String SELLECT_ALL_USER_QUERY =
//                "select * from workshop3.users;";
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement selectAllUsersStatement =
                    conn.prepareStatement(SELLECT_ALL_USER_QUERY);
            selectAllUsersStatement.executeQuery();

//            User[] users = new User[0];
            User[] users = {};


            try(ResultSet resultSet = selectAllUsersStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setEmail(resultSet.getString("email"));
                    user.setUserName(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    users = addToArray(user, users);
                }
                return users;
            }catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1); // Tworzymy kopię tablicy powiększoną o 1.
        tmpUsers[tmpUsers.length-1] = u; // Dodajemy obiekt na ostatniej pozycji.
        return tmpUsers; //
    }
}

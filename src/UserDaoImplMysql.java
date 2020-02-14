import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImplMysql implements UserDao {
    String url = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7322453";
    String user = "sql7322453";
    String password = "VQYjPLA4yu";

    public UserDaoImplMysql(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public UserDaoImplMysql() {
    }

    public void createUserTable() {
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement s = con.createStatement()) {
            s.execute("CREATE TABLE users (" +
                    "    id int," +
                    "   userName varchar(30)" +
                    ");");

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void insertUser(int id, String name) {
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery("SELECT userName from users where id=" + id);
            if (!rs.next()) {
                s.execute("INSERT INTO users (id, userName)" +
                        "VALUES (" + id + ",'" + name + "');");
            } else {
                s.execute("UPDATE users SET userName ='" + name +
                        "' where id=" + id);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public User getUserById(int id) {
        String userName = "";
        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery("Select userName from users where id =" + id);
            if (rs.next()) {
                userName = rs.getString("userName");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new User(id, userName);
    }

}

public interface UserDao {
    User getUserById(int id);
    void createUserTable();
    void insertUser(int id, String name);
}

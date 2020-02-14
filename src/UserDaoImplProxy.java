import java.util.HashMap;

public class UserDaoImplProxy implements UserDao {
    private UserDao dao;
    private HashMap<Integer, User> userList = new HashMap<>();

    public UserDaoImplProxy(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public User getUserById(int id) {
        if (userList.containsKey(id)) {
            System.out.println("Returned from cash");
            return userList.get(id);
        } else {
            User user = dao.getUserById(id);
            userList.put(id, user);
            return user;
        }
    }

    @Override
    public void createUserTable() {
        dao.createUserTable();
    }

    @Override
    public void insertUser(int id, String name) {
        dao.insertUser(id, name);
    }

}

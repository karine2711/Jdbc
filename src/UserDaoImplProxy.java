import java.util.HashMap;

public class UserDaoImplProxy implements UserDaoProxy {
    private UserDaoProxy dao;
    private HashMap<Integer, User> userList=new HashMap<>();

    public UserDaoImplProxy(UserDaoProxy dao){
        this.dao=dao;
    }


    @Override
    public User getUserById(int id) {
        if(userList.containsKey(id)){
            return userList.get(id);
        } else {
            User user= dao.getUserById(id);
            userList.put(id,user);
            return user;
        }
    }
}

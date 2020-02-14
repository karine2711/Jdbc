public class Main {
    public static void main(String args[]) throws ClassNotFoundException {
        UserDaoFactory factory = new UserDaoFactory();
        UserDaoProxy mysql = factory.getUserDaoProxy("mysql");
        User user1 = mysql.getUserById(1);
        System.out.println(user1.getName());
    }
}

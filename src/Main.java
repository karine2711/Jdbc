public class Main {
    public static void main(String args[]) throws ClassNotFoundException {
        UserDaoFactory factory = new UserDaoFactory();
        UserDao mysql = factory.getUserDaoProxy("mysql");
        //  mysql.createUserTable();
        mysql.insertUser(4, "Elen");
        mysql.insertUser(5, "Ani");
        mysql.insertUser(6, "Vahag");
        User user1 = mysql.getUserById(5);
        User user2 = mysql.getUserById(5);
        System.out.println(user1.getName());
    }
}

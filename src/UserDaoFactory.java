public class UserDaoFactory {


    public UserDaoProxy getUserDaoProxy(String type){
        if(type.equalsIgnoreCase("mysql")){
            return new UserDaoImplProxy(new UserDaoImplMysql());
        }
        else if(type.equalsIgnoreCase("oracle")){
            System.out.println("Oracle dao is not implemented yet");
         return null;
        } else {
            System.out.println("Invalid dao type");
            return null;
        }
    }
}

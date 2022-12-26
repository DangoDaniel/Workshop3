package pl.coderslab;

public class MainDao {

    public static void create() {
        UserDao userDao = new UserDao();
        User user1 = new User();
        user1.setUserName("1arek");
        user1.setEmail("1arkadiusz.jozwiak@coderslab.pl");
        user1.setPassword("1pass");
        userDao.create(user1);

        User user2 = new User();
        user2.setUserName("2arek");
        user2.setEmail("2arkadiusz.jozwiak@coderslab.pl");
        user2.setPassword("2pass");
        userDao.create(user2);

        User user3 = new User();
        user3.setUserName("3arek");
        user3.setEmail("3arkadiusz.jozwiak@coderslab.pl");
        user3.setPassword("3pass");
        userDao.create(user3);

        User user4 = new User();
        user4.setUserName("4arek");
        user4.setEmail("4arkadiusz.jozwiak@coderslab.pl");
        user4.setPassword("4pass");
        userDao.create(user4);
    }

    public static void read(int id){
        UserDao userDao = new UserDao();
        User userRead = new User();
        userRead=userDao.read(id);
        System.out.println("id: " + userRead.getId()+
                " email: "+ userRead.getEmail()+
                " username: "+ userRead.getUserName()+
                " password: "+ userRead.getPassword());
    }

    public static void update(int id) {
        UserDao userDao = new UserDao();
        User userToUpdate = userDao.read(id);
        userToUpdate.setUserName("Arkadiusz");
        userToUpdate.setEmail("arek@coderslab.pl");
        userToUpdate.setPassword("superPassword");
        userDao.update(userToUpdate);
    }

    public static void delete (int id) {
        UserDao userDao = new UserDao();
        userDao.delete(id);
    }

    public static void findAll(){
        UserDao userDao = new UserDao();
        User[] all = userDao.findAll();
        for (User u : all) {
            System.out.println("id: " + u.getId()+
                    " email: "+ u.getEmail()+
                    " username: "+ u.getUserName()+
                    " password: "+ u.getPassword());
        }
    }
}

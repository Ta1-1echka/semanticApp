package hibernate.user;

import entity.User;

/**
 * Created by Tanya on 02.12.2016.
 */
public interface UserDao {

    User saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByLoginPassword(User user);

    boolean isExist(User user);
}
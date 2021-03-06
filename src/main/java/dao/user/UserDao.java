package dao.user;

import entity.User;

public interface UserDao {

    User saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByLoginPassword(User user);

    User getUserByLogin(String login);

    boolean isExist(User user);
}

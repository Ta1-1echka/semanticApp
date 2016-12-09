package service.user;

import dto.UserDTO;
import entity.User;

public interface UserDaoService {

    User saveUser(UserDTO userDTO);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByLoginPassword(User user);

    boolean isExist(User user);

    User getByLogin(String login);
}

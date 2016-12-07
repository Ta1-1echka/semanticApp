package service.user;

import dto.UserDTO;
import entity.User;

/**
 * Created by Tanya on 03.12.2016.
 */
public interface UserDaoService {

    User saveUser(UserDTO userDTO);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserById(int id);

    User getUserByLoginPassword(User user);

    boolean isExist(User user);

    User getByLogin(String login);
}

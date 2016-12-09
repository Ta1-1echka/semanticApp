package service.user.impl;

import converter.UserConverter;
import dao.user.UserDao;
import dto.UserDTO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import service.user.UserDaoService;

/**
 * Created by Tanya on 03.12.2016.
 */
@Service
public class UserDaoServiceImpl implements UserDaoService {

    @Autowired
    private Md5PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserConverter userConverter;

    @Override
    public User saveUser(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encodePassword(userDTO.getPassword(), null));
        User user = userConverter.converterDTOtoUser(userDTO);
        userDao.saveUser(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByLoginPassword(User user) {
        return userDao.getUserByLoginPassword(user);
    }

    @Override
    public boolean isExist(User user) {
        return userDao.isExist(user);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getUserByLogin(login);
    }
}

package dao.user.impl;

import entity.User;
import dao.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public User saveUser(User user) {
        hibernateTemplate.save(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }

    @Override
    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    @Override
    public User getUserById(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    @Override
    public User getUserByLoginPassword(User user) {
        String hql = "FROM  entity.User WHERE login = :login and password = :password";
        String params[] = new String[]{"login", "password"};
        String values[] = new String[]{user.getLogin(), user.getPassword()};
        return (User) hibernateTemplate.findByNamedParam(hql, params, values).get(0);
    }

    @Override
    public boolean isExist(User user) {
        String hql = "FROM  entity.User WHERE login = :login";
        String params[] = new String[]{"login"};
        String values[] = new String[]{user.getLogin()};
        return hibernateTemplate.findByNamedParam(hql, params, values).isEmpty() ? false : true;
    }


}

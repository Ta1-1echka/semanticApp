package dao.profile.impl;

import entity.Profile;
import dao.profile.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tanya on 03.12.2016.
 */
@Repository
@Transactional(readOnly = false)
public class ProfileDaoImpl implements ProfileDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Profile saveProfile(Profile profile) {
        hibernateTemplate.save(profile);
        return profile;
    }

    @Override
    public void deleteProfile(Profile profile) {
        hibernateTemplate.delete(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        hibernateTemplate.update(profile);
    }

    @Override
    public Profile getProfileById(int id) {
        return hibernateTemplate.get(Profile.class, id);
    }
}

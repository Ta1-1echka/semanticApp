package service.profile.impl;

import dao.profile.ProfileDao;
import entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.profile.ProfileDaoService;

/**
 * Created by Tanya on 07.12.2016.
 */
@Service
public class ProfileDaoServiceImpl implements ProfileDaoService {

    @Autowired
    private ProfileDao profileDao;

    @Override
    public Profile saveProfile(Profile profile) {
        return profileDao.saveProfile(profile);
    }

    @Override
    public void deleteProfile(Profile profile) {
        profileDao.deleteProfile(profile);
    }

    @Override
    public void updateProfile(Profile profile) {
        profileDao.updateProfile(profile);
    }

    @Override
    public Profile getProfileById(int id) {
        return profileDao.getProfileById(id);
    }
}

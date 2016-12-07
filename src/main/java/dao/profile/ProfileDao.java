package dao.profile;

import entity.Profile;

/**
 * Created by Tanya on 03.12.2016.
 */
public interface ProfileDao {
    Profile saveProfile(Profile profile);

    void deleteProfile(Profile profile);

    void updateProfile(Profile profile);

    Profile getProfileById(int id);



}

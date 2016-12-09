package dao.profile;

import entity.Profile;

public interface ProfileDao {
    Profile saveProfile(Profile profile);

    void deleteProfile(Profile profile);

    void updateProfile(Profile profile);

    Profile getProfileById(int id);



}

package service.profile;

import entity.Profile;

/**
 * Created by Tanya on 07.12.2016.
 */
public interface ProfileDaoService {
    Profile saveProfile(Profile profile);

    void deleteProfile(Profile profile);

    void updateProfile(Profile profile);

    Profile getProfileById(int id);
}

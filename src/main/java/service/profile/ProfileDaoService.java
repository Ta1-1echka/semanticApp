package service.profile;

import entity.Profile;

public interface ProfileDaoService {
    Profile saveProfile(Profile profile);

    void deleteProfile(Profile profile);

    void updateProfile(Profile profile);

    Profile getProfileById(int id);
}

package converter;

import dto.ProfileDTO;
import entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileConverter {
    public Profile converterDTOtoUser(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setIdUser(profileDTO.getIdUser());
        if (profileDTO.getFirstname() != null)
            profile.setFirstname(profileDTO.getFirstname());
        if (profileDTO.getLastname() != null)
            profile.setLastname(profileDTO.getLastname());
        if (profileDTO.getBirth() != null)
            profile.setBirth(profileDTO.getBirth());
        if (profileDTO.getEmail() != null)
            profile.setEmail(profileDTO.getEmail());
        if (profileDTO.getSex() != null)
            profile.setSex(profileDTO.getSex());
       return profile;
    }

    public ProfileDTO converterToDTO(Profile profile)
    {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setIdUser(profile.getIdUser());
        if (profile.getFirstname() != null)
            profileDTO.setFirstname(profile.getFirstname());
        if (profile.getLastname() != null)
            profileDTO.setLastname(profile.getLastname());
        if (profile.getBirth() != null)
            profileDTO.setBirth(profile.getBirth().toString());
        if (profile.getEmail() != null)
            profileDTO.setEmail(profile.getEmail());
        if (profile.getSex() != null)
            profile.setSex(profile.getSex());
        return profileDTO;
    }
}

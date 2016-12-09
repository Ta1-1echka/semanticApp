package converter;

import dto.UserDTO;
import entity.Profile;
import entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User converterDTOtoUser(UserDTO userDTO) {
        User user = new User();
        Profile profile = new Profile();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        if (userDTO.getFirstname() != null)
            profile.setFirstname(userDTO.getFirstname());
        if (userDTO.getLastname() != null)
            profile.setLastname(userDTO.getLastname());
        if (userDTO.getBirth() != null)
            profile.setBirth(userDTO.getBirth());
        if (userDTO.getEmail() != null)
            profile.setEmail(userDTO.getEmail());
        if (userDTO.getSex() != null)
            profile.setSex(userDTO.getSex());
        profile.setUser(user);
        user.setProfile(profile);
        return user;
    }
}

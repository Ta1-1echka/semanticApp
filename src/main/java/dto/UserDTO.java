package dto;

import org.springframework.core.convert.ConversionFailedException;

import java.sql.Date;

/**
 * Created by Tanya on 03.12.2016.
 */
public class UserDTO {
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private Date birth;
    private String email;
    private String sex;

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        try {
            this.birth = Date.valueOf(birth);
        } catch (IllegalArgumentException exception) {
            birth = null;
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

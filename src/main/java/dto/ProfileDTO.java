package dto;

import java.sql.Date;

public class ProfileDTO {
    private int idUser;
    private String firstname;
    private String lastname;
    private Date birth;
    private String email;
    private String sex;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

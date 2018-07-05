package com.belili.model;

public class Model_user {

    private Integer id_user;
    private String type_user;
    private String username_user;
    private String password_user;
    private String fullname_user;
    private String correo_user;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }

    public String getUsername_user() {
        return username_user;
    }

    public void setUsername_user(String username_user) {
        this.username_user = username_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public String getFullname_user() {
        return fullname_user;
    }

    public void setFullname_user(String fullname_user) {
        this.fullname_user = fullname_user;
    }

    public String getCorreo_user() {
        return correo_user;
    }

    public void setCorreo_user(String correo_user) {
        this.correo_user = correo_user;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", type_user=" + type_user + ", username_user=" + username_user + ", password_user=" + password_user + ", fullname_user=" + fullname_user + ", correo_user=" + correo_user + '}';
    }

}

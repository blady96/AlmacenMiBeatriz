package com.belili.pojo;

import java.sql.Blob;

public class Administrator implements java.io.Serializable {

    private int idAdministrator;
    private Blob imageAdministrator;
    private String usernameAdministrator;
    private String passwordAdministrator;
    private String fullnameAdministrator;
    private String correoAdministrator;
    private String phoneAdministrator;

    public Administrator() {
    }

    public Administrator(int idAdministrator, String usernameAdministrator, String passwordAdministrator, String fullnameAdministrator) {
        this.idAdministrator = idAdministrator;
        this.usernameAdministrator = usernameAdministrator;
        this.passwordAdministrator = passwordAdministrator;
        this.fullnameAdministrator = fullnameAdministrator;
    }

    public Administrator(int idAdministrator, Blob imageAdministrator, String usernameAdministrator, String passwordAdministrator, String fullnameAdministrator, String correoAdministrator, String phoneAdministrator) {
        this.idAdministrator = idAdministrator;
        this.imageAdministrator = imageAdministrator;
        this.usernameAdministrator = usernameAdministrator;
        this.passwordAdministrator = passwordAdministrator;
        this.fullnameAdministrator = fullnameAdministrator;
        this.correoAdministrator = correoAdministrator;
        this.phoneAdministrator = phoneAdministrator;
    }

    public int getIdAdministrator() {
        return this.idAdministrator;
    }

    public void setIdAdministrator(int idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public Blob getImageAdministrator() {
        return this.imageAdministrator;
    }

    public void setImageAdministrator(Blob imageAdministrator) {
        this.imageAdministrator = imageAdministrator;
    }

    public String getUsernameAdministrator() {
        return this.usernameAdministrator;
    }

    public void setUsernameAdministrator(String usernameAdministrator) {
        this.usernameAdministrator = usernameAdministrator;
    }

    public String getPasswordAdministrator() {
        return this.passwordAdministrator;
    }

    public void setPasswordAdministrator(String passwordAdministrator) {
        this.passwordAdministrator = passwordAdministrator;
    }

    public String getFullnameAdministrator() {
        return this.fullnameAdministrator;
    }

    public void setFullnameAdministrator(String fullnameAdministrator) {
        this.fullnameAdministrator = fullnameAdministrator;
    }

    public String getCorreoAdministrator() {
        return this.correoAdministrator;
    }

    public void setCorreoAdministrator(String correoAdministrator) {
        this.correoAdministrator = correoAdministrator;
    }

    public String getPhoneAdministrator() {
        return this.phoneAdministrator;
    }

    public void setPhoneAdministrator(String phoneAdministrator) {
        this.phoneAdministrator = phoneAdministrator;
    }

    @Override
    public String toString() {
        return "Administrator{" + "idAdministrator=" + idAdministrator + ", imageAdministrator=" + imageAdministrator + ", usernameAdministrator=" + usernameAdministrator + ", passwordAdministrator=" + passwordAdministrator + ", fullnameAdministrator=" + fullnameAdministrator + ", correoAdministrator=" + correoAdministrator + ", phoneAdministrator=" + phoneAdministrator + '}';
    }

}

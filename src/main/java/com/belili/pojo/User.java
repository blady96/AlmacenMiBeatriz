package com.belili.pojo;

import java.sql.Blob;
import java.util.Date;

public class User implements java.io.Serializable {

    private Integer idUser;
    private Blob imageUser;
    private String codeUser;
    private String passwordUser;
    private String fullnameUser;
    private String correoUser;
    private String phone1User;
    private String phone2User;
    private Date dateUser;
    private boolean stateUser;
    private boolean permissionMaintenanceUser;
    private boolean permissionPurchaseUser;
    private boolean permissionSaleUser;
    private boolean permissionWarehouseUser;

    public User() {
    }

    public User(String codeUser, String passwordUser, String fullnameUser, String correoUser, String phone1User, String phone2User, Date dateUser, boolean stateUser, boolean permissionMaintenanceUser, boolean permissionPurchaseUser, boolean permissionSaleUser, boolean permissionWarehouseUser) {
        this.codeUser = codeUser;
        this.passwordUser = passwordUser;
        this.fullnameUser = fullnameUser;
        this.correoUser = correoUser;
        this.phone1User = phone1User;
        this.phone2User = phone2User;
        this.dateUser = dateUser;
        this.stateUser = stateUser;
        this.permissionMaintenanceUser = permissionMaintenanceUser;
        this.permissionPurchaseUser = permissionPurchaseUser;
        this.permissionSaleUser = permissionSaleUser;
        this.permissionWarehouseUser = permissionWarehouseUser;
    }

    public User(Blob imageUser, String codeUser, String passwordUser, String fullnameUser, String correoUser, String phone1User, String phone2User, Date dateUser, boolean stateUser, boolean permissionMaintenanceUser, boolean permissionPurchaseUser, boolean permissionSaleUser, boolean permissionWarehouseUser) {
        this.imageUser = imageUser;
        this.codeUser = codeUser;
        this.passwordUser = passwordUser;
        this.fullnameUser = fullnameUser;
        this.correoUser = correoUser;
        this.phone1User = phone1User;
        this.phone2User = phone2User;
        this.dateUser = dateUser;
        this.stateUser = stateUser;
        this.permissionMaintenanceUser = permissionMaintenanceUser;
        this.permissionPurchaseUser = permissionPurchaseUser;
        this.permissionSaleUser = permissionSaleUser;
        this.permissionWarehouseUser = permissionWarehouseUser;
    }

    public Integer getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Blob getImageUser() {
        return this.imageUser;
    }

    public void setImageUser(Blob imageUser) {
        this.imageUser = imageUser;
    }

    public String getCodeUser() {
        return this.codeUser;
    }

    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }

    public String getPasswordUser() {
        return this.passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getFullnameUser() {
        return this.fullnameUser;
    }

    public void setFullnameUser(String fullnameUser) {
        this.fullnameUser = fullnameUser;
    }

    public String getCorreoUser() {
        return this.correoUser;
    }

    public void setCorreoUser(String correoUser) {
        this.correoUser = correoUser;
    }

    public String getPhone1User() {
        return this.phone1User;
    }

    public void setPhone1User(String phone1User) {
        this.phone1User = phone1User;
    }

    public String getPhone2User() {
        return this.phone2User;
    }

    public void setPhone2User(String phone2User) {
        this.phone2User = phone2User;
    }

    public Date getDateUser() {
        return this.dateUser;
    }

    public void setDateUser(Date dateUser) {
        this.dateUser = dateUser;
    }

    public boolean isStateUser() {
        return this.stateUser;
    }

    public void setStateUser(boolean stateUser) {
        this.stateUser = stateUser;
    }

    public boolean isPermissionMaintenanceUser() {
        return this.permissionMaintenanceUser;
    }

    public void setPermissionMaintenanceUser(boolean permissionMaintenanceUser) {
        this.permissionMaintenanceUser = permissionMaintenanceUser;
    }

    public boolean isPermissionPurchaseUser() {
        return this.permissionPurchaseUser;
    }

    public void setPermissionPurchaseUser(boolean permissionPurchaseUser) {
        this.permissionPurchaseUser = permissionPurchaseUser;
    }

    public boolean isPermissionSaleUser() {
        return this.permissionSaleUser;
    }

    public void setPermissionSaleUser(boolean permissionSaleUser) {
        this.permissionSaleUser = permissionSaleUser;
    }

    public boolean isPermissionWarehouseUser() {
        return this.permissionWarehouseUser;
    }

    public void setPermissionWarehouseUser(boolean permissionWarehouseUser) {
        this.permissionWarehouseUser = permissionWarehouseUser;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", imageUser=" + imageUser + ", codeUser=" + codeUser + ", passwordUser=" + passwordUser + ", fullnameUser=" + fullnameUser + ", correoUser=" + correoUser + ", phone1User=" + phone1User + ", phone2User=" + phone2User + ", dateUser=" + dateUser + ", stateUser=" + stateUser + ", permissionMaintenanceUser=" + permissionMaintenanceUser + ", permissionPurchaseUser=" + permissionPurchaseUser + ", permissionSaleUser=" + permissionSaleUser + ", permissionWarehouseUser=" + permissionWarehouseUser + '}';
    }

}

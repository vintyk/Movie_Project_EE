package video.Entity;

import javax.management.relation.Role;

/**
 * Created by Vinty on 07.04.2017.
 */
public class Users {
    private long id;
    private String nameUser;
    private String familyUser;
    private String sNameUser;
    private String eMailUser;
    private String passwordUser;
    private int privilegeUser;
    private Privileges privileges;
    private String privilegesStr;

    public Users(long id, String nameUser, String eMailUser, String passwordUser, int privilegeUser) {
        this.id = id;
        this.nameUser = nameUser;
        this.eMailUser = eMailUser;
        this.passwordUser = passwordUser;
        this.privilegeUser = privilegeUser;
    }

    public Users(String nameUser, String familyUser, String sNameUser, String eMailUser, String privilegesStr, String passwordUser) {
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.sNameUser = sNameUser;
        this.eMailUser = eMailUser;
        this.privilegesStr = privilegesStr;
        this.passwordUser = passwordUser;

    }

    public Users(long id, String nameUser, String familyUser,
                 String sNameUser, String eMailUser, String passwordUser, Privileges privileges) {
        this.id = id;
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.sNameUser = sNameUser;
        this.eMailUser = eMailUser;
        this.passwordUser = passwordUser;
        this.privileges = privileges;
    }

    public Users(String nameUser, String familyUser,
                 String sNameUser, String eMailUser, String passwordUser, Privileges privileges) {
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.sNameUser = sNameUser;
        this.eMailUser = eMailUser;
        this.passwordUser = passwordUser;
        this.privileges = privileges;
    }

    public Users(String nameUser, String familyUser,
                 String sNameUser, String passwordUser, String eMailUser) {
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.sNameUser = sNameUser;
        this.eMailUser = eMailUser;
        this.passwordUser = passwordUser;
    }
    public Users(String nameUser, String familyUser,
                 String sNameUser, String passwordUser, int privilegeUser, String eMailUser) {
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.sNameUser = sNameUser;
        this.eMailUser = eMailUser;
        this.passwordUser = passwordUser;
        this.privilegeUser = privilegeUser;
    }
    public Users(long id, String nameUser, String familyUser,
                 String sNameUser, String passwordUser, int privilegeUser, String eMailUser) {
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.sNameUser = sNameUser;
        this.eMailUser = eMailUser;
        this.passwordUser = passwordUser;
        this.privilegeUser = privilegeUser;
    }

    public Users(String nameUser, String familyUser) {
        this.nameUser = nameUser;
        this.familyUser = familyUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getFamilyUser() {
        return familyUser;
    }

    public void setFamilyUser(String familyUser) {
        this.familyUser = familyUser;
    }

    public String getsNameUser() {
        return sNameUser;
    }

    public void setsNameUser(String sNameUser) {
        this.sNameUser = sNameUser;
    }

    public String geteMailUser() {
        return eMailUser;
    }

    public void seteMailUser(String eMailUser) {
        this.eMailUser = eMailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public int getPrivilegeUser() {
        return privilegeUser;
    }

    public void setPrivilegeUser(int privilegeUser) {
        this.privilegeUser = privilegeUser;
    }

    public Privileges getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Privileges privileges) {
        this.privileges = privileges;
    }

    public String getPrivilegesStr() {
        return privilegesStr;
    }

    public void setPrivilegesStr(String privilegesStr) {
        this.privilegesStr = privilegesStr;
    }
}

package dto;

/**
 * Created by Vinty on 24.04.2017.
 */
public class ViewUserByEmailDto {
    private String name;
    private String eMail;
    private String password;
    private int privilege;

    public ViewUserByEmailDto(String name, String eMail, String password, int privilege) {
        this.name = name;
        this.eMail = eMail;
        this.password = password;
        this.privilege = privilege;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }
}
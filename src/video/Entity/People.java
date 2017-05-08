package video.Entity;

/**
 * Created by Vinty on 02.04.2017.
 */
public class People {
    private long id;
    private String namePeople;
    private String familyPeople;
    private String sNamePeople;
    private String dateOfBirthPeople;
    private Roles roles;

    public People(long id, String namePeople, String familyPeople) {
        this.id = id;
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
    }

    public People(String namePeople, String familyPeople, String sNamePeople, String dateOfBirthPeople) {
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
        this.sNamePeople = sNamePeople;
        this.dateOfBirthPeople = dateOfBirthPeople;
    }

    public People(long id, String namePeople, String familyPeople, String sNamePeople, String dateOfBirthPeople, Roles roles) {
        this.id = id;
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
        this.sNamePeople = sNamePeople;
        this.dateOfBirthPeople = dateOfBirthPeople;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public String getFamilyPeople() {
        return familyPeople;
    }

    public void setFamilyPeople(String familyPeople) {
        this.familyPeople = familyPeople;
    }

    public String getsNamePeople() {
        return sNamePeople;
    }

    public void setsNamePeople(String sNamePeople) {
        this.sNamePeople = sNamePeople;
    }

    public String getDateOfBirthPeople() {
        return dateOfBirthPeople;
    }

    public void setDateOfBirthPeople(String dateOfBirthPeople) {
        this.dateOfBirthPeople = dateOfBirthPeople;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}

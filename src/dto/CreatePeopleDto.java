package dto;

import video.Entity.Roles;

/**
 * Created by Vinty on 24.04.2017.
 */
public class CreatePeopleDto {
    private String namePeople;
    private String familyPeople;
    private String sNamePeople;
    private String dateOfBirthPeople;
    private long rolesId;

    public CreatePeopleDto(
            String namePeople,
            String familyPeople,
            String sNamePeople,
            String dateOfBirthPeople,
            long rolesID) {
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
        this.sNamePeople = sNamePeople;
        this.dateOfBirthPeople = dateOfBirthPeople;
        this.rolesId = rolesID;
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

    public long getRolesID() {
        return rolesId;
    }

    public void setRolesID(long rolesID) {
        this.rolesId = rolesID;
    }
}

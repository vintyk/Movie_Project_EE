package dto;

/**
 * Created by Vinty on 24.04.2017.
 */
public class ViewPeopleFullInfoDto {
    private String namePeople;
    private String familyPeople;
    private String sNamePeople;
    private String dateOfBirthPeople;
    private String rolePeople;

    public ViewPeopleFullInfoDto(String namePeople, String familyPeople, String sNamePeople, String dateOfBirthPeople, String rolePeople) {
        this.namePeople = namePeople;
        this.familyPeople = familyPeople;
        this.sNamePeople = sNamePeople;
        this.dateOfBirthPeople = dateOfBirthPeople;
        this.rolePeople = rolePeople;
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

    public String getRolePeople() {
        return rolePeople;
    }

    public void setRolePeople(String rolePeople) {
        this.rolePeople = rolePeople;
    }
}

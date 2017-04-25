package dto;

/**
 * Created by Vinty on 24.04.2017.
 */
public class ViewPeopleBasicInfoDto {
    private long id;
    private String name;
    private String family;

    public ViewPeopleBasicInfoDto (long id, String name, String family){
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}

package dto;

/**
 * Created by Vinty on 30.04.2017.
 */
public class ViewGenresBasicDto {
    private long id;
    private String name;

    public ViewGenresBasicDto(long id, String name) {
        this.id = id;
        this.name = name;
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
}

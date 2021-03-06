package video.Entity;

/**
 * Created by User on 21.04.2017.
 */
public class Privileges {
    private long id;
    private String name;

    public Privileges(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Privileges(long id) {
        this.id = id;
    }

    public Privileges(String name) {
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

    @Override
    public String toString() {
        return "Privileges{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

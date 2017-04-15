package video.Entity;

/**
 * Created by Vinty on 09.04.2017.
 */
public class Countrie {
    private long id;
    private String name;

    public Countrie(long id, String name) {
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

    @Override
    public String toString() {
        return "Countrie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

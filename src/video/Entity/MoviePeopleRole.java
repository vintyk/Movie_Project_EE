package video.Entity;

/**
 * Created by User on 03.05.2017.
 */
public class MoviePeopleRole {
    private long moviesId;
    private long peoplesId;
    private long rolesId;

    public MoviePeopleRole(long moviesId, long peoplesId, long rolesId) {
        this.moviesId = moviesId;
        this.peoplesId = peoplesId;
        this.rolesId = rolesId;
    }

    public long getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(long moviesId) {
        this.moviesId = moviesId;
    }

    public long getPeoplesId() {
        return peoplesId;
    }

    public void setPeoplesId(long peoplesId) {
        this.peoplesId = peoplesId;
    }

    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }
}

package dto;

/**
 * Created by User on 03.05.2017.
 */
public class CreateMoviesPeopleRoleDto {
    private long movieId;
    private long peopleId;
    private long roleId;

    public CreateMoviesPeopleRoleDto(long movieId, long peopleId, long roleId) {
        this.movieId = movieId;
        this.peopleId = peopleId;
        this.roleId = roleId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}

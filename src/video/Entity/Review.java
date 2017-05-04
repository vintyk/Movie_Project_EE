package video.Entity;

/**
 * Created by User on 04.05.2017.
 */
public class Review {
    long id;
    long movieId;
    long userId;
    long rank;
    String commentUser;
    Users users;


    public Review(long movieId, long userId, long rank, String commentUser) {
        this.movieId = movieId;
        this.userId = userId;
        this.rank = rank;
        this.commentUser = commentUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }
}

package dto;

/**
 * Created by User on 05.05.2017.
 */
public class ViewReviewDto {
    private long rank;
    private String comment_user;
    private String nameUser;
    private String familyUser;

    public ViewReviewDto(long rank, String comment_user, String nameUser, String familyUser) {
        this.rank = rank;
        this.comment_user = comment_user;
        this.nameUser = nameUser;
        this.familyUser = familyUser;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getComment_user() {
        return comment_user;
    }

    public void setComment_user(String comment_user) {
        this.comment_user = comment_user;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getFamilyUser() {
        return familyUser;
    }

    public void setFamilyUser(String familyUser) {
        this.familyUser = familyUser;
    }
}

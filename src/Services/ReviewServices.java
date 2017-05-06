package Services;
import dto.ViewReviewDto;
import video.dao.ReviewDao;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 05.05.2017.
 */
public class ReviewServices {
    private static final Object LOCK = new Object();
    private static ReviewServices INSTANCE = null;

    private ReviewServices() {
    }

    public static ReviewServices getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new ReviewServices();
                }
            }
        }
        return INSTANCE;
    }
    public List<ViewReviewDto> getAllReviewByMovieID(long id) {
        return ReviewDao.getInstance().findAllReviewByIDMovie(id).stream()
                .map(moviesEntity -> new ViewReviewDto(
                        moviesEntity.getRank(),
                        moviesEntity.getCommentUser(),
                        moviesEntity.getUsers().getNameUser(),
                        moviesEntity.getUsers().getFamilyUser()))
                .collect(Collectors.toList());
    }
}

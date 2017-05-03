package Services;
import dto.CreateMoviesPeopleRoleDto;
import video.Entity.MoviePeopleRole;
import video.dao.MoviePeopleRoleDao;


/**
 * Created by User on 03.05.2017.
 */
public class MoviePeopleRoleServices {
    private static final Object LOCK = new Object();
    private static MoviePeopleRoleServices INSTANCE = null;

    private MoviePeopleRoleServices() {
    }

    public static MoviePeopleRoleServices getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new MoviePeopleRoleServices();
                }
            }
        }
        return INSTANCE;
    }

//    public void createNewMoviePeopleRole(CreateMoviesPeopleRoleDto dto) {
//        MoviePeopleRoleDao.getInstance().create(new MoviePeopleRole(
//                dto.getMovieId(),
//                dto.getPeopleId(),
//                dto.getRoleId()));
//    }
}

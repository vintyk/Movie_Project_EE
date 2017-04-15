package Services;
import video.Entity.Users;
import video.dao.UsersDao;
import java.util.Optional;
/**
 * Created by Vinty on 13.04.2017.
 */
public class UserServices {
    public Optional<Users> userOptional = UsersDao.getInstance().addUser(
            new Users( "Елена",
                    "Жукова",
                    "Леонидовна",
                    "qwerty3",
                    2,
                    "ej@ecp.by"));
    }
//        System.out.println(UsersDao.getInstance().getById(5L));



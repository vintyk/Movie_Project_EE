package video.video;

import video.Entity.Users;
import video.dao.UsersDao;

import java.util.Optional;

/**
 * Created by User on 20.04.2017.
 */
public class UserStarter {
    public static void main(String[] args) {
        Optional<Users> userOptional = UsersDao.getInstance().addUser(
                new Users( "Елена",
                        "Жукова",
                        "Леонидовна",
                        "qwerty3",
                        "ej@ecp.by"));
    }
}

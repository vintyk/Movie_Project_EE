package video.video;
import video.Entity.Users;
import video.dao.UsersDao;

import java.util.Optional;

/**
 * Created by Vinty on 09.04.2017.
 */
public class UserStarter {
    public static void main(String[] args) {

        Optional<Users> userOptional = UsersDao.getInstance().addUser(
                new Users( "Елена",
                           "Жукова",
                          "Леонидовна",
                        "qwerty3",
                         2,
                           "ej@ecp.by"));
        if (userOptional.isPresent()) {
            System.out.println(userOptional.get());
        }
//        System.out.println(UsersDao.getInstance().getById(5L));

    }

}

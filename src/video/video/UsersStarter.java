package video.video;

import video.Entity.Privileges;
import video.Entity.Users;
import video.dao.PrivilegesDao;
import video.dao.UsersDao;

import java.util.Optional;

/**
 * Created by User on 20.04.2017.
 */
public class UsersStarter {
    public static void main(String[] args) {
//        Optional<Users> userOptional = UsersDao.getInstance().addUser(
//                new Users( "Елена",
//                        "Жукова",
//                        "Леонидовна",
//                        "qwerty3",
//                        "ej@ecp.by"));

        //System.out.println(UsersDao.getInstance().getById(2));

        Optional<Privileges> privileges = PrivilegesDao.getInstance().getById(1L);
        if (privileges.isPresent()){
            System.out.println(privileges.get().getName());
        }
        System.out.println(UsersDao.getInstance().getByIdPriv(1));
    }
}

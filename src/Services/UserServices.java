package Services;
import video.Entity.Users;
import video.dao.UsersDao;
import java.util.Optional;
/**
 * Created by Vinty on 13.04.2017.
 */
public class UserServices {
    private static final Object LOCK = new Object();
    private static UserServices INSTANCE = null;

    public static UserServices getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new UserServices();
                }
            }
        }
        return INSTANCE;
    }




//    public int getUserInfo(long userId) {
//        Optional<Users> userInfo = UsersDao.getInstance().addUser(userId);
//        if (userInfo.isPresent()) {
//            return userInfo.get().;
//        }
//        return 0;
//    }


}
//    public Optional<Users> userOptional = UsersDao.getInstance().addUser(
//            new Users( "Елена",
//                    "Жукова",
//                    "Леонидовна",
//                    "qwerty3",
//                    "ej@ecp.by"));
//    }
//        System.out.println(UsersDao.getInstance().getById(5L));

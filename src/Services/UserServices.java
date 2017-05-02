package Services;
import dto.ViewPeopleFullInfoDto;
import dto.ViewUserByEmailDto;
import video.Entity.People;
import video.Entity.Users;
import video.dao.PeopleDao;
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

    public ViewUserByEmailDto getUserByEmail(String eMail) {
        Optional<Users> usersOptional = UsersDao.getInstance().find(eMail);
        if (!usersOptional.isPresent()) {
            throw new IllegalArgumentException("Не существует пользователя с такими параметрами!");
        }
        Users users = usersOptional.get();
        return new ViewUserByEmailDto(
                users.getNameUser(),
                users.geteMailUser(),
                users.getPasswordUser(),
                users.getPrivilegeUser()
        );
    }
}
//    public Optional<Users> userOptional = UsersDao.getInstance().addUser(
//            new Users( "Елена",
//                    "Жукова",
//                    "Леонидовна",
//                    "qwerty3",
//                    "ej@ecp.by"));
//    }
//        System.out.println(UsersDao.getInstance().getById(5L));

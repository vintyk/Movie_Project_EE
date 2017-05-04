package Services;
import dto.ViewUserByEmailDto;
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

    public ViewUserByEmailDto getUserByEmail(String eMail) {
        Optional<Users> usersOptional = UsersDao.getInstance().find(eMail);
        if (!usersOptional.isPresent()) {
            throw new IllegalArgumentException("Не существует пользователя с такими параметрами!");
        }
        Users users = usersOptional.get();
        return new ViewUserByEmailDto(
                users.getId(),
                users.getNameUser(),
                users.geteMailUser(),
                users.getPasswordUser(),
                users.getPrivilegeUser()
        );
    }
}

package video.video;

import video.Entity.Privileges;
import video.Entity.Users;
import video.dao.PrivilegesDao;
import video.dao.UsersDao;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by User on 20.04.2017.
 */
public class UsersStarter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tmp = scanner.next();
        if (tmp.equals("en")) {
            Locale.setDefault(new Locale("en", "US"));
        }else if (tmp.equals("ru")) {
            Locale.setDefault(new Locale("ru", "RU"));
        }else {Locale.setDefault(new Locale("be", "BY"));}
        ResourceBundle resourceBundle = ResourceBundle.getBundle("translation");
        System.out.println(resourceBundle.getString("text"));
//        Optional<Users> userOptional = UsersDao.getInstance().addUser(
//                new Users( "Елена",
//                        "Жукова",
//                        "Леонидовна",
//                        "qwerty3",
//                        "ej@ecp.by"));

        //System.out.println(UsersDao.getInstance().getById(2));

//        Optional<Privileges> privileges = PrivilegesDao.getInstance().getById(1L);
//        if (privileges.isPresent()){
//            System.out.println(privileges.get().getName());
//        }
//        System.out.println(UsersDao.getInstance().getByIdPriv(1));
//    }
    }

}
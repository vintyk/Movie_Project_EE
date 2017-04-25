package Services;
import video.Entity.Privileges;
/**
 * Created by User on 21.04.2017.
 */
public class PrivilegesServices {
    private static final Object LOCK = new Object();
    private static PrivilegesServices INSTANCE = null;

    public static PrivilegesServices getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PrivilegesServices();
                }
            }
        }
        return INSTANCE;
    }
}

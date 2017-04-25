package Services;

/**
 * Created by User on 21.04.2017.
 */
public class RoleServises {
    private static final Object LOCK = new Object();
    private static RoleServises INSTANCE = null;

    public static RoleServises getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new RoleServises();
                }
            }
        }
        return INSTANCE;
    }


}

package video.video;

import video.dao.PrivilegesDao;

/**
 * Created by User on 21.04.2017.
 */
public class PrivilegesStarter {
    public static void main(String[] args) {
        System.out.println(PrivilegesDao.getInstance().getById(1));
    }
}

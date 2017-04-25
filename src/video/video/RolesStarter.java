package video.video;

import video.Entity.Roles;
import video.dao.RolesDao;

import java.util.Optional;

/**
 * Created by User on 21.04.2017.
 */
public class RolesStarter {
    public static void main(String[] args) {

        System.out.println(RolesDao.getInstance().getById(2));
    }
}

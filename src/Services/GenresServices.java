package Services;

import dto.ViewGenresBasicDto;
import video.dao.GenresDao;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vinty on 30.04.2017.
 */
public class GenresServices {
        private static final Object LOCK = new Object();
        private static Services.GenresServices INSTANCE = null;

        private GenresServices(){}

        public static Services.GenresServices getInstance() {
            if (INSTANCE == null) {
                synchronized (LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = new Services.GenresServices();
                    }
                }
            }
            return INSTANCE;
        }

        public List<ViewGenresBasicDto> getAllGenres() {
            return GenresDao.getInstance().findAll().stream()
                    .map(genresEntity -> new ViewGenresBasicDto(
                            genresEntity.getId(),
                            genresEntity.getName()))
                    .collect(Collectors.toList());
        }
}

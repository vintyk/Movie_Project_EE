package Services;

import dto.ViewCountriesBasicDto;
import video.dao.CountryDao;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vinty on 30.04.2017.
 */
public class CountryServices {
        private static final Object LOCK = new Object();
        private static CountryServices INSTANCE = null;

        private CountryServices(){}

        public static CountryServices getInstance() {
            if (INSTANCE == null) {
                synchronized (LOCK) {
                    if (INSTANCE == null) {
                        INSTANCE = new CountryServices();
                    }
                }
            }
            return INSTANCE;
        }

        public List<ViewCountriesBasicDto> getAllCountries() {
            return CountryDao.getInstance().findAll().stream()
                    .map(countriesEntity -> new ViewCountriesBasicDto(
                            countriesEntity.getId(),
                            countriesEntity.getName()))
                    .collect(Collectors.toList());
        }
    }


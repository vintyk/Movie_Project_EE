package Services;

import dto.CreatePeopleDto;
import dto.ViewPeopleBasicInfoDto;
import dto.ViewPeopleFullInfoDto;
import video.Entity.People;
import video.dao.PeopleDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Vinty on 13.04.2017.
 */
public class PeopleServices {
    private static final Object LOCK = new Object();
    private static PeopleServices INSTANCE = null;

    private PeopleServices(){}

    public static PeopleServices getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new PeopleServices();
                }
            }
        }
        return INSTANCE;
    }

    public void createNewPeople(CreatePeopleDto dto) {
        PeopleDao.getInstance().create(new People(
                dto.getNamePeople(),
                dto.getFamilyPeople(),
                dto.getsNamePeople(),
                dto.getDateOfBirthPeople()),
                dto.getRolesID());
    }

    public List<ViewPeopleBasicInfoDto> getAllPeople() {
        return PeopleDao.getInstance().findAll().stream()
                .map(peopleEntity -> new ViewPeopleBasicInfoDto(
                        peopleEntity.getId(),
                        peopleEntity.getNamePeople(),
                        peopleEntity.getFamilyPeople()))
                .collect(Collectors.toList());
    }
    public ViewPeopleFullInfoDto getFullInfo(long id) {
        Optional<People> peopleOptional = PeopleDao.getInstance().findById(id);
        if (!peopleOptional.isPresent()) {
            throw new IllegalArgumentException("Не существует актера с такими параметрами!");
        }
        People people = peopleOptional.get();
        return new ViewPeopleFullInfoDto(
                people.getNamePeople(),
                people.getFamilyPeople(),
                people.getsNamePeople(),
                people.getDateOfBirthPeople(),
                people.getRoles().getName());
    }
}

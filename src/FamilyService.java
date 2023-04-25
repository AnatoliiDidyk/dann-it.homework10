import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {

    private FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = getAllFamilies();
        families.forEach(family -> System.out.println(family.toString()));
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        return familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() > number)
                .collect(Collectors.toList());
    }


    public List<Family> getFamiliesLessThan(int number) {
        return familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() < number)
                .collect(Collectors.toList());
    }

    public long countFamiliesWithMemberNumber(int number) {
        return familyDao.getAllFamilies()
                .stream()
                .filter(family -> family.countFamily() == number)
                .count();
    }

    public void createNewFamily(Human mother, Human father) {
        familyDao.createNewFamily(new Family(mother, father));
    }

    public void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    public Family bornChild(Family family, String masculineName, String feminineName) {
        Human child = family.bornChild(masculineName, feminineName);
        familyDao.saveFamily(family);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        family.addChild(child);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyDao.getAllFamilies()
                .forEach(family -> family.getChildren()
                        .removeIf(child -> Period.between(child.getBirthDate(), LocalDate.now()).getYears() > age));
    }

    public int count() {
        return familyDao.count();
    }

    public Family getFamilyById(int index) {
        return familyDao.getFamilyByIndex(index);
    }

    public List<Pet> getPets(int index) {
        return familyDao.getPets(index);
    }

    public void addPet(int index, Pet pet) {
        familyDao.addPet(index, pet);
    }
}
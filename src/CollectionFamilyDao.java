import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao {

    private List<Family> families;

    public CollectionFamilyDao() {
        this.families = new ArrayList<>();
    }

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index < 0 || index >= families.size()) {
            return null;
        }
        return families.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index >= families.size()) {
            return false;
        }
        families.remove(index);
        return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        if (families.contains(family)) {
            families.set(families.indexOf(family), family);
        } else {
            families.add(family);
        }
    }
    private Map<Integer, Family> families = new HashMap<>();

    @Override
    public List<Family> getAllFamilies() {
        return new ArrayList<>(families.values());
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> result = new ArrayList<>();
        for (Family family : families.values()) {
            if (family.countFamily() > number) {
                result.add(family);
            }
        }
        return result;
    }



    @Override
    public int countFamiliesWithMemberNumber(int number) {
        int count = 0;
        for (Family family : families.values()) {
            if (family.countFamily() == number) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void createNewFamily(Family family) {
        families.put(family.getId(), family);
    }

    @Override
    public void deleteFamily(int index) {
        families.remove(index);
    }

    @Override
    public void saveFamily(Family family) {
        families.put(family.getId(), family);
    }

    @Override
    public void deleteAllChildrenOlderThan(int age) {
        for (Family family : families.values()) {
            family.getChildren().removeIf(child -> child.getAge() > age);
        }
    }

    @Override
    public int count() {
        return families.size();
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return families.get(index);
    }

    @Override
    public List<Pet> getPets(int index) {
        Family family = families.get(index);
        if (family != null) {
            return family.getPets();
        }
        return new ArrayList<>();
    }

    @Override
    public void addPet(int index, Pet pet) {
        Family family = families.get(index);
        if (family != null) {
            family.getPets().add(pet);
        }
    }
    @Override
    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> result = new ArrayList<>();
        for (Family family : families.values()) {
            if (family.countFamily() > number) {
                result.add(family);
            }
        }
        return result;
    }

}
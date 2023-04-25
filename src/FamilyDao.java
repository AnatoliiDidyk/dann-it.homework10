import java.util.ArrayList;
import java.util.List;

public interface FamilyDao {
    List<Family> families = new ArrayList<>();

    default List<Family> getAllFamilies() {
        return families;
    }

    default Family getFamilyByIndex(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        } else {
            return null;
        }
    }

    default boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        } else {
            return false;
        }
    }

    default boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    default void saveFamily(Family family) {
        if (families.contains(family)) {
            families.set(families.indexOf(family), family);
        } else {
            families.add(family);
        }
    }

    void createNewFamily(Family family);
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class FamilyTest {
    private Family family;
    private Human human;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Set<Pet> pets;
    private Human children1;
    private Human children2;
    private Pet pet1;
    private Pet pet2;

    @BeforeEach
    public void setFamily(){
        mother = new Human ("Natasha","Didyk",2000);
        father = new Human("Anton","Didyk", 1999);
        children = new ArrayList<>();
        children.add(new Human("Nick", "Didyk",2020));
        children.add(new Human("Olya", "Didyk",2021));
        pet1 = new Dog("Sharik", PetSpecies.petSpecies.Dog);
        pet2 = new Cat("Tom", PetSpecies.petSpecies.Cat);
        pets = new HashSet<>();
        pets.add(pet1);
        pets.add(pet2);
        family = new Family(mother, father,children,pets);
        children1 = new Human("Misha", "Didyk", 2019);
        children2 = new Human("Mariya", "Didyk", 2018);

    }
    @Test
    void testAddChild() {
        family.addChild(children1);
        assertEquals(3, family.getChildren().size());
        assertTrue(family.getChildren().containsAll(Arrays.asList(children.get(0), children.get(1), children1)));
    }

    @Test
    void testDeleteChild() {
        family.deleteChild(children.get(0));
        assertEquals(1,family.getChildren().size());
        assertTrue(family.getChildren().contains(children.get(1)));
    }

    @Test
    void testDeleteChildIndex() {
        family.deleteChild(1);
        assertEquals(1,family.getChildren().size());
        assertTrue(family.getChildren().contains(children.get(0)));
    }

    @Test
    void testCountFamily() {
        assertEquals(7, family.countFamily());
    }
}
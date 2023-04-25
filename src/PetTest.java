import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class PetTest {
    @Test
    void PetTest1() {
        Pet pet = new Pet("Sharik", PetSpecies.petSpecies.Dog, 10);
        pet.setNickname("dkfjf");
        assertEquals("dkfjf", pet.getNickname());
    }

    @Test
    public void PetTestConstructor() {
        Set<String> habits = new HashSet<>(Arrays.asList("eat", "poop"));
        Pet pet = new Pet("dkfjf", PetSpecies.petSpecies.Cat, 66, 55, habits);
        assertEquals("dkfjf", pet.getNickname());
        assertEquals(PetSpecies.petSpecies.Cat, pet.getPetSpecies());
        assertEquals(66, pet.getAge());
        assertEquals(55, pet.getTrickLevel());
        assertEquals(habits, new HashSet<>(Arrays.asList(pet.getHabits())));
    }
}

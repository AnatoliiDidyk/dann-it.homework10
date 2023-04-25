import java.util.Arrays;
import java.util.Objects;

public abstract class Pet(String nickname, PetSpecies.petSpecies petSpecies, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
    setPetSpecies(petSpecies);
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
}

    public void setPetSpecies(PetSpecies petSpecies) {
        this.petSpecies = petSpecies;
    }

    public PetSpecies getPetSpecies() {
        return petSpecies;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public abstract void respond();

    public void eat() {
        System.out.println("I'm eating");
    }

    public String trickeness() {
        if (getTrickLevel() > 50) {
            return "it is very tricky";
        } else {
            return "it is not tricky";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && petSpecies == pet.petSpecies && Objects.equals(nickname, pet.nickname) && Objects.equals(habits, pet.habits) && Objects.equals(family, pet.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petSpecies, nickname, age, trickLevel, habits, family);
    }

    @Override
    public String toString() {
        return getPetSpecies() + "{nickname='" + getNickname() + "', age=" + getAge() + ", trickLevel=" + getTrickLevel() + ", habits=" + getHabits() + "}";
    }
}
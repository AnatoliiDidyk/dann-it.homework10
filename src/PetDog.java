public class Dog extends Pet {

    public Dog(String nickname, PetSpecies.petSpecies petSpecies) {
        super(nickname,PetSpecies.petSpecies.Dog, getAge(), getTrickLevel(), getHabits());
    }

    public Dog(String nickname, PetSpecies petSpecies, int age, int trickLevel, String[] habits) {
        super(nickname, PetSpecies.petSpecies.Dog, age, trickLevel, habits);
    }

    @Override
    public void foul() {
        System.out.println("I have made huge poop!");
    }
}
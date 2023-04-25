public class RoboCat extends Pet {

    public RoboCat(String nickname, PetSpecies petSpecies) {
        super(nickname, PetSpecies.petSpecies.RoboCat, getAge(), getTrickLevel(), getHabits());
    }

    public RoboCat(String nickname, PetSpecies petSpecies, int age, int trickLevel, String[] habits) {
        super(nickname, PetSpecies.petSpecies.RoboCat, age, trickLevel, habits);
    }

    @Override
    public void foul() {
        System.out.println("I don't  have program to foul!");
    }
}
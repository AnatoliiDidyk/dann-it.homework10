public class DomesticCat extends Pet {
    public DomesticCat(String nickname, PetSpecies petSpecies) {
        super(nickname, PetSpecies.petSpecies.DomesticCat, getAge(), getTrickLevel(), getHabits());
    }

    public DomesticCat(String nickname, PetSpecies petSpecies, int age, int trickLevel, String[] habits) {
        super(nickname, PetSpecies.petSpecies.DomesticCat, age, trickLevel, habits);
    }

    @Override
    public void foul() {
        System.out.println("I have make a mess in toilet!");
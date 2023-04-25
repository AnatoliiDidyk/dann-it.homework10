import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Family {

    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father, List<Human> children, Set<Pet> pets){
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pets = pets;
    }

    public void setMother(Human mother){
        this.mother = mother;
    }

    public Human getMother(){
        return mother;
    }

    public void setFather(Human father){
        this.father = father;
    }

    public Human getFather(){
        return father;
    }

    public void setChildren(List<Human> children){
        this.children = children;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setPets(Set<Pet> pets){
        this.pets = pets;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public String toString(){
        return mother.toString() + father.toString() + children.toString() + pets.toString();
    }

    public String getPetNickname(){
        if(pets.isEmpty()) {
            return null;
        }
        return pets.iterator().next().getNickname();
    }

    public PetSpecies getPetSpecies(){
        if(pets.isEmpty()) {
            return null;
        }
        return pets.iterator().next().getPetSpecies();
    }

    public int getPetAge(){
        if(pets.isEmpty()) {
            return -1;
        }
        return pets.iterator().next().getAge();
    }

    public String getPetTrickennes() {
        if(pets.isEmpty()) {
            return null;
        }
        return pets.iterator().next().Trickeness();
    }

    public void addChild(Human human){
        children.add(human);
        human.setFamily(this);
    }

    public void deleteChild(int childIndex){
        children.remove(childIndex);
    }

    public int countFamily(){
        int familyMembers = 2;
        if(children != null){
            familyMembers += children.size();
        }
        if(pets != null){
            familyMembers += pets.size();
        }
        return familyMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.equals(children, family.children) && Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Information about " + mother + " " + father + " " + pets.toString() + " " + children.toString());
        super.finalize();
    }

    public Human bornChild(String masculineName, String feminineName) {
    }



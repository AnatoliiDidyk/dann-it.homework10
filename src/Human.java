import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private long birthDate;
    private int iqLevel;
    private Family family;
    private HumanScheduleDay humanScheduleDay;



    public void greetPet(){
        System.out.println("Hello, "+ family.getPet().getNickname());
    }

    public void describePet(){
        System.out.println("I have " + family.getPetSpecies() + " its age is " + family.getPetAge() +" " + family.getPetTrickennes());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.ofEpochDay(this.birthDate / 86400000L);
        return "Human{name='" + this.getName() + "', surname='" + this.getSurname() + "', birthDate=" + birthDate.format(formatter) + ", iq=" + this.getIqLevel() + "," + this.getHumanScheduleDay() + "}";
    }   return "Human{name='"+ this.getName() + "', surname='" + this.getSurname() +"', year=" + this.getYearOfBirth()+ ", iq=" + this.getIqLevel()+ "," + this.getHumanScheduleDay() +"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iqLevel == human.iqLevel && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family) && Objects.equals(humanScheduleDay, human.getHumanScheduleDay()) && Objects.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iqLevel, family, humanScheduleDay);
    }

    public Human(){}

    public Human(String name, String surname, int yearOfBirth){
        this.name = name;
        this.surname = surname;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDate, formatter);
        this.birthDate = localDate.atStartOfDay().toEpochSecond() * 1000L;
        this.humanScheduleDay = new HashMap<String, String>();
    }

    public Human (String name, String surname, int yearOfBirth, int iqLevel, HumanScheduleDay humanScheduleDay ){
        this.name = name;
        this.surname = surname;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDateStr, formatter);
        this.birthDate = localDate.atStartOfDay().toEpochSecond() * 1000L;
        this.iqLevel= iqLevel;
        this.setHumanScheduleDay(humanScheduleDay);
        this.humanScheduleDay = new HashMap<String, String>();
    }
    public String describeAge() {
        LocalDate birthDate = LocalDate.ofEpochDay(this.birthDate / 86400000L);
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthDate, now);
        int years = age.getYears();
        int months = age.getMonths();
        int days = age.getDays();
        return years + " years, " + months + " months, " + days + " days";
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return surname;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setIqLevel(int iqLevel){
        this.iqLevel = iqLevel;
    }

    public int getIqLevel(){
        return iqLevel;
    }

    public void setHumanScheduleDay (HumanScheduleDay humanScheduleDay){
        this.humanScheduleDay = humanScheduleDay;
        this.humanScheduleDay = new HashMap<String, String>();
        for (String key : humanScheduleDay.getSchedule().keySet()) {
            this.humanScheduleDay.put(key, humanScheduleDay.getSchedule().get(key));
        }
    }
    public HumanScheduleDay getHumanScheduleDay(){
        return humanScheduleDay;
    }

    public void setFamily(Family family){
        this.family = family;
    }

    public void setSchedule(Map<String, String> schedule) {
        this.humanScheduleDay = schedule;
    }

    public Map<String, String> getSchedule() {
        return humanScheduleDay;
    }

    @Override
    protected void finalize() throws Throwable {


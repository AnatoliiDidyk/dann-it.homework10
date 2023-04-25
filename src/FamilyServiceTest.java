public class FamilyServiceTest {
    private FamilyService familyService;
    private List<Family> families;

    @Before
    public void setUp() {
        families = new ArrayList<>();
        familyService = new FamilyService(new CollectionFamilyDao(families));

        Human mother1 = new Human("Mother1", "Surname1", LocalDate.of(1985, 12, 10));
        Human father1 = new Human("Father1", "Surname1", LocalDate.of(1983, 5, 20));
        Family family1 = new Family(mother1, father1);
        family1.addChild(new Human("Child1", "Surname1", LocalDate.of(2010, 5, 10)));
        family1.addChild(new Human("Child2", "Surname1", LocalDate.of(2015, 7, 20)));
        familyService.createNewFamily(mother1, father1);
        families.add(family1);

        Human mother2 = new Human("Mother2", "Surname2", LocalDate.of(1990, 10, 15));
        Human father2 = new Human("Father2", "Surname2", LocalDate.of(1992, 3, 25));
        Family family2 = new Family(mother2, father2);
        family2.addChild(new Human("Child3", "Surname2", LocalDate.of(2018, 9, 5)));
        family2.addChild(new Human("Child4", "Surname2", LocalDate.of(2021, 2, 12)));
        familyService.createNewFamily(mother2, father2);
        families.add(family2);
    }

    @Test
    public void testGetAllFamilies() {
        List<Family> actualFamilies = familyService.getAllFamilies();
        assertEquals(families, actualFamilies);
    }

    @Test
    public void testGetFamiliesBiggerThan() {
        List<Family> expectedFamilies = List.of(families.get(0));
        List<Family> actualFamilies = familyService.getFamiliesBiggerThan(3);
        assertEquals(expectedFamilies, actualFamilies);
    }

    @Test
    public void testGetFamiliesLessThan() {
        List<Family> expectedFamilies = List.of(families.get(1));
        List<Family> actualFamilies = familyService.getFamiliesLessThan(3);
        assertEquals(expectedFamilies, actualFamilies);
    }

    @Test
    public void testCountFamiliesWithMemberNumber() {
        int expectedCount = 1;
        int actualCount = familyService.countFamiliesWithMemberNumber(4);
        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testCreateNewFamily() {
        Human mother = new Human("Mother3", "Surname3", LocalDate.of(1995, 3, 5));
        Human father = new Human("Father3", "Surname3", LocalDate.of(1990, 6, 15));
        familyService.createNewFamily(mother, father);
        List<Family> expectedFamilies = List.of(families.get(0), families.get(1), new Family(mother, father));
        List<Family> actualFamilies = familyService.getAllFamilies();
        assertEquals(expectedFamilies, actualFamilies);
    }

    @Test
    public void testDeleteFamilyByIndex() {
        int index = 1;
        familyService.deleteFamilyByIndex(index);
        List<Family> expectedFamilies = List.of(families.get(0));
        List<Family> actualFamilies = familyService
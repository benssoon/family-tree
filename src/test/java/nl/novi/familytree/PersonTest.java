package nl.novi.familytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testThatParentsAreParentOfChild() {
        //arrange:
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m", 69);

        //act:
        mom.addChild(ben);
        dad.addChild(ben);

        //assert:
        assertSame(mom, ben.getMother());
        assertSame(dad, ben.getFather());
    }

    @Test
    public void testThatChildIsChildOfParents() {
        // arrange
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m", 69);

        // act
        ben.addParents(dad, mom);

        // assert
        assertSame(ben, mom.getChildren().getLast());
    }

    @Test
    public void testThatMotherIsMother() {
        // arrange
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m", 69);

        // act
        ben.addParents(dad, mom);

        // asset
        assertSame(mom, ben.getMother());
    }

    @Test
    public void testThatFatherIsFather() {
        // arrange
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m", 69);

        // act
        ben.addParents(dad, mom);

        // assert
        assertSame(dad, ben.getFather());
    }

    @Test
    public void  testThatParentsHaveCorrectSex() {
        // arrange
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m", 69);

        // act
        ben.addParents(mom, dad);

        // assert
        assertEquals(ben.getFather().getSex(), dad.getSex());
        assertEquals(ben.getMother().getSex(), mom.getSex());
    }

    @Test
    public void testThatPetIsPet() {
        // arrange
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Pet dog = new Pet("Rover", 6, "Australian Shepherd");

        // act
        ben.addPet(dog);

        // assert
        assertSame(dog, ben.getPets().getLast());
    }

    @Test
    public void testThatSiblingIsSibling() {
        // arrange
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person benBro = new Person("Bro", "Zelinsky", "m", 33);

        // act
        ben.addSibling(benBro);

        // assert
        assertSame(benBro, ben.getSiblings().getLast());
    }

    @Test
    public void testThatSiblingHasSameParents() {
        // arrange
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person benBro = new Person("Bro", "Zelinsky", "m", 33);
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m" , 69);

        // act
        ben.addParents(mom, dad);
        ben.addSibling(benBro);

        // assert
        assertSame(benBro.getMother(), ben.getMother());
        assertSame(benBro.getFather(), ben.getFather());
        assertEquals(ben.getMother().getFirstName(), benBro.getMother().getFirstName());
    }

    @Test
    public void testThatNewChildHasSiblings() {
        // arrange
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m" , 69);
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person benBro = new Person("Bro", "Zelinsky", "m", 33);
        Person benSis = new Person("Sis", "Zelinsky", "f", 29);

        //act
        mom.addChild(ben);
        mom.addChild(benBro);

        //assert
        assertSame(ben.getSiblings().getLast(), mom.getChildren().getLast());
    }

    @Test
    public void testThatGrandchildIsGrandchild() {
        // arrange
        Person grandpa = new Person("Dan", "Ube", "m", 100);
        Person grandma = new Person("Ori", "Chide", "f", 99);
        Person mom = new Person("Lily", "Valley", "f", 69);
        Person dad = new Person("Bruce", "Wood", "m" , 69);
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person benBro = new Person("Bro", "Zelinsky", "m", 33);

        // act
        ben.addParents(mom, dad);
        ben.addSibling(benBro);
        dad.addParents(grandma, grandpa);

        // assert
        assertSame(benBro, ben.getSiblings().getLast());
    }

}
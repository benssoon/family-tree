package nl.novi.familytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person mom;
    Person dad;
    Person ben;
    Person benBro;
    Person benSis;
    Person grandpa;
    Person grandma;
    Pet dog;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mom = new Person("Lily", "Valley", "f", 69);
        dad = new Person("Bruce", "Wood", "m" , 69);
        ben = new Person("Ben", "Zelinsky", "m", 33);
        benBro = new Person("Bro", "Zelinsky", "m", 33);
        benSis = new Person("Sis", "Zelinsky", "f", 29);
        grandpa = new Person("Dan", "Ube", "m", 100);
        grandma = new Person("Ori", "Chide", "f", 99);
        dog = new Pet("Rover", 6, "Australian Shepherd");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testThatParentsAreParentOfChild() {
        //arrange:

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


        // act
        ben.addParents(dad, mom);

        // assert
        assertSame(ben, mom.getChildren().getLast());
    }

    @Test
    public void testThatMotherIsMother() {
        // arrange


        // act
        ben.addParents(dad, mom);

        // asset
        assertSame(mom, ben.getMother());
    }

    @Test
    public void testThatFatherIsFather() {
        // arrange


        // act
        ben.addParents(dad, mom);

        // assert
        assertSame(dad, ben.getFather());
    }

    @Test
    public void  testThatParentsHaveCorrectSex() {
        // arrange

        // act
        ben.addParents(mom, dad);

        // assert
        assertEquals(ben.getFather().getSex(), dad.getSex());
        assertEquals(ben.getMother().getSex(), mom.getSex());
    }

    @Test
    public void testThatPetIsPet() {
        // arrange


        // act
        ben.addPet(dog);

        // assert
        assertSame(dog, ben.getPets().getLast());
    }

    @Test
    public void testThatSiblingIsSibling() {
        // arrange


        // act
        ben.addSibling(benBro);

        // assert
        assertSame(benBro, ben.getSiblings().getLast());
    }

    @Test
    public void testThatSiblingHasSameParents() {
        // arrange


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


        //act
        mom.addChild(ben);
        mom.addChild(benBro);

        //assert
        assertSame(ben.getSiblings().getLast(), mom.getChildren().getLast());
    }

    @Test
    public void testThatGrandchildIsGrandchild() {
        // arrange



        // act
        ben.addParents(mom, dad);
        ben.addSibling(benBro);
        dad.addParents(grandma, grandpa);
        
        // assert
        assertSame(grandma.getGrandchildren().getFirst(), dad.getChildren().getFirst());
    }

}
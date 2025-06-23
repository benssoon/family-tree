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
        Person mom = new Person("Dorothy", "Lee", "f", 69);
        Person dad = new Person("David", "Zelinsky", "m", 69);

        //act:
        mom.addChild(ben);
        dad.addChild(ben);

        //assert:
        assertSame(mom, ben.getMother());
        assertSame(dad, ben.getFather());
    }

    @Test
    public void testThatChildIsChildOfParents() {
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Dorothy", "Lee", "f", 69);
        Person dad = new Person("David", "Zelinsky", "m", 69);

        ben.addParents(dad, mom);

        assertSame(ben, mom.getChildren().getLast());
    }

    @Test
    public void testThatMotherIsMother() {
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Dorothy", "Lee", "f", 69);
        Person dad = new Person("David", "Zelinsky", "m", 69);

        ben.addParents(dad, mom);

        assertSame(mom, ben.getMother());
    }

    @Test
    public void testThatFatherIsFather() {
        Person ben = new Person("Ben", "Zelinsky", "m", 33);
        Person mom = new Person("Dorothy", "Lee", "f", 69);
        Person dad = new Person("David", "Zelinsky", "m", 69);

        ben.addParents(dad, mom);

        assertSame(dad, ben.getFather());
    }

}
package nl.novi.familytree;

import java.util.*;

public class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<>();
    private List<Person> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();


    // ---------- Constructors ---------- //
    public Person(String firstName, String lastName, String sex, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String firstName, String middleName, String lastName, String sex, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    // ---------- Getters & Setters ---------- //

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return this.mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return this.father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getSiblings() {
        return this.siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }


    // ---------- Methods ---------- //
    public void addParents(Person parent, Person otherParent) {
        parent.addChild(this);
        otherParent.addChild(this);
    }

    public void addChild(Person child) {
        this.children.add(child);
        switch (this.getSex()) {
            case "m": // This person is male and therefore the father of child.
                child.setFather(this);
                break;
            case "f": // This person is female and therefore the mother of child.
                child.setMother(this);
                break;
        }
    }

    public void addPet(Pet pet) {
        this.pets.add(pet);
        pet.setOwner(this);
    }

    public void addSibling(Person sibling) {
        this.siblings.add(sibling);
        sibling.getSiblings().add(this);
        sibling.addParents(this.mother, this.father); // Ik twijfel af en toe over of ik een getter moet gebruiken terwijl ik nog in dezelfde class zit. Hoeft in principe niet, toch?
    }

    public List<Person> getGrandchildren() {
        List<Person> grandchildren = new ArrayList<>();
        for (Person child : this.children) {
            grandchildren.addAll(child.getChildren());
        }
        return grandchildren;
    }

}

package nl.novi.familytree;

public class Pet {
    private String name;
    private int age;
    private String species;
    private Person owner;

    // ---------- Constructor ---------- //

    public Pet(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }


    // ---------- Getters & Setters ---------- //

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Person getOwner() {
        return this.owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }


    // ---------- Methods ---------- //
}

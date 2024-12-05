package org.example.a_02_coctails;

public class Cocktail {
    private String name;
    private String image;
    private String instructions;

    public Cocktail(String name, String image, String instructions) {
        this.name = name;
        this.image = image;
        this.instructions = instructions;
    }

    public String getName() { return name; }
    public String getImage() { return image; }
    public String getInstructions() { return instructions; }
}

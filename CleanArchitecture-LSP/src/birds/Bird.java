package birds;

public class Bird {

    private String color;
    private String breed;
    public Bird() {
        this.color = "";
        this.breed = "";

    }

    public Bird(String color, String breed) {
        this.color = color;
        this.breed = breed;
    }

    public void layingEggs() {
        System.out.println("Bird lays egg!");
    }

}

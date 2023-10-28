public class Robot extends Unit {

    protected int numberOfMissiles = 6;
    public Robot(String name) {
        super(name);
        this.power = 15;
        this.defence = 30;
        this.health = 100;
    }
}

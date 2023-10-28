public class Knight extends Unit {

    protected int numberOfHeals = 3;
    public Knight(String name) {
        super(name);
        this.power = 10;
        this.defence = 15;
        this.health = 150;
    }
}

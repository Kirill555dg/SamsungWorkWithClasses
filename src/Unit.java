public class Unit {

    protected String name = null;
    protected int health = 100;
    protected int defence = 0;
    protected int power = 0;

    public Unit(String name) {
        Game.countOfPlayers++;
        this.name = name;
    }

    public void attackTo(Unit unit){
        unit.takeDamage(power);
    }
    public void takeDamage(int damage){
        this.health -= damage;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "health=" + health +
                ", defence=" + defence +
                ", power=" + power +
                '}';
    }

    public void print(){
        System.out.println(this);
    }
    public void print(String str){
        System.out.println(str + this);
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

}

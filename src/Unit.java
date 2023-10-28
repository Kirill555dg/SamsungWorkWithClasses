public class Unit {

    protected String name = null;
    protected int health = 100;
    protected int defence = 30;
    protected int power = 10;
    protected float criticalDamageChance = 0.1f;
    protected float parryChance = 0.2f;

    public Unit() {
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

    public float getCriticalDamageChance() {
        return criticalDamageChance;
    }

    public void setCriticalDamageChance(float criticalDamageChance) {
        this.criticalDamageChance = criticalDamageChance;
    }

    public float getParryChance() {
        return parryChance;
    }

    public void setParryChance(float parryChance) {
        this.parryChance = parryChance;
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
    public Unit(String name) {
        Game.countOfPlayers++;
        this.name = name;
    }
    public Unit(int health, int defence, int power) {
        Game.countOfPlayers++;
        this.health = health;
        this.defence = defence;
        this.power = power;
    }

    public void print(){
        System.out.println(this);
    }
    public void print(String str){
        System.out.println(str + this);
    }
}

public class Wizard extends Unit{

    protected int mana = 100;

    @Override
    public void attackTo(Unit unit) {
        mana -= 10;
        if (mana <= 0) {
            System.out.println("Нет маны на атаку!");
            mana += 5;
            return;
        }
        unit.takeDamage(power*2);
    }

    public Wizard(String name) {
        super(name);
    }

    public Wizard() {

    }

    @Override
    public String toString() {
        return "Wizard{" +
                "mana=" + mana +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", defence=" + defence +
                ", power=" + power +
                '}';
    }
}

public class Terminator extends Unit{
    protected int rockets = 4;
    protected float defDecrease = 0.8f;
    public Terminator(String unitName) {
        name = "Терминатор " + unitName;
        power = 10;
        defence = 25;
        CriticalChance = 0.6f;
        ParryChance = 0.16f;
    }
    public void rocketShot(Unit unit) {
        rockets--;
        System.out.println(this.name + " атакует ракетами " + unit.name + ", пытаясь нанести урон: " + power * 3);
        System.out.println("Ракет осталось: " + rockets);
        unit.takeDamage(power * 3);
    }
    public void weakening(Unit unit) {
        System.out.println("Броня " + name + " снижена: " + (int) ((1 - defDecrease) * 100) + "%");
        unit.setDefence((int) (unit.getDefence() * defDecrease));
    }
    @Override
    public void attack(Unit unit) {
        if (rockets > 0) {
            rocketShot(unit);
        }
        else {
            super.attack(unit);
        }
    }

    @Override
    public void addConcentration(){
        concentration += 25;
    }

    @Override
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        for (Unit enemy : RivalUnits) {
            if (enemy.isAlive()) this.weakening(enemy);
        }
        super.ultimate(PlayerUnits, RivalUnits);
    }

    @Override
    public String toString() {
        return super.toString() + ", Ракеты - " + rockets;
    }
}
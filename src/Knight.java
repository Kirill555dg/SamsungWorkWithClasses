public class Knight extends Unit{
    protected int healrate = 20;
    public Knight(String unitName) {
        name = "Рыцарь " + unitName;
        health = 125;
        CriticalChance = 0.3f;
        ParryChance = 0.2f;
    }
    public void healing(Unit unit) {
        unit.takeHealing(healrate);
    }
    @Override
    public void addConcentration(){
        concentration += 34;
    }
    @Override
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        for (Unit teammate : PlayerUnits) {
            if (teammate.isAlive()) this.healing(teammate);
        }
        super.ultimate(PlayerUnits, RivalUnits);
    }
}
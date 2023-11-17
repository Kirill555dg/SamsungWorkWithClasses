public class Wizard extends Unit{
    protected int mana = 100;
    protected int spellcost = 10;
    public Wizard(String unitName) {
        name = "Маг " + unitName;
        power = 35;
        defence = 0;
        CriticalChance = 0.05f;
        ParryChance = 0.05f;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack(Unit unit) {
        if (mana >= spellcost) {
            System.out.println("Потрачено маны - " + spellcost);
            super.attack(unit);
            mana -= spellcost;
        } else {
            spellcost *= (int)(spellcost*2.5);
            System.out.println("Недостаточно маны. Восполнено " + spellcost + " маны.");
        }
    }

    @Override
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        if (spellcost >= 25) spellcost -= 25;
        else spellcost = 0;
        for (Unit enemy : RivalUnits) {
            if (enemy.isAlive()) enemy.takeDamage(power / 2);
        }
        super.ultimate(PlayerUnits, RivalUnits);
    }

    @Override
    public String toString() {
        return super.toString() + ", Мана - " + mana;
    }
}
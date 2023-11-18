public class Unit {
    Util util = new Util();
    protected String name = "Персонаж";
    protected boolean Alive = true;
    protected int health = 100;
    protected int MAX_HEALTH = health;
    protected boolean canUltimate = false;
    protected int concentration = 0;
    protected int defence = 10;
    protected int power = 15;
    protected float CriticalChance = 0.1f;
    protected float ParryChance = 0.1f;

    public boolean isAlive() {
        return Alive;
    }
    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isCanUltimate() {
        return canUltimate;
    }

    public void setCanUltimate(boolean canUltimate) {
        this.canUltimate = canUltimate;
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

    public float getCriticalChance() {
        return CriticalChance;
    }

    public void setCriticalChance(float criticalChance) {
        CriticalChance = criticalChance;
    }

    public float getParryChance() {
        return ParryChance;
    }

    public void setParryChance(float parryChance) {
        ParryChance = parryChance;
    }

    public void attack(Unit unit) {
        int damage = util.criticalHitCheck(power, CriticalChance);
        System.out.println(this.name + " атакует " + unit.name + ", пытаясь нанести урон: " + damage);
        if (damage > power) {
            System.out.println("Критический удар!");
        }
        unit.takeDamage(damage);
        getUlt();
    }

    public void addConcentration(){
        concentration += 50;
    }
    public void getUlt(){
        if (!canUltimate) {
            addConcentration();
            if (concentration >= 100){
                System.out.println("Обретена концентрация");
                this.canUltimate = true;
                concentration = 0;
            }
        }
    }
    public void ultimate(Unit[] PlayerUnits, Unit[] RivalUnits) {
        this.canUltimate = false;
        System.out.println("Концентрация потрачена");
    }
    public void takeDamage(int damage) {
        damage = util.resistance(damage, defence);
        damage = util.parryCheck(damage, ParryChance);
        this.health -= damage;
        System.out.println(name + " - получено урона: " + damage);
        if (damage == 0) {
            System.out.println("Успешное парирование!");
        }
        if (this.health <= 0) {
            this.health = 0;
            this.Alive = false;
            System.out.println(this.name + " погиб...");
        }
    }
    public void takeHealing(int hprec) {
        if (hprec + health >= MAX_HEALTH) {
            hprec = MAX_HEALTH - health;
        }
        health += hprec;
        System.out.println(name + " восстановил здоровье: " + hprec);

    }
    public String toString() {
        return name + ": Здоровье - " + health + ", Концентрация - " + (canUltimate ? "Полная" : concentration + "%");
    }
}
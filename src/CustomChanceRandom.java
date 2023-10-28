import java.util.Random;

public class CustomChanceRandom {

    private int criticalHitChance = 10;

    private int parryChance = 20;

    boolean isCriticalHit(){
        Random rnd = new Random();
        int attempt = rnd.nextInt(100);
        return attempt < this.criticalHitChance;
    }

    boolean isParry(){
        Random rnd = new Random();
        int attempt = rnd.nextInt(100);
        return attempt < this.parryChance;
    }

    public int getCriticalHitChance() {
        return criticalHitChance;
    }

    public void setCriticalHitChance(int criticalHitChance) {
        this.criticalHitChance = criticalHitChance;
    }

    public int getParryChance() {
        return parryChance;
    }

    public void setParryChance(int parryChance) {
        this.parryChance = parryChance;
    }
}

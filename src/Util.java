import java.util.Random;

public class Util {
    Random random = new Random();
    public int criticalHitCheck(int value, float chance) {
        if (chance > Math.abs(random.nextFloat())) {
            value *= 2;
        }
        return value;
    }

    public int parryCheck(int value, float chance) {
        if (chance > Math.abs(random.nextFloat())) {
            return 0;
        }
        return value;
    }

    public int resistance(int value, int coef) {
        value -= value * (coef) / 100;
        return value;
    }
}

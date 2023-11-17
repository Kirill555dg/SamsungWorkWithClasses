import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    private static final int countOfPlayers = 2;
    private static final Player[] players = new Player[countOfPlayers];
    private static final Scanner inp = new Scanner(System.in);
    public static void startGame(){
        Scenary.greeting();
        for (int i = 0; i < countOfPlayers; i++) {
            Scenary.choiceName();
            players[i] = makePlayer();
            Scenary.choiceGameMode();
            setGameMode(players[i]);
            Scenary.choiceUnits();
            choiseUnits(players[i]);
            if (i != countOfPlayers-1) Scenary.nextPlayerChoose();
        }
    }

    public static Player makePlayer(){
        String name = inp.nextLine();
        return new Player(name);
    }

    public static void choiseUnits(Player player){
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++){
            int n = intInput();
            nums[i] = n;
        }
        inp.nextLine();
        Unit[] units = player.getUnits();
        for (int i = 0; i < units.length; i++) {
            switch (nums[i]){
                case(1):
                    System.out.println("Введите прозвище вашего рыцаря: ");
                    units[i] = new Knight(inp.nextLine());
                    break;
                case(2):
                    System.out.println("Введите прозвище вашего терминатора: ");
                    units[i] = new Terminator(inp.nextLine());
                    break;
                case(3):
                    System.out.println("Введите прозвище вашего мага: ");
                    units[i] = new Wizard(inp.nextLine());
                    break;
                default:
                    System.out.println("Вы не нашли такого воина, однако к вам пришел рыцарь!\nВведите прозвище вашего подопечного: ");
                    units[i] = new Knight(inp.nextLine());
                    break;
            }
        }
        player.setUnits(units);
    }
    public static int intInput(){
        int num;
        do {
            num = inp.nextInt();
            if (num < 1 || num > 3) Scenary.reNumber();
        } while (num < 1 || num > 3);
        return num;
    }
    public static void setGameMode(Player player){
        int mode = inp.nextInt();
        player.setGameMode(mode);
    }

    public static void fighting(){
        Random rand = new Random();
        int curInd = rand.nextInt(countOfPlayers);
        Player enemy, curPlayer = players[curInd];
        Scenary.startFight(curPlayer.getName());
        while (true){
            curPlayer = players[curInd];
            Scenary.newTurn(curPlayer.getName());
            if (curInd == countOfPlayers-1) curInd = 0;
            else curInd++;

            enemy = players[curInd];
            Scenary.enemyInfo(enemy);
            Scenary.choiceUnit(curPlayer);
            Unit curUnit = setUnit(curPlayer);
            if (curUnit.isCanUltimate()) {
                Scenary.choiceAction();
                int actionId = inp.nextInt();
                if (actionId == 2) {
                    curUnit.ultimate(curPlayer.getUnits(), enemy.getUnits());
                } else {
                    toAttack(curUnit, enemy);
                }
            } else {
                toAttack(curUnit, enemy);
            }
            if (checkGameOver(enemy)) return;
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void toAttack(Unit attacker, Player defender){
        Scenary.choiceTarget();
        Unit def = setUnit(defender);
        attacker.attack(def);
    }

    public static Unit setUnit(Player player){
        Unit unit;
        int n = intInput();
        do {
            unit = player.chooseUnit(n - 1);
            if (!unit.isAlive()) Scenary.reChoice();
        } while (!unit.isAlive());
        return unit;
    }
    public static boolean checkGameOver(Player player){
        player.setLiveUnits(0);
        for (int u = 0; u < 3; u++) {
            if (player.chooseUnit(u).isAlive()) {
                player.setLiveUnits(player.getLiveUnits()+1);
            }
        }
        if (player.getLiveUnits() == 0) {
            player.setCanPlay(false);
            Scenary.gameOver(player.getName());
            return true;
        }
        return false;
    }
    public static void endGame(){
        for (Player player : players){
            if (player.isCanPlay()) {
                Scenary.theEnd(player.getName());
            }
        }
    }
}

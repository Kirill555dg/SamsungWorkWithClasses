import java.util.Scanner;
public class Player {

    private String name = "Noname";
    private int gameMode = 0;
    private Unit[] units = new Unit[3];
    private int liveUnits = 3;

    private boolean canPlay = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public Unit[] getUnits() {
        return units;
    }

    public void setUnits(Unit[] units) {
        this.units = units;
    }

    public int getLiveUnits() {
        return liveUnits;
    }

    public void setLiveUnits(int liveUnits) {
        this.liveUnits = liveUnits;
    }

    public boolean isCanPlay() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public Player(String name){
        this.name = name;
    }

    public void printUnitsParameters(){
        for (Unit unit : units) {
            System.out.println("\t" + unit);
        }
    }

    public Unit chooseUnit(int ind){
        return units[ind];
    }

}

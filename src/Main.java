public class Main {
    public static void main(String[] args) {
        Game game1 = new Game();
        Unit unit1 = new Unit("Human");
        Unit unit2 = new Unit("Animal");
        Unit specialUnit = new Unit(50,100,70);

        Wizard wizard1 = new Wizard("Holop");


        System.out.println(Game.countOfPlayers);
   }
}

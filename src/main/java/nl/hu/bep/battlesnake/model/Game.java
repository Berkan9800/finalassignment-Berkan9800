package nl.hu.bep.battlesnake.model;

import nl.hu.bep.battlesnake.webservices.UiterlijkResource;

public class Game {
    private static Game deGame;

    public static Game getDeGame() {
        return deGame;
    }

    public static void setDeGame(Game deGame) {
        Game.deGame = deGame;
    }




}

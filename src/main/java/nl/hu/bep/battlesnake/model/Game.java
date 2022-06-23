package nl.hu.bep.battlesnake.model;

public class Game {
    private static int aantalBochtjesNaarLinks;

    public static void setAantalBochtjesNaarLinks(int aantalBochtjesNaarLinks) {
        Game.aantalBochtjesNaarLinks = aantalBochtjesNaarLinks;
    }

    public static int getAantalBochtjesNaarLinks() {
        return aantalBochtjesNaarLinks;
    }
}

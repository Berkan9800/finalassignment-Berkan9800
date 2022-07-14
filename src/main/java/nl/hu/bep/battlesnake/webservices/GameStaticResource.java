package nl.hu.bep.battlesnake.webservices;

import nl.hu.bep.battlesnake.model.GameStatics;

class GameStaticResponse {
    public int aantalTurns;

    public GameStaticResponse(int aantalTurns) {
        this.aantalTurns = aantalTurns;
    }
}


class GameStaticRequest {
    public int aantalTurns;

}




package nl.hu.bep.battlesnake.webservices;


import nl.hu.bep.battlesnake.model.GameInfo;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Map;


class MoveResponse {
    public String move;
    public String shout;

    public MoveResponse(String move, String shout) {
        this.move = move;
        this.shout = shout;
    }
}

class BattlesnakeRequest {
    public int turn;
    public Map<String, Object> you;
    public Map<String, Object> board;
    public Map<String, Object> game;
}

@Path("/snake")
public class BattlesnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfo() {
        GameInfo information = new GameInfo();
        information.setAuthor("berkangurel");

        return Response.ok(information).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response startGame() {
        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response moveGame(BattlesnakeRequest request) {
        int height = (int) request.board.get("height");
        int width = (int) request.board.get("width");
        boolean uitkomst = true;
        while (uitkomst == true) {
            if (height == 10) {
                MoveResponse move = new MoveResponse("up", "Going up!");
                return Response.ok(move).build();
            } else if (height == 2) {
                MoveResponse move = new MoveResponse("down", "Going down!");
                return Response.ok(move).build();
            } else if (width == 2) {
                MoveResponse move = new MoveResponse("right", "Going right!");
                return Response.ok(move).build();
            } else if (width == 10) {
                MoveResponse move = new MoveResponse("left", "Going left!");
                return Response.ok(move).build();
            }

        }
        MoveResponse move = new MoveResponse("left", "Going down!");
        return Response.ok(move).build();
    }



    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endGame() {
        return Response.ok().build();
    }





}

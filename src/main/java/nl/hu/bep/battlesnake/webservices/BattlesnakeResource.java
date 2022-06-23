package nl.hu.bep.battlesnake.webservices;


import nl.hu.bep.battlesnake.model.GameInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int turn = request.turn;


        Object head = request.you.get("head").toString();

        String headString = (String) head;

        MoveResponse moveUp = new MoveResponse("up", "going up!");
        MoveResponse moveDown = new MoveResponse("down", "going down!");
        MoveResponse moveLeft = new MoveResponse("left", "going left!");
        MoveResponse moveRight = new MoveResponse("right", "going right!");


//        if (headString.equals("{x=0, y=1}") || headString.equals("{x=1, y=1}") || headString.equals("{x=2, y=1}") || headString.equals("{x=3, y=1}") || headString.equals("{x=4, y=1}") || headString.equals("{x=5, y=1}") || headString.equals("{x=6, y=1}") || headString.equals("{x=7, y=1}") || headString.equals("{x=8, y=1}") || headString.equals("{x=9, y=1}") || headString.equals("{x=10, y=1}")){
//            return Response.ok(moveUp).build();
//        }
//
//        if (headString.equals("{x=0, y=10}") || headString.equals("{x=1, y=10}") || headString.equals("{x=2, y=10}") || headString.equals("{x=3, y=10}") || headString.equals("{x=4, y=10}") || headString.equals("{x=5, y=10}") || headString.equals("{x=6, y=10}") || headString.equals("{x=7, y=10}") || headString.equals("{x=8, y=10}") || headString.equals("{x=9, y=10}") || headString.equals("{x=10, y=10}")){
//            return Response.ok(moveDown).build();
//        } else {
//            return Response.ok(moveUp).build();
//        }

        if (turn == 0) {
            return Response.ok(moveDown).build();
        }
        if (turn == 2) {
            return Response.ok(moveLeft).build();
        }
        if (turn == 3) {
            return Response.ok(moveUp).build();
        }
        if (turn == 4) {
            return Response.ok(moveRight).build();
        }

        return Response.ok(moveUp).build();







    }



    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endGame() {
        return Response.ok().build();
    }





}

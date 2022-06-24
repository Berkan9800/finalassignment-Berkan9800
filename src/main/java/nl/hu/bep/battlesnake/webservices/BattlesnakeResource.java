package nl.hu.bep.battlesnake.webservices;


import nl.hu.bep.battlesnake.model.GameInfo;
import nl.hu.bep.battlesnake.model.Snake;

import javax.print.attribute.standard.Media;
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
        information.setAuthor("berkan gurel");

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

        int turn = request.turn;

        MoveResponse moveUp = new MoveResponse("up", "going up!");
        MoveResponse moveDown = new MoveResponse("down", "going down!");
        MoveResponse moveLeft = new MoveResponse("left", "going left!");
        MoveResponse moveRight = new MoveResponse("right", "going right!");

        if (turn < 3) {
            return Response.ok(moveUp).build();
        } else {
            return Response.ok(moveLeft).build();
        }

    }



    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response endGame() {
        return Response.ok().build();
    }


    @PUT
    @Path("{updatedSnake}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSnake(@PathParam("updatedSnake")String uD, @FormParam("color")String cl, @FormParam("tail")String tl, @FormParam("head")String hd) {
        Snake snake = new Snake(uD, cl, tl, hd);
        Snake updatedSnake = Snake.updateSnake(snake);

        return Response.ok(updatedSnake).build();
    }




}

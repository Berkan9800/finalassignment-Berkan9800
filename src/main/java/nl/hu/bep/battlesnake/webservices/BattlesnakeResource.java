package nl.hu.bep.battlesnake.webservices;


import nl.hu.bep.battlesnake.model.GameInfo;
import nl.hu.bep.battlesnake.model.GameStatics;
import nl.hu.bep.battlesnake.model.SnakeApi;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        GameInfo info = SnakeApi.getApiService().getInformation();
        return Response.ok(info).build();
    }

    @GET
    @Path("{gamestaticssinglegame}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaticsSingleGame(@PathParam("gamestaticssinglegame") String id) {
        GameStatics gameStatics = SnakeApi.getApiService().getStaticsSingleGame(id);
        return Response.ok(gameStatics).build();
    }

    @GET
    @Path("gamestaticsallgames")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaticsAllGames() {
        GameStatics gameStatics = SnakeApi.getApiService().getStaticsAllGames();
        return Response.ok(gameStatics).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateGameInfo(UiterlijkRequest req) {
        GameInfo info = SnakeApi.getApiService().getInformation();

        info.setColor(req.color);
        info.setTail(req.tail);
        info.setHead(req.head);

        return Response.ok(info).build();
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
    public Response endGame(GameStaticRequest req) {
        int aantalTurns = req.aantalTurns;
        return Response.ok().build();
    }







}

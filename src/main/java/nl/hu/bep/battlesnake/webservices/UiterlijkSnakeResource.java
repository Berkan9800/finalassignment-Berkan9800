package nl.hu.bep.battlesnake.webservices;


import nl.hu.bep.battlesnake.model.UiterlijkSnake;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/uiterlijk")
public class UiterlijkSnakeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUiterlijk() {
        UiterlijkSnake uiterlijk = new UiterlijkSnake();
        uiterlijk.setColor("red");
        uiterlijk.setHead("evil");
        uiterlijk.setTail("small-rattle");
        return Response.ok(uiterlijk).build();
    }
}

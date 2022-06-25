package nl.hu.bep.battlesnake.webservices;


import nl.hu.bep.battlesnake.model.Snake;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/updatedSnake")
public class UiterlijkResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response createNewSnake(@FormParam("color")String cl, @FormParam("head")String hd, @FormParam("tail")String tl) {
        Snake snake = new Snake(cl, hd, tl);

        return Response.ok(snake).build();

    }
}

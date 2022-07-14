package nl.hu.bep.battlesnake.webservices;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

class UiterlijkResponse {
    public String color;
    public String head;
    public String tail;

    public UiterlijkResponse(String color, String head, String tail) {
        this.color = color;
        this.head = head;
        this.tail = tail;
    }
}


class UiterlijkRequest {
    public String color;
    public String head;
    public String tail;

}




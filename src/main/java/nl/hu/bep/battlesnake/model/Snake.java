package nl.hu.bep.battlesnake.model;

public class Snake {
    public static Snake updateSnake(Snake updateData) {
        return updateData;
    }

    public String color;
    public String head;
    public String tail;

    public Snake(String ud, String cl, String hd, String tl){
        this.color = cl;
        this.head = hd;
        this.tail = tl;
    }
}

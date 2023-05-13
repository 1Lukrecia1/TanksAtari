package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Obj {
    protected int MS;
    protected int HP;

    public int getHP() {
        return HP;
    }

    protected int PosX;
    protected int PosY;

    protected String type;

    protected String picture;
    protected GraphicsContext gc;
    public String getType() {
        return type;
    }
    public boolean isDead(int damageTaken){
        HP = HP - damageTaken;
        return HP <= 0;
    }
    public int getPosX() {
        return PosX;
    }
    public int getPosY() {
        return PosY;
    }
    public void draw(){
        gc.drawImage(new Image(picture), PosX, PosY);
    }
}
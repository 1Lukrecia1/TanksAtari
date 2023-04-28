package game;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Model {
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    private final ArrayList<Tanks> tanks = new ArrayList<Tanks>();
    boolean isStart;
    private  ArrayList<ArrayList<Integer>> bricsCoords =  new ArrayList<ArrayList<Integer>>(); //[[],[],[]]
    private final Bricks bricks;
    private GraphicsContext gc;
    private final Tanks player1;


    public Model(boolean isStart, GraphicsContext gc) {
        this.bricks = new Bricks("", gc, null);
        player1 = new Tanks(100, 1, 20, gc, 1, 100, 100, this);
        this.isStart = isStart;
    }


    public void drawWalls() {
        bricks.draw();
    }


    public void update(){
        ArrayList<Bullet> newBuletsArr = new ArrayList<Bullet>();
        for(Bullet bullet : bullets){
            if(bullet.isInScreen()) {
                bullet.update();
                newBuletsArr.add(bullet);
                continue;
            }
        }
        bullets = newBuletsArr;
    }


    public void addBullet(Bullet bullet){
        bullets.add(bullet);
    }


    public ArrayList<Bullet> getBullets(){
        return bullets;
    }

    public boolean isCollisionForward(){
        for(Brick brick : bricks.getBricksClasses()){
            if ((((player1.getPosX() >= brick.getPosX()-1) && (player1.getPosX() <= brick.getPosX()+51)) || ((player1.getPosX() + 50 >= brick.getPosX()-1) && (player1.getPosX() + 50 <= brick.getPosX()+51))) &&
                    ((player1.getPosY() <= brick.getPosY()+51) && (player1.getPosY() >= brick.getPosY()+ 49)))return true;//((player1.getPosY() <= brick.getPosY()+51) && (player1.getPosY() >= brick.getPosY()))
        }
        return false;
    }

    public boolean isCollisionBackward(){
        for(Brick brick : bricks.getBricksClasses()){
            if ((((player1.getPosX() >= brick.getPosX()-1) && (player1.getPosX() <= brick.getPosX()+51)) || ((player1.getPosX() + 50 >= brick.getPosX()-1) && (player1.getPosX() + 50 <= brick.getPosX()+51))) &&
                    ((player1.getPosY()+50 <= brick.getPosY()) && (player1.getPosY() +50 >= brick.getPosY() - 1)))return true;//((player1.getPosY() <= brick.getPosY()+51) && (player1.getPosY() >= brick.getPosY()))
        }
        return false;
    }

    public boolean isCollisionLeft() {
        for (Brick brick : bricks.getBricksClasses()) {
            if ((((player1.getPosY() >= brick.getPosY()) && (player1.getPosY() <= brick.getPosY() + 50)) || ((player1.getPosY() + 50 >= brick.getPosY()) && (player1.getPosY() + 50 <= brick.getPosY() + 50))) &&
                    ((player1.getPosX() <= brick.getPosX() + 51) && (player1.getPosX() >= brick.getPosX() + 49)))
                return true;//((player1.getPosY() <= brick.getPosY()+51) && (player1.getPosY() >= brick.getPosY()))
        }
        return false;
    }

    public boolean isCollisionRight() {
        for (Brick brick : bricks.getBricksClasses()) {
            if ((((player1.getPosY() >= brick.getPosY()) && (player1.getPosY() <= brick.getPosY() + 50)) || ((player1.getPosY() + 50 >= brick.getPosY()) && (player1.getPosY() + 50 <= brick.getPosY() + 50))) &&
                    ((player1.getPosX()+ 50 <= brick.getPosX()+1) && (player1.getPosX() + 50 >= brick.getPosX() -1)))
                return true;//((player1.getPosY() <= brick.getPosY()+51) && (player1.getPosY() >= brick.getPosY()))
        }
        return false;
    }


    public Tanks getPlayer1() {
        return player1;
    }

}

package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    int playerNumber;
    private Characters character;
    private String name;
    private Picture standing;
    private Picture walking;
    private Picture punching;
    private Picture specialMove;
    private int health;
    int x;
    int y; // TODO define

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    private static final int WALK_INC = 100;
    public Player(int playerNumber, Characters character){
        this.playerNumber = playerNumber;
        this.character = character;
        health = 10;
        y = 1000;
        standing = new Picture(x,y,character.getStandingGifFile());
        walking = new Picture(x,y,character.getStandingGifFile());
        punching = new Picture(x,y,character.getStandingGifFile());
        specialMove = new Picture(x,y,character.getStandingGifFile());
    }
    public void walk(){

    }
    public void punch(){

    }
    public void specialMove(){

    }
    public void hit(){

    }
    public void loseHealth(int amount){
        health -= amount;
    }
    public int getHealth() {
        return health;
    }
}

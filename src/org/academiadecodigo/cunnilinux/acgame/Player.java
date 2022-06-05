package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private int playerNumber;
    public int getPlayerNumber() {
        return playerNumber;
    }

    private Characters character;
    private int iChar;
    private String name;
    private String[] standingPicFiles;
    private String[] walkForwardPicFiles;
    private String[] walkBackwardPicFiles;
    private String[] punchPicFiles;
    private String[] specialMovePicFiles;
    private Picture[] standingPics;
    private Picture[] walkForwardPics;
    private Picture[] walkBackwardPics;
    private Picture[] punchPics;
    private Picture[] specialMovePics;
    private int health;
    private int x;
    private int y; // TODO define

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
        iChar = character.getiChar();
        health = 10;
        y = 1000;
        // STANDING PICS
        standingPicFiles = character.getStandingPicFiles(character.getiChar()).split(",");
        for (int i = 0; i < standingPicFiles.length; i++) {
            standingPics[i] = new Picture(x,y,standingPicFiles[i]);
        }
        // WALK FORWARD PICS
        walkForwardPicFiles = character.getStandingPicFiles(character.getiChar()).split(",");
        for (int i = 0; i < walkForwardPicFiles.length; i++) {
            walkForwardPics[i] = new Picture(x,y,walkForwardPicFiles[i]);
        }
        // WALK BACKWARD PICS
        walkBackwardPicFiles = character.getStandingPicFiles(character.getiChar()).split(",");
        for (int i = 0; i < walkBackwardPicFiles.length; i++) {
            walkBackwardPics[i] = new Picture(x,y,walkBackwardPicFiles[i]);
        }
        // PUNCH PICS
        punchPicFiles = character.getStandingPicFiles(character.getiChar()).split(",");
        for (int i = 0; i < punchPicFiles.length; i++) {
            punchPics[i] = new Picture(x,y,punchPicFiles[i]);
        }
        // SPECIAL MOVE PICS
        specialMovePicFiles = character.getStandingPicFiles(character.getiChar()).split(",");
        for (int i = 0; i < specialMovePicFiles.length; i++) {
            specialMovePics[i] = new Picture(x,y,specialMovePicFiles[i]);
        }
    }

    public void standing(){
        for (int i = 0; i < standingPics.length; i++) {
            standingPics[i].draw();
            Thread.sleep(Game.DELAY);
            standingPics[i].delete();
        }
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

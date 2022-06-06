package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {
    private int playerNumber;
    public int getPlayerNumber() {
        return playerNumber;
    }
    private boolean keepStanding = true;
    private Characters character;
    private int iChar;

    public int getiChar() {
        return iChar;
    }

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
    public Player(int playerNumber,int x, Characters character){
        this.playerNumber = playerNumber;
        this.x = x;
        this.character = character;
        iChar = character.getCharIndex();
        health = 10;
        y = 100;
        String picDir = "/Users/codecadet/repos/myrepo/academiacodigo/ac-game/src/org/academiadecodigo/cunnilinux/acgame/pics/";
        // STANDING PICS
        standingPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        standingPics = new Picture[standingPicFiles.length];
        for (int i = 0; i < standingPicFiles.length; i++) {
            standingPics[i] = new Picture(x,y,picDir + standingPicFiles[i]);
        }
/*        // WALK FORWARD PICS
        walkForwardPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        for (int i = 0; i < walkForwardPicFiles.length; i++) {
            walkForwardPics[i] = new Picture(x,y,walkForwardPicFiles[i]);
        }
        // WALK BACKWARD PICS
        walkBackwardPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        for (int i = 0; i < walkBackwardPicFiles.length; i++) {
            walkBackwardPics[i] = new Picture(x,y,walkBackwardPicFiles[i]);
        }
        // PUNCH PICS
        punchPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        for (int i = 0; i < punchPicFiles.length; i++) {
            punchPics[i] = new Picture(x,y,punchPicFiles[i]);
        }
        // SPECIAL MOVE PICS
        specialMovePicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        for (int i = 0; i < specialMovePicFiles.length; i++) {
            specialMovePics[i] = new Picture(x,y,specialMovePicFiles[i]);
        }*/
    }

    public void standing() throws InterruptedException {
        for (int i = 0; i < standingPics.length; i++) {
            standingPics[i].draw();
            Thread.sleep(Game.DELAY);
            standingPics[i].delete();
            if(i == standingPics.length-1 && keepStanding) i=0;
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

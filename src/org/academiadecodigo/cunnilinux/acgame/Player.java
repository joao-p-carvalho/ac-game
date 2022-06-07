package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.cunnilinux.acgame.WhatNow.PUNCH;
import static org.academiadecodigo.cunnilinux.acgame.WhatNow.STANDING;

public class Player {
    private Player opponent;

    private int iterator = 0;

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    private int prevIteration;

    private int playerNumber;
    private WhatNow whatNow;

    public WhatNow getWhatNow() {
        return whatNow;
    }

    public void setWhatNow(WhatNow whatNow) {
        this.whatNow = whatNow;
    }

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

    private boolean isStanding;
    private boolean isWalkingForward;
    private boolean isWalkingBackward;
    private boolean isPunching;
    private boolean isDoingSpecial;
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

    private static final int WALK_INC = 50;

    public Player(int playerNumber, int x, Characters character,WhatNow whatNow) {
        this.playerNumber = playerNumber;
        this.x = x;
        this.character = character;
        this.whatNow = whatNow;
        iChar = character.getCharIndex();
        health = 10;
        y = 100;
        String picDir = "/Users/codecadet/repos/myrepo/academiacodigo/ac-game/src/org/academiadecodigo/cunnilinux/acgame/pics/";
        // STANDING PICS
        standingPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        standingPics = new Picture[standingPicFiles.length];
        for (int i = 0; i < standingPicFiles.length; i++) {
            standingPics[i] = new Picture(x, y, picDir + standingPicFiles[i]);
        }
        // PUNCH PICS
        punchPicFiles = character.getPunchPicFiles(character.getCharIndex()).split(",");
        punchPics = new Picture[punchPicFiles.length];
        for (int i = 0; i < punchPicFiles.length; i++) {
            punchPics[i] = new Picture(x, y,picDir + punchPicFiles[i]);
        }

/*        // WALK FORWARD PICS
        walkForwardPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        walkForwardPics = new Picture[walkForwardPicFiles.length];
        for (int i = 0; i < walkForwardPicFiles.length; i++) {
            walkForwardPics[i] = new Picture(x,y, picDir + walkForwardPicFiles[i]);
        }
        // WALK BACKWARD PICS
        walkBackwardPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        walkBackwardPics = new Picture[walkBackwardPicFiles.length];
        for (int i = 0; i < walkBackwardPicFiles.length; i++) {
            walkBackwardPics[i] = new Picture(x,y, picDir + walkBackwardPicFiles[i]);
        }
        // SPECIAL MOVE PICS
        specialMovePicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        specialMovePics = new Picture[specialMovePicFiles.length];
        for (int i = 0; i < specialMovePicFiles.length; i++) {
            specialMovePics[i] = new Picture(x,y, picDir + specialMovePicFiles[i]);
        }*/
    }

    public boolean isLoopEnd(Picture[] picSequence) {
        return iterator == picSequence.length - 1;
    }

    public void iteReset(Picture[] picSequence) {
        if (isLoopEnd(picSequence)) iterator = 0;
    }

    public void showStanding() throws InterruptedException {
        standingPics[iterator].draw();
        prevIteration = iterator;
        iterator++;
        iteReset(standingPics);
    }

    public void hideStanding() throws InterruptedException {
        standingPics[prevIteration].delete();
    }

   public void movePics(Picture[] pics,int distance){
       for (int i = 0; i < pics.length; i++) {
           pics[i].translate(distance, 0);
       }
   }

    public void walkForward() {
        int distance = WALK_INC;
        if (playerNumber == 2) distance = -WALK_INC;
        movePics(standingPics,distance);
    }

    public void walkBackward() {
        int distance = -WALK_INC;
        if (playerNumber == 2) distance = WALK_INC;
        movePics(standingPics,distance);
    }

    public void showAction() throws InterruptedException {
        switch (whatNow) {
            case STANDING:
                standingPics[iterator].draw();
                break;
            case WALKBACKWARD:
                standingPics[iterator].draw();
                walkBackward();
                break;
            case WALKFORWARD:
                standingPics[iterator].draw();
                walkForward();
                break;
            case PUNCH:
                punchPics[iterator].draw();
        }
        prevIteration = iterator;
        iterator++;
        iteReset(standingPics);
    }

    public void hideAction() throws InterruptedException {
        switch (whatNow) {
            case STANDING:
                standingPics[iterator].delete();
                break;
            case WALKBACKWARD:
                standingPics[iterator].delete();
                walkBackward();
                break;
            case WALKFORWARD:
                standingPics[iterator].delete();
                walkForward();
                break;
            case PUNCH:
                punchPics[iterator].delete();
        }
    }

    public void specialMove() {

    }

    public void gotHit() {

    }

    public void hit() {

    }

    public void loseHealth(int amount) {
        health -= amount;
    }

    public int getHealth() {
        return health;
    }
}

package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.cunnilinux.acgame.Move.STANDING;

public class Player {
    private int playerNumber;
    private Characters character;
    private int health;
    private int x;
    private int y;
    private Move currentMove;
    private Move previousMove;
    private Player opponent;
    private int iterator;
    private int prevIteration;
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
    public int getPlayerNumber() {
        return playerNumber;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getIterator() {
        return iterator;
    }
    public void setIterator(int iterator) {
        this.iterator = iterator;
    }
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
    public Player getOpponent() {
        return opponent;
    }
    public int opponentDistance(){
        return Math.abs(x-opponent.getX());
    }
    public void setPrevIteration(int prevIteration) {
        this.prevIteration = prevIteration;
    }
    public int getPrevIteration() {
        return prevIteration;
    }
    public Move getCurrentMove() {
        return currentMove;
    }
    public void setCurrentMove(Move move) {
        this.currentMove = move;
        //iterator = 0;
    }
    private static final int WALK_INC = 40;

    ///////////////////////////////////////////////
    /////////        CONSTRUCTOR        ///////////
    ///////////////////////////////////////////////
    public Player(int playerNumber, int x, Characters character) {
        this.playerNumber = playerNumber;
        //opponent = playerNumber==1 ? ;  : 1;
        this.x = x;
        this.character = character;
        this.currentMove = STANDING;
        this.previousMove = currentMove;
        iterator = 0;
        int iChar = character.getCharIndex();
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
            punchPics[i] = new Picture(x, y, picDir + punchPicFiles[i]);
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


    public boolean isMoveEnd() {
        return iterator >= getCurrentMovePics().length - 1;
    }

    public void resetIterator() {
        if (isMoveEnd()) iterator = 0;
    }

    public Move getPreviousMove() {
        return previousMove;
    }

    public void moveAllPics(int distance) {
        for (int i = 0; i < standingPics.length; i++) {
            standingPics[i].translate(distance, 0);
        }
        for (int i = 0; i < punchPics.length; i++) {
            punchPics[i].translate(distance, 0);
        }
/*       for (int i = 0; i < walkForwardPics.length; i++) {
           walkForwardPics[i].translate(distance, 0);
       }
       for (int i = 0; i < walkBackwardPics.length; i++) {
           walkBackwardPics[i].translate(distance, 0);
       }
       for (int i = 0; i < specialMovePics.length; i++) {
           specialMovePics[i].translate(distance, 0);
       }*/
    }
    public void punch(){

    }
    public void walkForward() {
        int distance = WALK_INC;
        if (playerNumber == 2) distance = -WALK_INC;
        moveAllPics(distance);
    }

    public void walkBackward() {
        int distance = -WALK_INC;
        if (playerNumber == 2) distance = WALK_INC;
        moveAllPics(distance);
    }

    public Picture[] getCurrentMovePics() {
        switch (currentMove) {
            case STANDING:
                return standingPics;
            case WALKBACKWARD:
                return standingPics;
            case WALKFORWARD:
                return standingPics;
            case PUNCH:
                return punchPics;
        }
        return null;
    }

    public void showCurrMovePic() throws InterruptedException {
        switch (currentMove) {
            case STANDING:
                standingPics[iterator].draw();
                break;
            case WALKBACKWARD:
                standingPics[iterator].draw();
                break;
            case WALKFORWARD:
                standingPics[iterator].draw();
                break;
            case PUNCH:
                punchPics[iterator].draw();
        }
        prevIteration = iterator;
        //iterator++;
        //iteReset();
    }

    public void hideMovePic(Move move, int i) {
        switch (move) {
            case STANDING:
                standingPics[i].delete();
                break;
            case WALKBACKWARD:
                standingPics[i].delete();
                break;
            case WALKFORWARD:
                standingPics[i].delete();
                break;
            case PUNCH:
                punchPics[i].delete();
        }
    }

    public void hideAllMovePics() {
        for (Move move : Move.values()) {
            for (int i = 0; i < iterator; i++) {
                hideMovePic(move, i);
                //System.out.println(move);
                //hideMovePic(previousMove,i);
            }
        }
        iterator = 0;
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

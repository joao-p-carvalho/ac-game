package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

import static org.academiadecodigo.cunnilinux.acgame.Move.*;

public class Player {
    private static final int XMIN = 0;
    private static final int XMAX = 1000;
    private int wbCounter;
    private int wfCounter;
    private int punchCounter;
    Robot keyboardArbiter = new Robot();
    private int playerNumber;
    private Characters character;
    private int health;
    // private int x;
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

    public int getLeftX() {
        return standingPics[0].getX();
    }

    public int getRightX() {
        return standingPics[0].getMaxX();
    }

    public int opponentDistance() {
        return playerNumber == 1 ? opponent.getLeftX() - getRightX() : getLeftX() - opponent.getRightX();
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
        wfCounter = 0;
        wbCounter = 0;
        punchCounter = 0;
        //iterator = 0;
    }


    private static final int WALK_INC = 25;

    ///////////////////////////////////////////////
    /////////        CONSTRUCTOR        ///////////
    ///////////////////////////////////////////////
    public Player(int playerNumber, int xInit, Characters character) throws AWTException {
        this.playerNumber = playerNumber;
        //opponent = playerNumber==1 ? ;  : 1;
        this.character = character;
        this.currentMove = STANDING;
        this.previousMove = currentMove;
        iterator = 0;
        wbCounter = 0;
        wfCounter = 0;
        punchCounter = 0;
        int iChar = character.getCharIndex();
        health = 10;
        int yInit = 100;
        String picDir = "/Users/codecadet/repos/myrepo/academiacodigo/ac-game/src/org/academiadecodigo/cunnilinux/acgame/pics/";
        // STANDING PICS
        standingPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        standingPics = new Picture[standingPicFiles.length];
        for (int i = 0; i < standingPicFiles.length; i++) {
            standingPics[i] = new Picture(xInit, yInit, picDir + standingPicFiles[i]);
        }
        // PUNCH PICS
        punchPicFiles = character.getPunchPicFiles(character.getCharIndex()).split(",");
        punchPics = new Picture[punchPicFiles.length];
        for (int i = 0; i < punchPicFiles.length; i++) {
            punchPics[i] = new Picture(xInit, yInit, picDir + punchPicFiles[i]);
        }
        // WALK FORWARD PICS
        walkForwardPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        walkForwardPics = new Picture[walkForwardPicFiles.length];
        for (int i = 0; i < walkForwardPicFiles.length; i++) {
            walkForwardPics[i] = new Picture(xInit, yInit, picDir + walkForwardPicFiles[i]);
        }
        // WALK BACKWARD PICS
        walkBackwardPicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        walkBackwardPics = new Picture[walkBackwardPicFiles.length];
        for (int i = 0; i < walkBackwardPicFiles.length; i++) {
            walkBackwardPics[i] = new Picture(xInit, yInit, picDir + walkBackwardPicFiles[i]);
        }
/*        // SPECIAL MOVE PICS
        specialMovePicFiles = character.getStandingPicFiles(character.getCharIndex()).split(",");
        specialMovePics = new Picture[specialMovePicFiles.length];
        for (int i = 0; i < specialMovePicFiles.length; i++) {
            specialMovePics[i] = new Picture(x,y, picDir + specialMovePicFiles[i]);
        }*/
    }


    public boolean isMoveEnd() {
        return iterator >= getCurrentMovePics().length - 1;
    }

    public void resetToStanding() {
        if (isMoveEnd()) iterator = 0;
        setCurrentMove(STANDING);
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
        for (int i = 0; i < walkForwardPics.length; i++) {
            walkForwardPics[i].translate(distance, 0);
        }
        for (int i = 0; i < walkBackwardPics.length; i++) {
            walkBackwardPics[i].translate(distance, 0);
        }
/*       for (int i = 0; i < specialMovePics.length; i++) {
           specialMovePics[i].translate(distance, 0);
       }*/
    }

    public void punch() {

    }

    public boolean crossingBoundaries() {
        return playerNumber == 1 ? getLeftX() <= XMIN : getRightX() >= XMAX;
    }

    public void resetPlayersPos() {

    }


    public void walkForward() throws InterruptedException {
        if (opponentDistance() <= 0) {
            walkBackward();
        } else if (iterator <= walkForwardPics.length - 1) {
            //for (int i = 0; i < 5; i++) {
            moveAllPics(WALK_INC * (playerNumber == 1 ? 1 : -1));
            System.out.println(opponentDistance());
            //Thread.sleep(10);
            //}
            //keyboardArbiter.keyRelease(playerNumber == 1 ? 68 : 37);
            //resetToStanding();
            //wfCounter++;
        }
    }// else //resetPlayersPos();


    public void walkBackward() throws InterruptedException {
        if (crossingBoundaries()) {
            walkForward();
        } else if (iterator <= walkBackwardPics.length - 1) {
            //for (int i = 0; i < 5; i++) {
            moveAllPics(WALK_INC * (playerNumber == 1 ? -1 : 1));
            System.out.println(opponentDistance());
            //Thread.sleep(10);
            //}
            //keyboardArbiter.keyRelease(playerNumber == 1 ? 65 : 39);
            //wbCounter++;
        }
    }

    public Picture[] getMovePics(Move move) {
        switch (move) {
            case STANDING:
                return standingPics;
            case WALKBACKWARD:
                return walkBackwardPics;
            case WALKFORWARD:
                return walkForwardPics;
            case PUNCH:
                return punchPics;
        }
        return null;
    }
    public Picture[] getCurrentMovePics() {
        return getMovePics(currentMove);
    }

    public void showCurrMovePic() throws InterruptedException {
        switch (currentMove) {
            case STANDING:
                standingPics[iterator].draw();
                break;
            case WALKBACKWARD:
                walkBackwardPics[iterator].draw();
                walkBackward();
                break;
            case WALKFORWARD:
                walkForwardPics[iterator].draw();
                walkForward();
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
                walkBackwardPics[i].delete();
                break;
            case WALKFORWARD:
                walkForwardPics[i].delete();
                break;
            case PUNCH:
                punchPics[i].delete();
        }
    }

    public void hideAllMovePics() {
        Move[] moves = {STANDING,WALKBACKWARD,WALKFORWARD,PUNCH};
        for (Move move : moves) {
            for (int i = 0; i < getMovePics(move).length; i++) {
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

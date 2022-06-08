package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import java.awt.*;
import java.util.Random;

import static org.academiadecodigo.cunnilinux.acgame.Move.STANDING;

public class Game {
    private boolean bothAlive = true;
    public static final long DELAY = 100;

    private Player player1;
    private Player player2;
    private Scenario scenario;

    Robot KeyboardArbiter = new Robot();

    public Game() throws InterruptedException, AWTException {
        // TODO PUT PLAYER & SCENARIO SELECTION MENUS
        //////////////////////////////////////////////////////////
        //////////              PLAYER 1              ////////////
        //////////////////////////////////////////////////////////
        player1 = new Player(1, 200, Characters.CHAR1);
        // player1.setOpponent(player2);
        //---------------------
        // KEYBOARD HANDLER
        KeyboardHandlerPlayer1 kbhP1 = new KeyboardHandlerPlayer1(player1);
        Keyboard keyboardP1 = new Keyboard(kbhP1);
        // KEY NUMBERS
        int[] keysP1 = {65, 87, 68, 83, 67};
        //---------------------
        // SET EVENT LISTENERS:
        // KEY PRESS
        KeyboardEvent[] kbEventsPressP1 = new KeyboardEvent[keysP1.length];
        for (int i = 0; i < keysP1.length; i++) {
            kbEventsPressP1[i] = new KeyboardEvent();
            kbEventsPressP1[i].setKey(keysP1[i]);
            kbEventsPressP1[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardP1.addEventListener(kbEventsPressP1[i]);
        }
        //---------------------
        // KEY RELEASE
        KeyboardEvent[] kbEventReleaseP1 = new KeyboardEvent[keysP1.length];
        for (int i = 0; i < keysP1.length; i++) {
            kbEventReleaseP1[i] = new KeyboardEvent();
            kbEventReleaseP1[i].setKey(keysP1[i]);
            kbEventReleaseP1[i].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboardP1.addEventListener(kbEventReleaseP1[i]);
        }
        ///////////////////////////////////////////////////////////
        //////////               PLAYER 2              ////////////
        ///////////////////////////////////////////////////////////
        player2 = new Player(2, 600, Characters.CHAR2);
        player1.setOpponent(player2);
        player2.setOpponent(player1);
        //---------------------
        // KEYBOARD HANDLER:
        KeyboardHandlerPlayer2 kbhP2 = new KeyboardHandlerPlayer2(player2);
        Keyboard keyboardP2 = new Keyboard(kbhP2);
        // KEY NUMBERS
        int[] keysP2 = {37, 38, 39, 40, 73};
        //---------------------
        // SET EVENT LISTENERS:
        // KEY PRESSED
        KeyboardEvent[] kbEventPressP2 = new KeyboardEvent[keysP2.length];
        for (int i = 0; i < keysP2.length; i++) {
            kbEventPressP2[i] = new KeyboardEvent();
            kbEventPressP2[i].setKey(keysP2[i]);
            kbEventPressP2[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardP2.addEventListener(kbEventPressP2[i]);
        }
        //---------------------
        // KEY RELEASE
        KeyboardEvent[] kbEventReleaseP2 = new KeyboardEvent[keysP2.length];
        for (int i = 0; i < keysP2.length; i++) {
            kbEventReleaseP2[i] = new KeyboardEvent();
            kbEventReleaseP2[i].setKey(keysP2[i]);
            kbEventReleaseP2[i].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboardP2.addEventListener(kbEventReleaseP2[i]);
        }

        //FrontPage startMenu = new FrontPage();
    }

    public void startFrontPage() {
        // FRONT PAGE - LOGO & MUSIC
        FrontPage frontPage = new FrontPage();
    }
    public void playerSelection() {

    }

    public void theFight() throws InterruptedException {

        while (bothAlive) {
            //----------------------------------------------------------------------------------------------------------
            // EACH MOVE IS A SEQUENCE OF PICTURES
            // KEYBOARD HANDLER IS DECIDING WHICH MOVE (PICTURE SEQUENCE) IS CURRENTLY SELECTED
            // ACCORDING TO THE KEY CONFIG WE MADE
            //----------------------------------------------------------------------------------------------------------

            // SO FOR EACH ITERATION <i> IN THIS LOOP (UNTIL ONE LOSES):

            // SHOW PICTURE <i> OF EACH PLAYER-CHARACTER CURRENT MOVE
            // RANDOM CHOICE OF WHICH PLAYER GETS SHOWN FIRST.
            // THIS IS A BIT SYMBOLIC BECAUSE IT DOESN'T MAKE MUCH DIFFERENCE
            boolean isP1First = new Random().nextBoolean();
            Player firstPlayer = isP1First ? player1 : player2;
            Player secondPlayer = firstPlayer.getOpponent();
            firstPlayer.showCurrMovePic();
            secondPlayer.showCurrMovePic();
            // THEN WAIT A SPLIT OF A SECOND
            Thread.sleep(DELAY);

            // THEN HIDE/DELETE THE PICTURE
            //hideMoveInstant();
            firstPlayer.hideMovePic( firstPlayer.getCurrentMove(), firstPlayer.getIterator());
            secondPlayer.hideMovePic( secondPlayer.getCurrentMove(), secondPlayer.getIterator());

            // AND FINALLY CHECK FOR EACH PLAYER IF IT'S THE FINAL PICTURE OF PUNCH OR SPECIAL MOVE
            // - IF SO: RESET <i> TO 0 AND CURRENT MOVE TO STANDING
            // - OTHERWISE: INCREMENT <i>
            iteratorManager();
            // TODO FOR JUMP OR ANY OTHER THAT REQUIRES THE KEY PRESSED :
            //player1.hideMovePic(player1.getPreviousMove(),player2.get);
            //player2.hideMovePic(player2.getPreviousMove(),player2.getIterator());

        }
    }


    public void showMoveInstant() throws InterruptedException {
        //player1.resetIterator();
        //player2.resetIterator();
        boolean whichPlayer = new Random().nextBoolean();
        if (whichPlayer) player1.showCurrMovePic();
        else player2.showCurrMovePic();
    }

    public void hideMoveInstant() {
        player1.hideMovePic(player1.getCurrentMove(), player1.getIterator());
        player2.hideMovePic(player2.getCurrentMove(), player2.getIterator());
    }

    public void iteratorManager() {
        Player[] players = {player1, player2};
        for (Player player : players) {
            if (player.isMoveEnd()) {
                player.setIterator(0);
                player.hideAllMovePics();
                switch (player.getCurrentMove()) {
                    case PUNCH:
                    case SPECIALMOVE:
                        player.setCurrentMove(STANDING);
                }
            } else
                //player.setPrevIteration(player.getIterator());
                player.setIterator(player.getIterator() + 1);
        }
    }

}

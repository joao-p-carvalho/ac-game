package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import static org.academiadecodigo.cunnilinux.acgame.WhatNow.STANDING;

public class Game {
    private boolean endFight = false;
    public static final long DELAY = 150;
    Player player1;
    Player player2;
    Scenario scenario;

    public Game() throws InterruptedException{
        // PLAYER SELECTION PANE
        // TODO PUT SELECTION MENU
        ///////////////////////////////////////////////////////
        //////////           PLAYER 1              ////////////
        ///////////////////////////////////////////////////////
        player1 = new Player(1,200,Characters.CHAR1,STANDING);
        player1.setOpponent(player2);
        KeyboardHandlerPlayer1 kbhP1 = new KeyboardHandlerPlayer1(player1);
        Keyboard keyboardP1 = new Keyboard(kbhP1);
        int[] cursorP1 = {65, 87, 68, 83, 67};
        // KEY PRESS
        KeyboardEvent[] kbEventsP1 = new KeyboardEvent[cursorP1.length];
        for (int i = 0; i < cursorP1.length; i++) {
            kbEventsP1[i] = new KeyboardEvent();
            kbEventsP1[i].setKey(cursorP1[i]);
            kbEventsP1[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardP1.addEventListener(kbEventsP1[i]);
        }
        // KEY RELEASE
        KeyboardEvent[] kbEventReleaseP1 = new KeyboardEvent[2];
        for (int i = 0; i < 2; i++) {
            kbEventReleaseP1[i] = new KeyboardEvent();
            kbEventReleaseP1[i].setKey(cursorP1[i]);
            kbEventReleaseP1[i].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboardP1.addEventListener(kbEventReleaseP1[i]);
        }
        ///////////////////////////////////////////////////////
        //////////           PLAYER 2              ////////////
        ///////////////////////////////////////////////////////
        player2 = new Player(2,600,Characters.CHAR2,STANDING);
        player2.setOpponent(player1);
        KeyboardHandlerPlayer2 kbhP2 = new KeyboardHandlerPlayer2(player2);
        Keyboard keyboardP2 = new Keyboard(kbhP2);
        int[] cursorP2 = {37, 38, 39, 40, 73};
        // KEY PRESS
        KeyboardEvent[] kbEventPressP2 = new KeyboardEvent[cursorP2.length];
        for (int i = 0; i < cursorP2.length; i++) {
            kbEventPressP2[i] = new KeyboardEvent();
            kbEventPressP2[i].setKey(cursorP2[i]);
            kbEventPressP2[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboardP2.addEventListener(kbEventPressP2[i]);
        }
        // KEY RELEASE
        KeyboardEvent[] kbEventReleaseP2 = new KeyboardEvent[2];
        for (int i = 0; i < 2; i++) {
            kbEventReleaseP2[i] = new KeyboardEvent();
            kbEventReleaseP2[i].setKey(cursorP2[i]);
            kbEventReleaseP2[i].setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboardP2.addEventListener(kbEventReleaseP2[i]);
        }

        //FrontPage startMenu = new FrontPage();
    }

    public void startFrontPage(){
        // FRONT PAGE - LOGO & MUSIC
        FrontPage frontPage = new FrontPage();
    }

    public void playerSelection(){

    }

    public void theFight() throws InterruptedException{
        while(!endFight) {
            //showActionPic

            player1.showAction();
            player2.showAction();
            Thread.sleep(DELAY);
            //hideActionPic
            player1.hideAction();
            player2.hideAction();

        }
    }

}

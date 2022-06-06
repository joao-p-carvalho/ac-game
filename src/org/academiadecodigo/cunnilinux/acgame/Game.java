package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {
    public static final long DELAY = 200;
    Player player1;
    Player player2;
    Scenario scenario;

    public Game() throws InterruptedException{
        // PLAYER SELECTION PANE
        // TODO PUT SELECTION MENU
        player1 = new Player(1,200,Characters.CHAR1);
        player2 = new Player(2,600,Characters.CHAR2);
        KeyboardHandlerPlayer1 kbhP1 = new KeyboardHandlerPlayer1(player1);
        KeyboardHandlerPlayer2 kbhP2 = new KeyboardHandlerPlayer2(player2);
        Keyboard keyboardP1 = new Keyboard(kbhP1);
        Keyboard keyboardP2 = new Keyboard(kbhP2);

        //FrontPage startMenu = new FrontPage();
    }

    public void startFrontPage(){
        // FRONT PAGE - LOGO & MUSIC
        FrontPage frontPage = new FrontPage();
    }

    public void playerSelection(){

    }

    public void start(){
       //StartMenu startMenu = new StartMenu();
    }

    public static void cursorAction(Player player, int option) {
        KeyboardHandlerPlayer1 kbhPlayer = new KeyboardHandlerPlayer1(player);
        Keyboard keyboard = new Keyboard(kbhPlayer);
        int[] cursor1 = {37, 38, 39, 40};
        int[] cursor2 = {65, 87, 68, 83};
        int[] cursor = new int[4];
        switch(option) {
            case 1:
                for (int i = 0; i < cursor.length; i++) cursor[i] = cursor1[i];
                break;
            case 2:
                for (int i = 0; i < cursor.length; i++) cursor[i] = cursor2[i];
        }
        KeyboardEvent[] kbEvents = new KeyboardEvent[cursor.length];
        for (int i = 0; i < kbEvents.length; i++) {
            kbEvents[i] = new KeyboardEvent();
            kbEvents[i].setKey(cursor[i]);
            kbEvents[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(kbEvents[i]);
        }
    }

}

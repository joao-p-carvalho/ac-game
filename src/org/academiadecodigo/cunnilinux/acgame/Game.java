package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {
    Player player1;
    Player player2;
    Scenario scenario;

    public Game(){
        player1 = new Player(1,Characters.CHAR1);
        player2 = new Player(2,Characters.CHAR2);
        StartMenu startMenu = new StartMenu();
    }


    public void start(){
       //StartMenu startMenu = new StartMenu();
    }

    public static void cursorAction(Player player, int option) {
        KeyboardHandlerPlayers kbhPlayer = new KeyboardHandlerPlayers(player);
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

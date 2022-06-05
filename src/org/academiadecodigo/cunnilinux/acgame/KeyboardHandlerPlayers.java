package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardHandlerPlayers implements KeyboardHandler {
    Player player;
    //Player player2;

    public KeyboardHandlerPlayers(Player player){

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case 37: //LEFT
            case 65: //A
                player.walk(direction.LEFT);
                //movable.translate(-10, 0);
                break;
            case 38: //UP
            case 87: //W
                player.walk(direction.);
                //movable.translate(0, -10);
                break;
            case 39: //RIGHT
            case 68: //D
                player.walk();
                //movable.translate(10, 0);
                break;
            case 40: //DOWN
            case 83: //S
                player.walk();
                //movable.translate(0, 10);

        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

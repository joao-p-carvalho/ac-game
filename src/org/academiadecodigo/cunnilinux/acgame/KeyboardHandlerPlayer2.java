package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardHandlerPlayer2 implements KeyboardHandler {
    Player player;
    public KeyboardHandlerPlayer2(Player player) {
        this.player = player;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case 37: //LEFT
                player.walkForwards();
                break;
            case 39: //RIGHT
                player.walkBackwards();
                break;
            case 73: // I
                player.punch();
                break;
            case 80: // P
                player.specialMove();
                //break;
            //case 79: // O
            //    player.kick();
            //    break;
            //case 38: //UP
            //    break;
            //case 83: //DOWN
            //    player.crouch();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

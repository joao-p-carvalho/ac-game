package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardHandlerPlayer1 implements KeyboardHandler {
    Player player;
    public KeyboardHandlerPlayer1(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case 65: // A
                player.walkBackwards();
                break;
            case 68: // D
                player.walkForwards();
                break;
            case 67: // C
                player.punch();
                break;
            case 66: // B
                player.specialMove();
                //break;
            //case 86: // V
            //    player.kick();
            //    break;
            //case 87: //W (UP)
            //    player.jump();
            //    break;
            //case 83: //S (DOWN)
            //    player.crouch();
        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        //switch(keyboardEvent.getKey()) {
        //    case 83: //S (DOWN)
        //        player.standing();
        //}
    }
}

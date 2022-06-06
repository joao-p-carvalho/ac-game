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
                //player.walkBackward();
                break;
            case 68: // D
                //player.walkForward();
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
        switch(keyboardEvent.getKey()) {
            case 65: // A: walk backward
            case 68: // D: walk forward
                //case 79: // V: KICK
                //case 38: // W: UP
                //case 83: // S: DOWN
                try {
                    player.standing();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            //break;
            //case 86: // V
            //    player.kick();
            //    break;
            //case 87: //UP
            //    break;
            //case 83: //DOWN
            //    player.crouch();
        }
    }
}

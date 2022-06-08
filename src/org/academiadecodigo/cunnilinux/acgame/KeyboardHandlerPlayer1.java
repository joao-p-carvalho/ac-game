package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.cunnilinux.acgame.Move.*;

public class KeyboardHandlerPlayer1 implements KeyboardHandler {
    Player player1;
    public KeyboardHandlerPlayer1(Player player) {
        this.player1 = player;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case 65: // A
                player1.setCurrentMove(WALKBACKWARD);
                break;
            case 68: // D
                player1.setCurrentMove(WALKFORWARD);
                break;
            case 67: // C
                player1.setCurrentMove(PUNCH);
                player1.punch();
                break;
            case 66: // B
                player1.setCurrentMove(SPECIALMOVE);
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
            case 65: // A
            case 68: // D
            case 67: // C
                //case 79: // V: KICK
                //case 38: // W: UP
                //case 83: // S: DOWN
                player1.hideAllMovePics();
                player1.setCurrentMove(STANDING);
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

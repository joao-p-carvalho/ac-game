package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import static org.academiadecodigo.cunnilinux.acgame.Move.*;

public class KeyboardHandlerPlayer2 implements KeyboardHandler {
    Player player2;
    public KeyboardHandlerPlayer2(Player player2) {
        this.player2 = player2;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch(keyboardEvent.getKey()) {
            case 37: // <-LEFT
                player2.setCurrentMove(WALKFORWARD);
                player2.walkForward();
                break;
            case 39: // ->RIGHT
                player2.setCurrentMove(WALKBACKWARD);
                player2.walkBackward();
                break;
            case 73: // I: PUNCH
                player2.setCurrentMove(PUNCH);
                //break;
            //case 80: // P
                //player2.setWhatNow(SPECIALMOVE);
                //break;*/
/*            case 37: // <-LEFT
                player.walkForward();
                break;
            case 39: // ->RIGHT
                player.walkBackward();
                break;
            case 73: // I: PUNCH
                player.punch();
                break;
            case 80: // P
                player.specialMove();
                //break;*/
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
        switch(keyboardEvent.getKey()) {
            case 37: // <- (LEFT ARROW):
            case 39: // -> (RIGTH ARROW):
            case 73:
                player2.hideAllMovePics();
                player2.setCurrentMove(STANDING);
            //case 79: // O: kick
            //case 38: // UP
            //case 83: // DOWN
                break;
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
}

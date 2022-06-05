package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu extends Background {
    private Picture starButton;
    boolean isStartPressed;

    public void setStartPressed(boolean startPressed) {
        isStartPressed = startPressed;
    }
    public StartMenu(){
        setPicture("");
    }
    //TODO listen to ENTER KEY to start start

}

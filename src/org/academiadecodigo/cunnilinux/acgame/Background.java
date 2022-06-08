package org.academiadecodigo.cunnilinux.acgame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {
    private int pictureX = 0;
    private int pictureY = 0;

    private Picture picture;

    public void setPicture(String pictureFile) {
        this.picture = new Picture(pictureX,pictureY,pictureFile);
    }

    //TODO medium version SOUND!!
}

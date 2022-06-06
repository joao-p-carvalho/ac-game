package org.academiadecodigo.cunnilinux.acgame;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game g = new Game();
        g.player1.standing();
        g.player2.standing();
        System.out.println(g.player1.getiChar());
        System.out.println(g.player2.getiChar());
    }
}

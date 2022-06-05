package org.academiadecodigo.cunnilinux.acgame;

public enum Scenarios {
    PASTO(0),DELMAN(1),CODEBREAK(2);

    int index;
    String backgroundGifFile;
    private String[] backgroundGifFiles = {
            "",
            "",
            ""
    };

    Scenarios(int index){
        backgroundGifFile = backgroundGifFiles[index];
    }
}

package org.academiadecodigo.cunnilinux.acgame;

public enum Characters {
    CHAR1(0),
    CHAR2(1),
    CHAR3(2),
    CHAR4(3);

    private int iChar;
    private String name;
    private String standingGifFile;
    private String walkingGifFile;
    private String punchingGifFile;
    private String specialMoveGifFile;
    private String[] nameC = {
            "PEDROGAS",
            "RODRIKILLER",
            "FASHION MIKE",
            "JONNY OAK"
    };
    private String[] standingGifLocation = {
            "",
            "",
            "",
            ""
    };
    private String[] walkingGifLocation = {
            "",
            "",
            "",
            ""
    };
    private String[] punchingGifLocation = {
            "",
            "",
            "",
            ""
    };
    private String[] specialMoveGifLocation = {
            "",
            "",
            "",
            ""
    };

    public String getStandingGifFile() {
        return standingGifFile;
    }

    public String getWalkingGifFile() {
        return walkingGifFile;
    }

    public String getPunchingGifFile() {
        return punchingGifFile;
    }

    public String getSpecialMoveGifFile() {
        return specialMoveGifFile;
    }

    Characters(int iChar) {
        this.nameC = nameC;
        standingGifFile = standingGifLocation[iChar];
        standingGifFile = walkingGifLocation[iChar];
        standingGifFile = punchingGifLocation[iChar];
        standingGifFile = specialMoveGifLocation[iChar];
    }


}

package org.academiadecodigo.cunnilinux.acgame;

public enum Characters {
    CHAR1(0),
    CHAR2(1),
    CHAR3(2),
    CHAR4(3);

    private int charIndex;
    private String name;
    //private String[] standingPics;
    //private String walkingPics;
    //private String punchingGifFile;
    //private String specialMoveGifFile;
    private String[] characterNames = {
            "PEDROGAS",
            "RODRIKILLER",
            "FASHION MIKE",
            "JONNY OAK"
    };

    public int getCharIndex() {
        return charIndex;
    }
    //////////////////////////////////////////////////////////////////
    //   PICTURE SEQUENCES & GETTERS FOR EACH CHARACTER 0,1,2,3     //
    //////////////////////////////////////////////////////////////////

    //------------------------------//
    //           STANDING:          //
    //------------------------------//
    String standingPicsChar0 = "c0s0.png,c0s1.png,c0s2.png,c0s3.png,c0s4.png";
    String standingPicsChar1 = "c1s0.png,c1s1.png,c1s2.png,c1s3.png,c1s4.png,c1s5.png,c1s6.png";
    //String standingPicsChar2 = "c2s1.png,c2s2.png,c2s3.png,c2s4.png,c2s5.png,c2s6.png,c2s7.png,c2s8.png";
    //String standingPicsChar3 = "c3s1.png,c3s2.png,c3s3.png,c3s4.png,c3s5.png,c3s6.png,c3s7.png,c3s8.png";
    private String[] standingPics = {
            standingPicsChar0,
            standingPicsChar1
    //        standingPicsChar2,
    //        standingPicsChar3
    };
    public String getStandingPicFiles(int iChar) {
        return standingPics[iChar];
    }
    //------------------------------//
    //          WALK FORWARD:       //
    //------------------------------//
    String walkForwardPicsChar0 = "c0wf1.png,c0wf2.png,c0wf3.png,c0wf4.png,c0wf5.png,c0wf6.png,c0wf7.png,c0wf8.png";
    String walkForwardPicsChar1 = "c1wf1.png,c1wf2.png,c1wf3.png,c1wf4.png,c1wf5.png,c1wf6.png,c1wf7.png,c1wf8.png";
    String walkForwardPicsChar2 = "c2wf1.png,c2wf2.png,c2wf3.png,c2wf4.png,c2wf5.png,c2wf6.png,c2wf7.png,c2wf8.png";
    String walkForwardPicsChar3 = "c3wf1.png,c3wf2.png,c3wf3.png,c3wf4.png,c3wf5.png,c3wf6.png,c3wf7.png,c3wf8.png";
    private String[] walkForwardPics = {
            walkForwardPicsChar0,
            walkForwardPicsChar1,
            walkForwardPicsChar2,
            walkForwardPicsChar3
    };

    //------------------------------//
    //          WALK BACKWARD:      //
    //------------------------------//
    String walkBackwardPicsChar0 = "c0wb0.png,c0wb1.png,c0wb2.png,c0wb3.png,c0wb4.png,c0wb5.png,c0wb6.png,c0wb7.png,c0wb8.png";
    String walkBackwardPicsChar1 = "c1wb0.png,c1wb1.png,c1wb2.png,c1wb3.png,c1wb4.png,c1wb5.png,c1wb6.png,c1wb7.png,c1wb8.png";
    String walkBackwardPicsChar2 = "c2wb0.png,c2wb1.png,c2wb2.png,c2wb3.png,c2wb4.png,c2wb5.png,c2wb6.png,c2wb7.png,c2wb8.png";
    String walkBackwardPicsChar3 = "c3wb0.png,c3wb1.png,c3wb2.png,c3wb3.png,c3wb4.png,c3wb5.png,c3wb6.png,c3wb7.png,c3wb8.png";
    private String[] walkBackwardPics = {
            walkBackwardPicsChar0,
            walkBackwardPicsChar1,
            walkBackwardPicsChar2,
            walkBackwardPicsChar3
    };

    //------------------------------//
    //            PUNCH:            //
    //------------------------------//
    String specialMovePicsChar0 = "c0sm0.png,c0sm1.png,c0sm2.png,c0sm3.png,c0sm4.png,c0sm5.png,c0sm6.png,c0sm7.png,c0sm8.png";
    String specialMovePicsChar1 = "c1sm0.png,c1sm1.png,c1sm2.png,c1sm3.png,c1sm4.png,c1sm5.png,c1sm6.png,c1sm7.png,c1sm8.png";
    String specialMovePicsChar2 = "c2sm0.png,c2sm1.png,c2sm2.png,c2sm3.png,c2sm4.png,c2sm5.png,c2sm6.png,c2sm7.png,c2sm8.png";
    String specialMovePicsChar3 = "c3sm0.png,c3sm1.png,c3sm2.png,c3sm3.png,c3sm4.png,c3sm5.png,c3sm6.png,c3sm7.png,c3sm8.png";
    private String[] specialMovePics = {
            specialMovePicsChar0,
            specialMovePicsChar1,
            specialMovePicsChar2,
            specialMovePicsChar3
    };


    Characters(int charIndex) {
        this.charIndex = charIndex;
        this.characterNames = characterNames;
/*        for (int i = 0; i < standingPicsChar[iChar]. ; i++) {
            standingPic[i] = standingPicsChar[iChar][i];
            walkForwardPic[i] = walkForwardPicsChar[iChar][i];
            walkBackwardPic[i] = walkBackwardPicsChar[iChar][i];
            punchPic[i] = punchPicsChar[iChar][i];
            specialMovePic[i] = specialMovePicsChar[iChar][i];
        }*/
    }


}

package com.patrickmartin;

import de.umass.lastfm.Caller;


import java.util.Scanner;

public class PlayMaker {

    public static void main(String[] args) {
        Scanner userRating = new Scanner(System.in);



        Caller.getInstance().setUserAgent("tst");
        Caller.getInstance().setDebugMode(true);



        System.out.println("\n\nMajor Testing\n\n\n");

        UserPlaylist rapGuy1 = new  UserPlaylist("not_mario");
        UserPlaylist popPrincess = new  UserPlaylist("itscaioc");
        UserPlaylist rapGuy2 = new  UserPlaylist("iamygor");
        UserPlaylist popTwink = new  UserPlaylist("gbribeeiro");


        Jukebox testJuke1 = new Jukebox(rapGuy1);
        PandoraBae testJuke3 = new PandoraBae(rapGuy1, popPrincess);
        PandoraParty testJuke = new PandoraParty(rapGuy1, popPrincess,popTwink, rapGuy2);

        for (int i = 0; i < 7; i++){
            System.out.println("\nRun #" + (i));
            testJuke.playMusic();
            testJuke.printNowPlaying();
            testJuke.rateGuestTracks(userRating);
            testJuke.printTrackHistory();
        }





    }

}

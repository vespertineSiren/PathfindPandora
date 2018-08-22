package com.patrickmartin;
import de.umass.lastfm.Caller;

public class Test {

    public static void main(String[] args) {

        Caller.getInstance().setUserAgent("tst");
        Caller.getInstance().setDebugMode(true);




        System.out.println("\n\nMajor Testing\n\n\n");

         UserPlaylist rapGuy1 = new  UserPlaylist("not_mario");
         UserPlaylist popPrincess = new  UserPlaylist("itscaioc");
         UserPlaylist rapGuy2 = new  UserPlaylist("iamygor");
         UserPlaylist popTwink = new  UserPlaylist("gbribeeiro");


        //irstTest.displayTopTrack();

        //Jukebox testJuke = new Jukebox(rapGuy1);
        Jukebox testJuke1 = new Jukebox(rapGuy1);
        PandoraBae testJuke3 = new PandoraBae(rapGuy1, popPrincess);
        PandoraParty testJuke = new PandoraParty(rapGuy1, popPrincess,popTwink, rapGuy2);
        //System.out.println("Top Tracks: not_mario");
        //rapGuy1.displayTopTrack();

        //System.out.println("Top Tracks: itscaioc");
        //popPrincess.displayTopTrack();



        //for (int i = 0; i < 4; i++){
        System.out.println("\nRun #" + (1));
        testJuke.playMusic();
        testJuke.printNowPlaying();
        testJuke.printTrackHistory();
        //}

        //Test
        testJuke.showChanceTest();



    }
}

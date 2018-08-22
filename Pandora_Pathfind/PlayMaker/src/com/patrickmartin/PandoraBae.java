package com.patrickmartin;

import de.umass.lastfm.Track;

import java.util.ArrayList;
import java.util.Random;



public class PandoraBae extends Jukebox {

    private  UserPlaylist potentialBae;
    private int pbTracksQueued = 2;

    public PandoraBae( UserPlaylist primaryUser,  UserPlaylist potentialBae) {
        super(primaryUser);
        this.potentialBae = potentialBae;

    }

    /*
    Change the ArrayList<Track> to store username;
            potentialBae.getPriorityUser()
    ^ This will get the user name.
     */
    @Override
    public void playMusic() {
        Random r = new Random();
        float playChance = r.nextFloat();

//        ArrayList<Track> tempPrim = super.mainUser.queTracks(this.tracksQueued);
//        ArrayList<Track> tempPotential = potentialBae.queTracks(pbTracksQueued);

        //First run with an empty nowPlaying playlist
        if (super.nowPlaying.size() == 0) {

            ArrayList<Track> tempPrim = super.mainUser.queTracks(this.tracksQueued);
            ArrayList<Track> tempPotential = potentialBae.queTracks(pbTracksQueued);

            for (Track temp : tempPrim) {
                super.nowPlaying.add(temp);

                //Line below can commented out
                //System.out.println("Adding Track from " + mainUser.getPriorityUser());
            }

            for (Track temp : tempPotential) {
                super.nowPlaying.add(temp);

                //Line below can commented out
                //System.out.println("Adding Track from " + potentialBae.getPriorityUser());
            }

            //Random chance to primaryUsertrack to be added
            if (playChance <= .5f) {
               System.out.println("Final Track from: " + mainUser.getPriorityUser());
                Track mainUserTrack = (mainUser.queTracks(1)).get(0);
                super.nowPlaying.add(mainUserTrack);

            } else {
                System.out.println("Final Track from: " + potentialBae.getPriorityUser());
                Track baeTrack = (potentialBae.queTracks(1).get(0));
                super.nowPlaying.add(baeTrack);

            }

        //Following run with tracks in nowPlaying playlist
        } else {
            /*
            for (Track temp : super.nowPlaying) {
                super.trackHistory.add(temp);
            }

            super.nowPlaying.clear();
            for (Track temp : tempPrim) {
                super.nowPlaying.add(temp);
                super.tracksPlayed++;
                //Line below can commented out
                //System.out.println("Adding Track from " + mainUser.getPriorityUser());
            }

            for (Track temp : tempPotential) {
                super.nowPlaying.add(temp);
                super.tracksPlayed++;
                //Line below can commented out
                //System.out.println("Adding Track from " + potentialBae.getPriorityUser());
            }

            //Random chance to primaryUsertrack to be added
            if (playChance <= .5f) {
                System.out.println("Final Track from: " + mainUser.getPriorityUser());
                Track mainUserTrack = (mainUser.queTracks(1)).get(0);
                super.nowPlaying.add(mainUserTrack);
                super.tracksPlayed++;
            } else {
                System.out.println("Final Track from: " + potentialBae.getPriorityUser());
                Track baeTrack = (potentialBae.queTracks(1).get(0));
                super.nowPlaying.add(baeTrack);
                super.tracksPlayed++;
            }
            */
            for (Track temp : nowPlaying) {
                super.trackHistory.add(temp);
            }

            super.nowPlaying.clear();

            playMusic();


        }

    }

}

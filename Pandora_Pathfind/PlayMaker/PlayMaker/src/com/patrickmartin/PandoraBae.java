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

    @Override
    public void playMusic() {
        Random r = new Random();
        float playChance = r.nextFloat();

        //First run with an empty nowPlaying playlist
        if (super.nowPlaying.size() == 0) {

            ArrayList<Track> tempPrim = super.mainUser.queTracks(this.tracksQueued);
            ArrayList<Track> tempPotential = potentialBae.queTracks(pbTracksQueued);

            for (Track temp : tempPrim) {
                super.nowPlaying.add(temp);
            }

            for (Track temp : tempPotential) {
                super.nowPlaying.add(temp);
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

        } else {

            for (Track temp : nowPlaying) {
                super.trackHistory.add(temp);
            }

            super.nowPlaying.clear();

            playMusic();


        }

    }

}

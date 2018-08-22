package com.patrickmartin;

import de.umass.lastfm.Track;

import java.util.ArrayList;


public class Jukebox {

    protected UserPlaylist mainUser;
    protected int tracksQueued = 3;
    protected ArrayList<Track> nowPlaying = new ArrayList<>();
    protected ArrayList<Track> trackHistory = new ArrayList<>();


    public Jukebox(UserPlaylist primaryUser) {
        this.mainUser = primaryUser;
    }



    public void playMusic(){

        //ArrayList<Track> tempQue = mainUser.queTracks(tracksQueued);

        if (this.nowPlaying.size() == 0){
            ArrayList<Track> tempQue = mainUser.queTracks(tracksQueued);
            for (Track temp : tempQue) {
                this.nowPlaying.add(temp);

            }
        } else {

            for (Track temp : nowPlaying) {
                this.trackHistory.add(temp);
            }

            this.nowPlaying.clear();

            /*
            for (Track temp : tempQue) {
                this.nowPlaying.add(temp);
                tracksPlayed++;
            }
             */
            playMusic();
        }


    }

    public void printNowPlaying(){

        System.out.println("Now Playing: ");

        int trackNumber = 1;
        for (Track temp : nowPlaying) {
            System.out.println("Track #" + trackNumber + ": '" +
                    temp.getName() + "' by " + temp.getArtist() );
            trackNumber++;
        }

    }


    public void printTrackHistory(){

        int trackNumber = 1;
        if (this.trackHistory.size() > 0){
            System.out.println("History: ");
            for (Track temp : this.trackHistory) {
                System.out.println("Track #" + trackNumber + ": '" +
                        temp.getName() + "' by " + temp.getArtist() );
                trackNumber++;
            }
        }   else {
            System.out.println("\nNOTHING TO PRINT");
        }
    }

}

package com.patrickmartin;

import de.umass.lastfm.Track;

import java.util.ArrayList;


public class Jukebox {

    protected UserPlaylist mainUser;
    protected int tracksQueued = 3;
    protected ArrayList<Track> nowPlaying;
    protected ArrayList<Track> trackHistory;


    public Jukebox(UserPlaylist primaryUser) {
        this.mainUser = primaryUser;
        nowPlaying = new ArrayList<>();
        trackHistory = new ArrayList<>();
    }



    public void playMusic(){

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

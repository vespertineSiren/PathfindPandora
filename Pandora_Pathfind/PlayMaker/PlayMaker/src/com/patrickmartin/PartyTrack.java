package com.patrickmartin;
import de.umass.lastfm.Track;


public class PartyTrack {

    private String trackTitle;
    private String trackArtist;
    private String userName;



    public PartyTrack(Track song, String userName) {
        this.trackTitle = song.getName();
        this.trackArtist = song.getArtist();
        this.userName = userName;

    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public String getTrackArtist() {
        return trackArtist;
    }

    public String getUserName() {
        return userName;
    }
}

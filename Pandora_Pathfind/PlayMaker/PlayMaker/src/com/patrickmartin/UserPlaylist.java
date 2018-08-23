package com.patrickmartin;
import de.umass.lastfm.Track;
import de.umass.lastfm.User;

import java.util.ArrayList;
import java.util.Collection;


public class UserPlaylist {

    private String priorityUser;
    private static final String key = "ee4037a7eab45c0a2bdf1d56b971a20f";
    private ArrayList<Track> topTracksOrdered;
    private ArrayList<Track> upcomingTopTracks;
    private int currentTrack;
    private int playchance;


    UserPlaylist(String inputUser){
        this.priorityUser = inputUser;
        Collection<Track> topTracks = User.getTopTracks(this.priorityUser, key);
        this.topTracksOrdered = new ArrayList<>(topTracks);
        this.upcomingTopTracks = new ArrayList<>();
        this.currentTrack = 0;
        this.playchance = 100;

    }

    public void displayTopTrack(){
        int rankCounter = 1;
        for (Track currentTrack : this.topTracksOrdered) {
            System.out.println("Rank #" + rankCounter + ": '" +
                    currentTrack.getName() + "' by " + currentTrack.getArtist());
            rankCounter++;
        }

    }

    public ArrayList<Track> queTracks(int tracksNeeded) {

        if (this.upcomingTopTracks.size() > 0) {
            this.upcomingTopTracks.clear();
        }

        for( int i = 0; i < tracksNeeded; i++  ) {
            this.upcomingTopTracks.add(topTracksOrdered.get(this.currentTrack));
            this.currentTrack++;
        }

        return this.upcomingTopTracks;
    }

    public Track queTrack(){

        if (this.upcomingTopTracks.size() > 0) {
            this.upcomingTopTracks.clear();
        }

        Track singleTrack = topTracksOrdered.get(this.currentTrack);
        this.currentTrack++;


        return singleTrack;

    }

    public void alterPartyChance(int ranking) {

        this.playchance += ranking;

        if (this.playchance <= 0) {
            this.playchance = 50;
        }

    }

    public int getPlaychance() {
        return playchance;
    }

    public String getPriorityUser() {
        return priorityUser;
    }





}
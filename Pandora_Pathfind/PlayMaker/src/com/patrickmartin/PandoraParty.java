package com.patrickmartin;

import com.PartyTrack;
import de.umass.lastfm.Track;

import java.util.ArrayList;
import java.util.Collections;

public class PandoraParty extends Jukebox {



    private ArrayList< UserPlaylist> partyGuestsChance;
    private int partyGuestTracksQueued;
    private ArrayList<PartyTrack> partyNowPlaying = new ArrayList<>();
    private ArrayList<PartyTrack> partyHistory = new ArrayList<>();



    public PandoraParty(UserPlaylist primaryUser, UserPlaylist user1,  UserPlaylist user2,  UserPlaylist user3) {
        super(primaryUser);
        partyGuestsChance = new ArrayList<>();
        partyGuestsChance.add(user1);
        partyGuestsChance.add(user2);
        partyGuestsChance.add(user3);
        partyGuestTracksQueued = partyGuestsChance.size();
    }

    @Override
    public void playMusic() {
         if ((this.partyNowPlaying.size() == 0) && (this.partyHistory.size() == 0)){
             ArrayList<Track> tempTrackque = super.mainUser.queTracks(super.tracksQueued);
             for (Track temp : tempTrackque) {
                 partyNowPlaying.add(new PartyTrack(temp, super.mainUser.getPriorityUser()));
             }

         } else {

         }
    }

    private void rateGuestTracks(){

    }

    //TEST METHOD
    public void showChanceTest(){
        int guestIncrease = 50;
        for ( UserPlaylist add : partyGuestsChance) {
            add.alterPartyChance(guestIncrease);
            guestIncrease *= 2;
        }
        for ( UserPlaylist add : partyGuestsChance) {
            System.out.println(add.getPriorityUser() + "'s Chance: " + add.getPlaychance());
        }
        System.out.println("-----");
        Collections.sort(partyGuestsChance, new SortChance());
        for ( UserPlaylist add : partyGuestsChance) {
            System.out.println(add.getPriorityUser() + "'s Chance: " + add.getPlaychance());
        }
        System.out.println("-----");
        Collections.reverse(partyGuestsChance);
        for ( UserPlaylist add : partyGuestsChance) {
            System.out.println(add.getPriorityUser() + "'s Chance: " + add.getPlaychance());
        }

    }

    @Override
    public void printNowPlaying() {
        System.out.println("Now Playing ");
        int trackNumber = 1;
        for (PartyTrack temp : partyNowPlaying){
            System.out.println("Track #" + trackNumber + "(" + temp.getUserName() + "): '" +
                    temp.getTrackTitle() + "' by " + temp.getTrackArtist() );
            trackNumber++;
        }
    }

    @Override
    public void printTrackHistory() {
        super.printTrackHistory();
    }

    //Must take a minimum of 3 users


    //Include algorithm for the party.


}

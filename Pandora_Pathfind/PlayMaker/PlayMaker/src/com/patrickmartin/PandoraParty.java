package com.patrickmartin;

import de.umass.lastfm.Track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PandoraParty extends Jukebox {



    private ArrayList<UserPlaylist> partyGuestsChance;
    private int partyGuestTracksQueued;
    private ArrayList<PartyTrack> partyNowPlaying;
    private ArrayList<PartyTrack> partyHistory;
    private ArrayList<PartyTrack> partyTracksToRate;


    public PandoraParty(UserPlaylist primaryUser, UserPlaylist user1,  UserPlaylist user2,  UserPlaylist user3) {
        super(primaryUser);
        partyGuestsChance = new ArrayList<>();
        partyGuestsChance.add(user1);
        partyGuestsChance.add(user2);
        partyGuestsChance.add(user3);
        partyGuestTracksQueued = partyGuestsChance.size();
        partyNowPlaying = new ArrayList<>();
        partyHistory = new ArrayList<>();
        partyTracksToRate = new ArrayList<>();

    }

    @Override
    public void playMusic() {

        if (this.partyNowPlaying.size() == 0){
            ArrayList<Track> mainTrackque = super.mainUser.queTracks(super.tracksQueued);
            for (Track temp : mainTrackque) {
                this.partyNowPlaying.add(new PartyTrack(temp, super.mainUser.getPriorityUser()));
            }
            System.out.println("Size of Partytrackstorate: " + this.partyTracksToRate.size());
            //Logic to place UserTracks in nowPlaying. no rating will be done.
            if (this.partyTracksToRate.size() == 0) {
                //initial run pulling one track from each user then placing in history
                for (UserPlaylist guest : partyGuestsChance) {
                    Track convert = guest.queTrack();
                    PartyTrack initialAddPT = new PartyTrack(convert, guest.getPriorityUser());
                    this.partyNowPlaying.add(initialAddPT);
                    this.partyTracksToRate.add(initialAddPT);
                }

            } else {

                this.partyTracksToRate.clear();
                guestTrackGenerator();
            }
        } else {
            for (PartyTrack pastTrack : partyNowPlaying) {
                this.partyHistory.add(pastTrack);
            }

            this.partyNowPlaying.clear();

            this.playMusic();
        }

    }

    public void rateGuestTracks(Scanner rating){
        int chanceChange;
        int ratingChoice;
        UserPlaylist userAlter;

        for ( UserPlaylist add : partyGuestsChance) {
            System.out.println(add.getPriorityUser() + "'s Chance: " + add.getPlaychance());
        }

        //ratings will alter the playChance
        for (PartyTrack ratingTrack : partyTracksToRate) {
            //Displays track info
            System.out.println("\nRating " + ratingTrack.getUserName() + "'s track:\n" +
                    "'" + ratingTrack.getTrackTitle() + "' by " + ratingTrack.getTrackArtist() +
                    "\n   Press 1 to Like or 0 to Dislike the track." +
                    "\n   Any other number will not like or dislike. ");

            //Logic to find user and alterchance based on users input.
            ratingChoice = rating.nextInt();
            if (ratingChoice == 1) {
                chanceChange = 40;
                for (int i = 0; i < this.partyGuestTracksQueued; i++){
                    if (ratingTrack.getUserName() == partyGuestsChance.get(i).getPriorityUser()){
                        partyGuestsChance.get(i).alterPartyChance(chanceChange);
                        break;
                    }
                }

            } else if (ratingChoice == 0) {
                chanceChange = -20;
                for (int i = 0; i < this.partyGuestTracksQueued; i++){
                    if (ratingTrack.getUserName() == partyGuestsChance.get(i).getPriorityUser()){
                        partyGuestsChance.get(i).alterPartyChance(chanceChange);
                        break;
                    }
                }
            } else {

            }

        }

        Collections.sort(partyGuestsChance, new SortChance());
        Collections.reverse(partyGuestsChance);

    }

    private void guestTrackGenerator() {
        int maxChancerange = 0;
        int playChance;
        int playChanceRange = 0;
        int tracks = 0;


        for (UserPlaylist temp : partyGuestsChance) {
            maxChancerange += temp.getPlaychance();
        }


        while (tracks < partyGuestTracksQueued) {
            playChance = ThreadLocalRandom.current().nextInt(1, maxChancerange);
            System.out.println("This is the playchance: " + playChance);
            playChanceRange = 0;
            for (UserPlaylist temp : partyGuestsChance){
                playChanceRange += temp.getPlaychance();
                System.out.println("This is the range: 0 to " + playChanceRange + " (" + temp.getPriorityUser() + ")");
                if (playChance <= playChanceRange) {
                    Track convert = temp.queTrack();
                    PartyTrack initialAddPT = new PartyTrack(convert, temp.getPriorityUser());
                    this.partyNowPlaying.add(initialAddPT);
                    this.partyTracksToRate.add(initialAddPT);
                    tracks++;
                    break;
                }
            }
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
        int trackNumber = 1;
        if (partyHistory.size() > 0){
            System.out.println("History: ");
            for (PartyTrack temp : partyHistory) {
                System.out.println("Track #" + trackNumber + "(" + temp.getUserName() + "): '" +
                        temp.getTrackTitle() + "' by " + temp.getTrackArtist() );
                trackNumber++;
            }
        }   else {
            System.out.println("\nNOTHING TO PRINT");
        }
    }

}

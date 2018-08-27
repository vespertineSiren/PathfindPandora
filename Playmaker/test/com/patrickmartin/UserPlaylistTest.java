package com.patrickmartin;

import de.umass.lastfm.Caller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserPlaylistTest {

    private Jukebox rapGuy1;


    @Before
    public void setup(){
        Caller.getInstance().setUserAgent("tst");
        Caller.getInstance().setDebugMode(true);

        String testGuy = "not_mario";
        UserPlaylist rapGuy1 = new  UserPlaylist(testGuy);

    }

    @Test
    public void displayTopTrack() {


    }

    @Test
    public void queTracks() {
    }

    @Test
    public void queTrack() {
    }

    @Test
    public void alterPartyChance() {
    }

    @Test
    public void getPlaychance() {
    }

    @Test
    public void getPriorityUser() {
    }

    @After
    public void breakdown(){
        rapGuy1 = null;
    }

}
package com.patrickmartin;
import de.umass.lastfm.Caller;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import static org.junit.Assert.*;


//@FixMethodOrder
public class PandoraPartyTest {
    private PandoraParty testJuke;
    private UserPlaylist rapGuy1;

    @Before
    public void setup(){

        Caller.getInstance().setUserAgent("tst");
        Caller.getInstance().setDebugMode(true);

        String testGuy = "not_mario";
        rapGuy1 = new  UserPlaylist(testGuy);
        UserPlaylist popPrincess = new  UserPlaylist("itscaioc");
        UserPlaylist rapGuy2 = new  UserPlaylist("iamygor");
        UserPlaylist popTwink = new  UserPlaylist("gbribeeiro");
        testJuke = new PandoraParty(rapGuy1, popPrincess,popTwink, rapGuy2);


    }

    @Test
    public void test1InitialPlayThrough() {
        testJuke.playMusic();
        int numberofTracks = testJuke.getSizeOFpartyNowPlaying();
        assertEquals(6, numberofTracks);

    }

    @Test
    public void testPlayChanceifitgoesbelow0() {
        rapGuy1.alterPartyChance(-200);
        int playChance = rapGuy1.getPlaychance();
        assertEquals(50, playChance);

    }


    @After
    public void breakdown(){
        testJuke = null;
    }
}
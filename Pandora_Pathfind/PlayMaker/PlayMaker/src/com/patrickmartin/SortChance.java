package com.patrickmartin;
import java.util.Comparator;

public class SortChance implements Comparator< UserPlaylist> {

    public int compare( UserPlaylist a,  UserPlaylist b) {
        return (a.getPlaychance() - b.getPlaychance());
    }

}

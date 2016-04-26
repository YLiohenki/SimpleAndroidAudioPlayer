package com.example.nastassia.simpleandroidaudioplayer;

import java.util.ArrayList;

public class SoundsDescriptions {
    protected ArrayList<Sound> SoundsStore = new ArrayList<Sound>();
    public SoundsDescriptions()
    {
        Sound sound = new Sound();
        sound.FileId = R.raw.bensoundbrazilsamba;
        sound.Description = "Samba is a Brazilian musical\n" +
                "genre and dance style, with its\n" +
                "roots in Africa via the West\n" +
                "African slave trade and African\n" +
                "religious traditions, particularly\n" +
                "of Angola";
        sound.Country = "Brazil";
        sound.LengthMinutes = 4;
        sound.LengthSeconds = 0;
        sound.Name = "bensoundbrazilsamba";
        SoundsStore.add(sound);
        sound = new Sound();
        sound.FileId = R.raw.bensoundcountryboy;
        sound.Description = "Country music is a genre of\n" +
                "American popular music that\n" +
                "originated in the Southern\n" +
                "United States in the 1920s";
        sound.Country = "Brazil";
        sound.LengthMinutes = 3;
        sound.LengthSeconds = 27;
        sound.Name = "bensoundcountryboy";
        SoundsStore.add(sound);
    }

    public Sound getSound(int index)
    {
        return SoundsStore.get(index);
    }
}

package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound
{
    Clip clip;
    URL[] soundURL = new URL[20];

    public Sound()
    {
        soundURL[0] = getClass().getResource("/res/sound/Game_Sound.wav");
        soundURL[1] = getClass().getResource("/res/sound/Pickup_Key.wav");
        soundURL[2] = getClass().getResource("/res/sound/Open_Door.wav");
        soundURL[3] = getClass().getResource("/res/sound/Open_Chest.wav");
        soundURL[4] = getClass().getResource("/res/sound/Speed_Up.wav");
        soundURL[5] = getClass().getResource("/res/sound/Closed_Door.wav");
        soundURL[6] = getClass().getResource("/res/sound/Teleport.wav");
        soundURL[7] = getClass().getResource("/res/sound/Zombie.wav");
        soundURL[8] = getClass().getResource("/res/sound/Hurt.wav");
        soundURL[9] = getClass().getResource("/res/sound/Death.wav");
        soundURL[10] = getClass().getResource("/res/sound/Welcome.wav");
        soundURL[11] = getClass().getResource("/res/sound/Click.wav");
        soundURL[12] = getClass().getResource("/res/sound/Kiss.wav");
        soundURL[13] = getClass().getResource("/res/sound/Victory_Fanfare.wav");
    }

    /**
     * Method for slecting the sound file
     * @param i number of the file
     */
    public void setFile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }
        catch (Exception e)
        {

        }
    }

    /**
     * method for playing the sound
     */
    public void play()
    {
        clip.start();
    }

    /**
     * method for continuous loop
     */
    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * method for stopping the sound
     */
    public void stop()
    {
        clip.stop();
    }
}

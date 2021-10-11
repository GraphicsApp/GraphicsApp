package de.ur.mi.oop.audio;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Die AudioClip-Klasse repräsentiert eine abspielbare Audiodatei. Die Klasse erlaubt die Wiedergabe von
 * JAVA-kompatiblen Formaten (WAV oder AU).
 */

// TODO Implement AudioClipPool for parallel playback of individual sounds
public class AudioClip implements LineListener {

    private Clip clip;
    private boolean isReady = false;

    /**
     * Erzeugt ein neues AudioClip-Objekt und initalisiert den Clip über das Java AudioSystem
     *
     * @param filePath Relativer oder absoluter Pfad zur abzuspielenden Audiodatei
     */
    public AudioClip(String filePath) {
        this.clip = getClip(filePath);
        if(this.clip != null) {
            isReady = true;
            this.clip.addLineListener(this);
        }
    }

    private Clip getClip(String filePath) {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream in = AudioSystem.getAudioInputStream(new File(filePath));
            clip.open(in);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Startet die Wiedergabe (Nur möglich, wenn der Clip aktuell nicht wiedergegeben wird)
     */
    public void play() {
        if(isReady) {
            clip.start();
            isReady = false;
        }
    }

    /**
     * Startet die Wiedergabe als Dauerschleife (Nur möglich, wenn der Clip aktuell nicht wiedergegeben wird)
     */
    public void loop() {
        if(isReady) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            isReady = false;
        }
    }

    /**
     * Stoppt die aktuelle Wiedergabe oder Wiedergabeschleife.
     */
    public void stop() {
        clip.stop();
    }

    @Override
    public void update(LineEvent lineEvent) {
        // TODO Check if stop events are reliably retrieved on non-windows systems
        if(lineEvent.getType() == LineEvent.Type.STOP) {
            clip.setFramePosition(0);
            isReady = true;
        }
    }
}

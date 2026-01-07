package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
  Clip clip;
  Clip sfxClip; // Separate clip for sound effects
  Clip dialogueClip; // Separate clip for dialogue music
  URL soundURL[] = new URL[30]; 

  public Sound() {
    soundURL[0] = getClass().getResource("/res/sound/main.wav");
    soundURL[1] = getClass().getResource("/res/sound/grass.wav");
    soundURL[2] = getClass().getResource("/res/sound/pickup.wav");
    soundURL[3] = getClass().getResource("/res/sound/tile.wav");
    soundURL[4] = getClass().getResource("/res/sound/dialogue.wav");
  }

  public void setFile(int i){
    try {
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
      clip = AudioSystem.getClip();
      clip.open(ais);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void play(){
    clip.start();
  }

  public void loop(){
    clip.loop(Clip.LOOP_CONTINUOUSLY);
  }

  public void stop(){
    clip.stop();
  }
  
  // Play sound effect without interrupting music
  public void playSFX(int i) {
    try {
      // Stop and close previous sfx clip if it exists
      if (sfxClip != null) {
        if (sfxClip.isRunning()) {
          return; // Don't play if already playing a sound effect
        }
        sfxClip.close();
      }
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
      sfxClip = AudioSystem.getClip();
      sfxClip.open(ais);
      sfxClip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  // Dialogue music methods (separate clip so it doesn't interrupt main music)
  public void playDialogueMusic() {
    try {
      if (dialogueClip != null && dialogueClip.isRunning()) {
        return; // Already playing
      }
      AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[4]);
      dialogueClip = AudioSystem.getClip();
      dialogueClip.open(ais);
      dialogueClip.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public void stopDialogueMusic() {
    if (dialogueClip != null) {
      dialogueClip.stop();
      dialogueClip.close();
      dialogueClip = null;
    }
  }
}

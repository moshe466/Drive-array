package atlow.chemi.mymada.classes;

import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class Metronome {
    private static AudioGenerator audioGenerator = new AudioGenerator(8000);
    private static double[] soundTickArray = audioGenerator.getSineWave(1000, 8000, 9440.0d);
    private static double[] soundTockArray = audioGenerator.getSineWave(1000, 8000, 9350.0d);
    private static double[] silenceSoundArray = new double[3800];
    private boolean play = true;
    private int currentBeat = 1;

    public Metronome() {
        audioGenerator.createPlayer();
    }

    public void play() {
        do {
            if (this.currentBeat == 1) {
                try {
                    audioGenerator.writeSound(soundTockArray);
                } catch (Exception e) {
                    Crashlytics.logException(e);
                    e.printStackTrace();
                }
            } else {
                audioGenerator.writeSound(soundTickArray);
            }
            try {
                audioGenerator.writeSound(silenceSoundArray);
            } catch (Exception e2) {
                Crashlytics.logException(e2);
                e2.printStackTrace();
            }
            this.currentBeat++;
            if (this.currentBeat > 30) {
                this.currentBeat = 1;
            }
        } while (this.play);
    }

    public void stop() {
        this.play = false;
        audioGenerator.destroyAudioTrack();
    }
}

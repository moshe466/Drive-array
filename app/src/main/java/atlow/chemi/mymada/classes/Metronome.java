package atlow.chemi.mymada.classes;

import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class Metronome {
    private static final int SAMPLE_RATE = 44100;
    private static final int BPM = 110;
    private static final int TOTAL_BEAT_SAMPLES = (int) ((SAMPLE_RATE * 60.0) / BPM); // ~24054 samples

    private AudioGenerator audioGenerator;
    private byte[] tockPcm;
    private byte[] tickPcm;
    private volatile boolean play = true;
    private int currentBeat = 1;

    public Metronome() {
        this.audioGenerator = new AudioGenerator(SAMPLE_RATE);
        initSoundBuffers();
        this.audioGenerator.createPlayer();
    }

    private void initSoundBuffers() {
        double[] tock = new double[TOTAL_BEAT_SAMPLES];
        double[] tick = new double[TOTAL_BEAT_SAMPLES];

        // Accent beat 1 (1050 Hz crisp tone with 60ms envelope)
        int tockLen = (int) (SAMPLE_RATE * 0.060);
        for (int i = 0; i < tockLen && i < TOTAL_BEAT_SAMPLES; i++) {
            double decay = Math.exp(-i / (SAMPLE_RATE * 0.018));
            tock[i] = Math.sin(2.0 * Math.PI * 1050.0 * i / SAMPLE_RATE) * decay * 0.95;
        }

        // Standard beats 2-30 (800 Hz crisp tone with 40ms envelope)
        int tickLen = (int) (SAMPLE_RATE * 0.040);
        for (int i = 0; i < tickLen && i < TOTAL_BEAT_SAMPLES; i++) {
            double decay = Math.exp(-i / (SAMPLE_RATE * 0.012));
            tick[i] = Math.sin(2.0 * Math.PI * 800.0 * i / SAMPLE_RATE) * decay * 0.85;
        }

        this.tockPcm = this.audioGenerator.get16BitPcm(tock);
        this.tickPcm = this.audioGenerator.get16BitPcm(tick);
    }

    public void play() {
        this.play = true;
        this.currentBeat = 1;
        while (this.play) {
            try {
                if (this.currentBeat == 1) {
                    this.audioGenerator.writeSound(this.tockPcm);
                } else {
                    this.audioGenerator.writeSound(this.tickPcm);
                }
                this.currentBeat++;
                if (this.currentBeat > 30) {
                    this.currentBeat = 1;
                }
            } catch (Exception e) {
                Crashlytics.logException(e);
                e.printStackTrace();
                break;
            }
        }
    }

    public void stop() {
        this.play = false;
        if (this.audioGenerator != null) {
            this.audioGenerator.destroyAudioTrack();
        }
    }
}

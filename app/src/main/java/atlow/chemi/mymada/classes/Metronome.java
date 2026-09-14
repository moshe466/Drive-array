package atlow.chemi.mymada.classes;

import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class Metronome {
    private static final int SAMPLE_RATE = 44100;
    private static final double BPM = 110.0;
    private static final int TOTAL_BEAT_SAMPLES = (int) Math.round((SAMPLE_RATE * 60.0) / BPM); // 24055 samples = 0.54545s

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

        // Accent beat 1 (High piercing tone 1300Hz + 2600Hz + 3900Hz harmonics, 95ms with soft-clip saturation for maximum speaker volume)
        int tockLen = (int) (SAMPLE_RATE * 0.095);
        for (int i = 0; i < tockLen && i < TOTAL_BEAT_SAMPLES; i++) {
            double attack = Math.min(1.0, i / (SAMPLE_RATE * 0.003));
            double decay = Math.exp(-i / (SAMPLE_RATE * 0.035));
            double env = attack * decay;
            
            double f1 = Math.sin(2.0 * Math.PI * 1300.0 * i / SAMPLE_RATE) * 0.65;
            double f2 = Math.sin(2.0 * Math.PI * 2600.0 * i / SAMPLE_RATE) * 0.35;
            double f3 = Math.sin(2.0 * Math.PI * 3900.0 * i / SAMPLE_RATE) * 0.15;
            double raw = (f1 + f2 + f3) * env * 1.6;
            
            // Soft clipping overdrive for maximum acoustic RMS loudness on phone speakers
            tock[i] = Math.tanh(raw) * 0.99;
        }

        // Standard beats 2-30 (1000Hz + 2000Hz + 3000Hz harmonics, 75ms with high loudness)
        int tickLen = (int) (SAMPLE_RATE * 0.075);
        for (int i = 0; i < tickLen && i < TOTAL_BEAT_SAMPLES; i++) {
            double attack = Math.min(1.0, i / (SAMPLE_RATE * 0.002));
            double decay = Math.exp(-i / (SAMPLE_RATE * 0.025));
            double env = attack * decay;
            
            double f1 = Math.sin(2.0 * Math.PI * 1000.0 * i / SAMPLE_RATE) * 0.70;
            double f2 = Math.sin(2.0 * Math.PI * 2000.0 * i / SAMPLE_RATE) * 0.30;
            double f3 = Math.sin(2.0 * Math.PI * 3000.0 * i / SAMPLE_RATE) * 0.12;
            double raw = (f1 + f2 + f3) * env * 1.5;
            
            tick[i] = Math.tanh(raw) * 0.98;
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

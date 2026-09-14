package atlow.chemi.mymada.classes;

import android.media.AudioTrack;

/* loaded from: classes.dex */
public class AudioGenerator {
    private AudioTrack audioTrack;
    private int sampleRate;

    public AudioGenerator(int i) {
        this.sampleRate = i;
    }

    private byte[] get16BitPcm(double[] dArr) {
        byte[] bArr = new byte[dArr.length * 2];
        int i = 0;
        for (double d : dArr) {
            short s = (short) (d * 32767.0d);
            int i2 = i + 1;
            bArr[i] = (byte) (s & 255);
            i = i2 + 1;
            bArr[i2] = (byte) ((s & 65280) >>> 8);
        }
        return bArr;
    }

    public void createPlayer() {
        int i = this.sampleRate;
        this.audioTrack = new AudioTrack(4, i, 2, 2, i, 1);
        this.audioTrack.play();
    }

    public void destroyAudioTrack() {
        this.audioTrack.stop();
        this.audioTrack.release();
    }

    public double[] getSineWave(int i, int i2, double d) {
        double[] dArr = new double[i];
        for (int i3 = 0; i3 < i; i3++) {
            double d2 = i3;
            Double.isNaN(d2);
            double d3 = i2;
            Double.isNaN(d3);
            dArr[i3] = Math.sin((d2 * 6.283185307179586d) / (d3 / d));
        }
        return dArr;
    }

    public void writeSound(double[] dArr) {
        byte[] bArr = get16BitPcm(dArr);
        this.audioTrack.write(bArr, 0, bArr.length);
    }
}

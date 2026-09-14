package atlow.chemi.mymada.classes;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import com.crashlytics.android.Crashlytics;

/* loaded from: classes.dex */
public class AudioGenerator {
    private AudioTrack audioTrack;
    private int sampleRate;

    public AudioGenerator(int sampleRate) {
        this.sampleRate = sampleRate > 0 ? sampleRate : 44100;
    }

    public AudioGenerator() {
        this(44100);
    }

    public byte[] get16BitPcm(double[] dArr) {
        if (dArr == null) return new byte[0];
        byte[] bArr = new byte[dArr.length * 2];
        int i = 0;
        for (double d : dArr) {
            short s = (short) Math.max(-32768, Math.min(32767, (int) (d * 32767.0d)));
            bArr[i++] = (byte) (s & 0xFF);
            bArr[i++] = (byte) ((s >> 8) & 0xFF);
        }
        return bArr;
    }

    public void createPlayer() {
        try {
            destroyAudioTrack();
            int minBuf = AudioTrack.getMinBufferSize(this.sampleRate, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
            int bufSize = Math.max(minBuf, this.sampleRate);

            if (Build.VERSION.SDK_INT >= 21) {
                AudioAttributes audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .build();
                AudioFormat audioFormat = new AudioFormat.Builder()
                        .setSampleRate(this.sampleRate)
                        .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                        .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                        .build();
                this.audioTrack = new AudioTrack(audioAttributes, audioFormat, bufSize, AudioTrack.MODE_STREAM, AudioManager.AUDIO_SESSION_ID_GENERATE);
            } else {
                this.audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, this.sampleRate, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, bufSize, AudioTrack.MODE_STREAM);
            }
            if (this.audioTrack != null && this.audioTrack.getState() == AudioTrack.STATE_INITIALIZED) {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.audioTrack.setVolume(AudioTrack.getMaxVolume());
                } else {
                    this.audioTrack.setStereoVolume(1.0f, 1.0f);
                }
                this.audioTrack.play();
            }
        } catch (Exception e) {
            Crashlytics.logException(e);
            e.printStackTrace();
        }
    }

    public void destroyAudioTrack() {
        if (this.audioTrack != null) {
            try {
                if (this.audioTrack.getPlayState() == AudioTrack.PLAYSTATE_PLAYING) {
                    this.audioTrack.stop();
                }
                this.audioTrack.flush();
                this.audioTrack.release();
            } catch (Exception ignored) {
            }
            this.audioTrack = null;
        }
    }

    public double[] getSineWave(int samples, int sampleRate, double freq) {
        double[] dArr = new double[samples];
        if (freq <= 0.0d) {
            return dArr;
        }
        double actualFreq = freq;
        if (actualFreq >= sampleRate / 2.0d) {
            actualFreq = 880.0d;
        }
        double twoPiF = 2.0d * Math.PI * actualFreq / sampleRate;
        for (int i = 0; i < samples; i++) {
            double env = 1.0d;
            if (i < 100) {
                env = (double) i / 100.0d;
            } else if (i > samples - 200) {
                env = (double) (samples - i) / 200.0d;
            }
            dArr[i] = Math.sin(i * twoPiF) * env;
        }
        return dArr;
    }

    public void writeSound(double[] dArr) {
        if (dArr == null || dArr.length == 0) return;
        byte[] bArr = get16BitPcm(dArr);
        writeSound(bArr);
    }

    public void writeSound(byte[] bArr) {
        if (bArr == null || bArr.length == 0) return;
        if (this.audioTrack == null || this.audioTrack.getState() != AudioTrack.STATE_INITIALIZED) {
            createPlayer();
        }
        if (this.audioTrack != null) {
            try {
                this.audioTrack.write(bArr, 0, bArr.length);
            } catch (Exception e) {
                Crashlytics.logException(e);
            }
        }
    }
}

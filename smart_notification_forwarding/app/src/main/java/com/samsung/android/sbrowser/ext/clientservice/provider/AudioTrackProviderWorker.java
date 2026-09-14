package com.samsung.android.sbrowser.ext.clientservice.provider;

import android.content.Context;
import android.util.Log;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.android.sbrowser.ext.clientservice.WavFileUtil;
import com.samsung.android.sbrowser.ext.clientservice.asr.ASR;
import com.samsung.android.sbrowser.ext.clientservice.asr.ASRClient;
import com.samsung.android.sbrowser.ext.clientservice.asr.ASRFactory;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;

/* loaded from: classes.dex */
class AudioTrackProviderWorker extends Worker implements ASRClient, TrackProvider {
    private static final int CHANNEL_COUNT = 1;
    private static final boolean DEBUG = false;
    private static final int ENCODING_BYTES = 2;
    private static final String TAG = "AudioTPWorker";
    private static final int WAV_SPLIT_DURATION = 10;
    private ASR mASR;
    private final AudioTrackProvider mClient;
    private final Context mContext;
    private String[] mInstalledLocales;
    private final TrackProviderClient mTrackProviderClient;
    private double mWavFileDuration;
    private WavFileUtil mWavFileUtil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioTrackProviderWorker(Context context, AudioTrackProvider audioTrackProvider, TrackProviderClient trackProviderClient) {
        super(context, "AudioTrackProviderWorker", audioTrackProvider);
        this.mWavFileDuration = Cue.INVALID_SEC;
        Log.i(TAG, "AudioTrackProviderWorker ctor");
        this.mContext = context;
        this.mClient = audioTrackProvider;
        this.mTrackProviderClient = trackProviderClient;
        this.mASR = null;
    }

    public void initProvider(final String str, final String str2, final String str3) throws Exception {
        Log.d(TAG, "init called with " + str2 + " installedLocales " + str3);
        initThread();
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.AudioTrackProviderWorker.1
            @Override // java.lang.Runnable
            public void run() {
                AudioTrackProviderWorker.this.initProviderOnWorker(str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initProviderOnWorker(String str, String str2, String str3) {
        try {
            this.mInstalledLocales = SixObject.tokenizeParam(str3);
            this.mASR = ASRFactory.createASR(this.mContext, str2);
            Log.d(TAG, "initOnWorker " + this.mASR);
            this.mASR.init(this.mContext, this, this.mInstalledLocales);
            this.mTrackProviderClient.initTrackProviderClient(this);
            sendSuccessToClient(str, Double.toString(this.mASR.getSampleRate()), Integer.toString(this.mASR.getChannelCount()), Integer.toString(this.mASR.getFrameCount()), Double.toString(this.mASR.getBufferLatency()));
        } catch (Exception e) {
            sendFailToClient(str, e);
        }
    }

    public void deleteProvider(String str) {
        try {
            deleteThread();
            sendSuccessToClient(str, new String[0]);
        } catch (Exception e) {
            sendFailToClient(str, e);
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.Worker
    protected void onDeleteOnWorker() {
        Log.i(TAG, "onDeleteOnWorker called");
        try {
            ASR asr = this.mASR;
            if (asr != null) {
                asr.delete();
            }
            this.mTrackProviderClient.resetTrackProviderClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.i(TAG, "onDeleteOnWorker finished");
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.provider.TrackProvider
    public String getLocale() throws Exception {
        return this.mASR.getStatus() != ASR.Status.LOCALE_DETECTED ? JsonProperty.USE_DEFAULT_NAME : this.mASR.getLocale();
    }

    public void addAudio(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final String str8) throws Exception {
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.AudioTrackProviderWorker.2
            @Override // java.lang.Runnable
            public void run() {
                AudioTrackProviderWorker.this.addAudioOnWorker(str, str2, str3, str4, str5, str6, str7, str8);
            }
        });
    }

    public void addAudioOnWorker(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = str;
        try {
            double parseDouble = Double.parseDouble(str3);
            double parseDouble2 = Double.parseDouble(str4);
            int parseInt = Integer.parseInt(str5);
            boolean booleanValue = Boolean.valueOf(str6).booleanValue();
            boolean booleanValue2 = Boolean.valueOf(str7).booleanValue();
            if (booleanValue) {
                Log.i(TAG, "addAudio new_session " + str3);
                initSession();
            }
            if (booleanValue2) {
                Log.d(TAG, "addAudio endofStream" + str5 + " " + str8);
                return;
            }
            if (parseInt * 2 != str2.length()) {
                throw new RuntimeException("invalid buffer length");
            }
            byte[] bytes = str2.getBytes(StandardCharsets.ISO_8859_1);
            if (str8.length() > 0) {
                try {
                    byte[] digest = MessageDigest.getInstance("MD5").digest(bytes);
                    if (digest.length * 2 != str8.length()) {
                        throw new RuntimeException("hash length failed");
                    }
                    int i = 0;
                    while (i < digest.length) {
                        int i2 = i * 2;
                        String substring = str8.substring(i2, i2 + 2);
                        boolean z = booleanValue2;
                        byte parseInt2 = (byte) Integer.parseInt(substring, 16);
                        if (digest[i] != parseInt2) {
                            Log.e(TAG, str8);
                            Log.e(TAG, "hash failed " + i + " " + substring + " " + ((int) parseInt2) + " " + ((int) digest[i]));
                            throw new RuntimeException("hash failed");
                        }
                        i++;
                        booleanValue2 = z;
                    }
                } catch (Exception e) {
                    e = e;
                    str9 = str;
                    sendFailToClient(str9, e);
                    return;
                }
            }
            this.mASR.addAudio(bytes, parseDouble, (int) parseDouble2, parseInt, booleanValue, booleanValue2);
            sendSuccessToClient(str, getLocale());
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void resetSession(final String str) {
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.AudioTrackProviderWorker.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AudioTrackProviderWorker.this.mTrackProviderClient.resetTrackProviderClientSession(true);
                } catch (Exception e) {
                    AudioTrackProviderWorker.this.sendFailToClient(str, e);
                }
            }
        });
    }

    void sendCueResult(final Cue cue, final Exception exc) {
        postToWorker(new Runnable() { // from class: com.samsung.android.sbrowser.ext.clientservice.provider.AudioTrackProviderWorker.4
            @Override // java.lang.Runnable
            public void run() {
                if (cue != null && exc == null) {
                    ArrayList<Cue> arrayList = new ArrayList<>();
                    arrayList.add(cue);
                    AudioTrackProviderWorker.this.mTrackProviderClient.onMoreTrackData(arrayList);
                } else if (exc != null) {
                    AudioTrackProviderWorker.this.mTrackProviderClient.onTrackProviderError(exc);
                }
            }
        });
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASRClient
    public void onCueRecognized(Cue cue) {
        sendCueResult(cue, null);
    }

    private void initSession() {
        Cue.initId();
        this.mTrackProviderClient.resetTrackProviderClientSession(true);
    }

    private void addBufferToWavFile(double d, int i, double d2, byte[] bArr, boolean z, boolean z2) {
        if (z2) {
            this.mWavFileUtil.flush((int) d, 1, 2);
            this.mWavFileDuration = Cue.INVALID_SEC;
            return;
        }
        if (z) {
            Log.d(TAG, "addBufferToWavFile newSession");
            this.mWavFileUtil.flush((int) d, 1, 2);
            this.mWavFileDuration = Cue.INVALID_SEC;
        }
        try {
            this.mWavFileUtil.handleBuffer(ByteBuffer.wrap(bArr));
            this.mWavFileDuration += i / d;
        } catch (Exception unused) {
        }
    }
}

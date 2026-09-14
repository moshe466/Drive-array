package com.samsung.android.sbrowser.ext.clientservice.asr;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sbrowser.ext.clientservice.asr.ASR;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import java.util.List;

/* loaded from: classes.dex */
class CraftASREngine implements ASR {
    private static final int CHANNEL_COUNT = 1;
    private static final int CONFIDENCE_COUNT_THRESHOLD = 2;
    private static final boolean DEBUG = false;
    private static final int ENCODING_BYTES = 2;
    private static final double SESSION_RESET_THRESHOLD = 1.0d;
    private static final String TAG = "CraftASREngine";
    private static final double TIMESTAMP_THRESHOLD = 0.1d;
    private static final double UNKNOWN_TIMESTAMP = -1.0d;
    private ASRClient mClient;
    private int mConfidenceHitCount;
    Context mContext = null;
    private double mElapsedTimeAfterReset;
    private double mExpectedTimeStamp;
    private String[] mInstalledLocales;
    private CraftASRLocaleDetector mLocaleDetector;
    private double mStartTimeStamp;

    public CraftASREngine() {
        Log.d(TAG, "CraftASREngine ctor");
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public void init(Context context, ASRClient aSRClient, String[] strArr) throws Exception {
        Log.i(TAG, "init called");
        this.mContext = context;
        this.mClient = aSRClient;
        this.mInstalledLocales = strArr;
        this.mExpectedTimeStamp = UNKNOWN_TIMESTAMP;
        this.mStartTimeStamp = Cue.INVALID_SEC;
        this.mConfidenceHitCount = 0;
        this.mLocaleDetector = new CraftASRLocaleDetector(context, strArr);
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public void delete() throws Exception {
        Log.i(TAG, "delete called ");
        CraftASRLocaleDetector craftASRLocaleDetector = this.mLocaleDetector;
        if (craftASRLocaleDetector != null) {
            craftASRLocaleDetector.delete();
        }
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public double getSampleRate() throws Exception {
        return this.mLocaleDetector.getASR().getSampleRate();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public int getChannelCount() throws Exception {
        return this.mLocaleDetector.getASR().getChannelCount();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public int getFrameCount() throws Exception {
        return this.mLocaleDetector.getASR().getFrameCount();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public double getBufferLatency() throws Exception {
        return this.mLocaleDetector.getASR().getBufferLatency();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public String getLocale() throws Exception {
        return this.mLocaleDetector.getLocale();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public ASR.Status getStatus() throws Exception {
        return this.mLocaleDetector.getStatus();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASR
    public void addAudio(byte[] bArr, double d, int i, int i2, boolean z, boolean z2) throws Exception {
        if (z2) {
            this.mConfidenceHitCount = 0;
            SixLog.dlog(TAG, "CraftASREngine::addAudio: endofStream" + i2);
            return;
        }
        double d2 = i;
        if (!resetRecognizerIfRequired(d, d2, i2, z)) {
            this.mConfidenceHitCount = 0;
            SixLog.dlog(TAG, "CraftASREngine::addAudio: session reset" + d);
            return;
        }
        if (this.mLocaleDetector.getStatus() == ASR.Status.LOCALE_DETECT_FAILED) {
            this.mConfidenceHitCount = 0;
            throw new RuntimeException("fail to detect locale");
        }
        if (this.mLocaleDetector.getStatus() == ASR.Status.LOCALE_DETECTING) {
            if (this.mLocaleDetector.addAudio(bArr, bArr.length, d2)) {
                List<Cue> cues = this.mLocaleDetector.getCues();
                if (cues.size() >= 1) {
                    Cue cue = cues.get(cues.size() - 1);
                    if (cue.getConfidence() >= 0.9d) {
                        int i3 = this.mConfidenceHitCount + 1;
                        this.mConfidenceHitCount = i3;
                        if (i3 >= 2) {
                            cue.setStartSec(cue.getStartSec() + this.mStartTimeStamp);
                            cue.setEndSec(cue.getEndSec() + this.mStartTimeStamp);
                            this.mClient.onCueRecognized(cue);
                            return;
                        }
                        SixLog.dlog(TAG, "CraftASREngine::addAudio: low confidence count" + this.mConfidenceHitCount + " [" + cue.getText() + "]");
                        return;
                    }
                    SixLog.dlog(TAG, "CraftASREngine::addAudio: low confidence " + cue.getConfidence() + " [" + cue.getText() + "]");
                    return;
                }
                return;
            }
            return;
        }
        if (this.mLocaleDetector.getStatus() == ASR.Status.LOCALE_DETECTED) {
            this.mConfidenceHitCount = 0;
            if (this.mLocaleDetector.getASR().addAudio(bArr, bArr.length, d2, false)) {
                Cue cue2 = this.mLocaleDetector.getASR().getCue();
                cue2.setStartSec(cue2.getStartSec() + this.mStartTimeStamp);
                cue2.setEndSec(cue2.getEndSec() + this.mStartTimeStamp);
                this.mClient.onCueRecognized(cue2);
            }
        }
    }

    private boolean resetRecognizerIfRequired(double d, double d2, int i, boolean z) throws Exception {
        double d3 = i / d2;
        if (z) {
            this.mElapsedTimeAfterReset = d3;
            Log.i(TAG, "newSession : deleteRecognizer if it exist " + this.mElapsedTimeAfterReset + " " + d);
            return false;
        }
        double d4 = this.mElapsedTimeAfterReset;
        if (d4 <= Cue.INVALID_SEC) {
            return true;
        }
        double d5 = d4 + d3;
        this.mElapsedTimeAfterReset = d5;
        if (d5 <= SESSION_RESET_THRESHOLD) {
            return false;
        }
        Log.i(TAG, "initRecognizer elapsed " + this.mElapsedTimeAfterReset + " timestamp " + d);
        this.mLocaleDetector.reset();
        this.mStartTimeStamp = d;
        this.mElapsedTimeAfterReset = Cue.INVALID_SEC;
        return true;
    }
}

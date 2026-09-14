package com.samsung.android.sbrowser.ext.clientservice.asr;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sbrowser.ext.clientservice.asr.ASR;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.CueSeg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class CraftASRLocaleDetector extends ASRLocaleDetector {
    static final boolean DISABLED = false;
    static final int ENOUGH_CUE_SIZE = 1;
    static final double HIGH_CONFIDENCE = 0.9d;
    static final double LOW_CONFIDENCE = 0.84d;
    static final double MODELCONF_TIMEOUT_SEC = 3.4d;
    List<byte[]> mBufList;
    Context mContext;
    Detector mDetector;
    List<String> mLocales;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CraftASRLocaleDetector(Context context, String[] strArr) throws Exception {
        this.mContext = context;
        if (strArr == null) {
            throw new RuntimeException("installedLocales is null");
        }
        this.mLocales = new ArrayList();
        for (String str : strArr) {
            if (CraftASRFactory.get().isApkInstalled(context, str)) {
                this.mLocales.add(str);
            }
        }
        if (this.mLocales.size() == 0) {
            this.mLocales = null;
            throw new RuntimeException("no available langpack for ASR");
        }
        this.mBufList = new ArrayList();
        this.mDetector = new Detector(this.mContext, this.mLocales.get(0));
    }

    private void updateBestASR(double d) throws Exception {
        for (String str : this.mLocales) {
            if (!str.equals(this.mDetector.getLocale())) {
                Detector detector = new Detector(this.mContext, str);
                for (byte[] bArr : this.mBufList) {
                    detector.addAudio(bArr, bArr.length, d);
                }
                if (this.mDetector.getConfidence() < detector.getConfidence()) {
                    this.mDetector.delete(this.mContext);
                    this.mDetector = detector;
                } else {
                    detector.delete(this.mContext);
                }
            }
        }
        this.mBufList.clear();
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASRLocaleDetector
    public boolean addAudio(byte[] bArr, int i, double d) throws Exception {
        if (getStatus() != ASR.Status.LOCALE_DETECTING) {
            return false;
        }
        if (this.mLocales == null) {
            setStatus(ASR.Status.LOCALE_DETECT_FAILED);
            return false;
        }
        this.mBufList.add(bArr);
        if (!this.mDetector.addAudio(bArr, i, d)) {
            return false;
        }
        if (!this.mDetector.hasEnoughVoiceActivity()) {
            return true;
        }
        updateBestASR(d);
        if (this.mDetector.getConfidence() >= LOW_CONFIDENCE) {
            return true;
        }
        setStatus(ASR.Status.LOCALE_DETECT_FAILED);
        return true;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASRLocaleDetector
    public void reset() throws Exception {
        setStatus(ASR.Status.LOCALE_DETECTING);
        this.mBufList.clear();
        this.mDetector.reset(this.mContext);
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASRLocaleDetector
    public void delete() {
        this.mDetector.delete(this.mContext);
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.asr.ASRLocaleDetector
    public ASR.Status getStatus() {
        return this.mDetector.getStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CraftASR getASR() {
        return this.mDetector.getASR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLocale() {
        return this.mDetector.getLocale();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Cue> getCues() {
        return this.mDetector.getCues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Detector {
        private static final String TAG = "Detector";
        CraftASR mASR;
        double mConfidence;
        List<Cue> mCues = new ArrayList();
        String mLocale;
        double mNonSilenceSec;

        Detector(Context context, String str) throws Exception {
            this.mLocale = str;
            recreateASR(context);
            this.mConfidence = Cue.INVALID_SEC;
            this.mNonSilenceSec = Cue.INVALID_SEC;
        }

        void recreateASR(Context context) throws Exception {
            if (this.mASR == null) {
                this.mASR = CraftASRFactory.get().createASR(context, this.mLocale);
            } else {
                CraftASRFactory.get().deleteASR(context, this.mLocale, this.mASR, false);
                this.mASR = CraftASRFactory.get().createASR(context, this.mLocale);
            }
        }

        String getLocale() {
            return this.mLocale;
        }

        CraftASR getASR() {
            return this.mASR;
        }

        void reset(Context context) throws Exception {
            this.mCues.clear();
            this.mNonSilenceSec = Cue.INVALID_SEC;
            this.mConfidence = Cue.INVALID_SEC;
            recreateASR(context);
        }

        void delete(Context context) {
            CraftASRFactory.get().deleteASR(context, this.mLocale, this.mASR, true);
        }

        void addCue(Cue cue) {
            this.mCues.add(cue);
            this.mNonSilenceSec += calcNonSlience(cue);
            this.mConfidence += cue.getConfidence();
            Log.i(TAG, "addCue : nonsilence " + this.mNonSilenceSec + " confidence " + (this.mConfidence / this.mCues.size()) + " status " + getStatus());
        }

        List<Cue> getCues() {
            return this.mCues;
        }

        double getConfidence() {
            return this.mCues.size() == 0 ? Cue.INVALID_SEC : this.mConfidence / this.mCues.size();
        }

        private double calcNonSlience(Cue cue) {
            Iterator<CueSeg> it = cue.iterator();
            double d = Cue.INVALID_SEC;
            while (it.hasNext()) {
                d += it.next().getDuration();
            }
            return d;
        }

        boolean hasEnoughVoiceActivity() {
            return this.mNonSilenceSec > CraftASRLocaleDetector.MODELCONF_TIMEOUT_SEC;
        }

        boolean addAudio(byte[] bArr, int i, double d) throws Exception {
            if (getStatus() != ASR.Status.LOCALE_DETECTING || !this.mASR.addAudio(bArr, i, d, false)) {
                return false;
            }
            addCue(this.mASR.getCue());
            return true;
        }

        ASR.Status getStatus() {
            if (!hasEnoughVoiceActivity()) {
                return ASR.Status.LOCALE_DETECTING;
            }
            if (this.mCues.size() >= 1 && getConfidence() > CraftASRLocaleDetector.LOW_CONFIDENCE) {
                return ASR.Status.LOCALE_DETECTED;
            }
            return ASR.Status.LOCALE_DETECT_FAILED;
        }
    }
}

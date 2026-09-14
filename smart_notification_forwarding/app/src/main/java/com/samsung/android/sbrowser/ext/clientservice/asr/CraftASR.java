package com.samsung.android.sbrowser.ext.clientservice.asr;

import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.CueSeg;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.vosk.LibVosk;
import org.vosk.LogLevel;
import org.vosk.Recognizer;

/* loaded from: classes.dex */
class CraftASR {
    static final double CONFIG_BUFFER_LATENCY_SEC = 5.0d;
    static final int CONFIG_CHANNEL_COUNT = 1;
    static final int CONFIG_FRAME_COUNT = 1024;
    static final int CONFIG_SAMPLE_RATE = 16000;
    static final String TAG = "CraftASR";
    Cue mCue;
    CraftModel mModel;
    Cue mPartialCue;
    Recognizer mRecognizer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getBufferLatency() throws Exception {
        return CONFIG_BUFFER_LATENCY_SEC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChannelCount() throws Exception {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFrameCount() throws Exception {
        return 1024;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double getSampleRate() {
        return 16000.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CraftASR(CraftModel craftModel) {
        this.mModel = craftModel;
        Recognizer recognizer = new Recognizer(craftModel.getModel(), 16000.0f);
        this.mRecognizer = recognizer;
        recognizer.setWords(true);
        LibVosk.setLogLevel(LogLevel.INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void delete() {
        this.mRecognizer.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cue getCue() {
        return this.mCue;
    }

    Cue getPartialCue() {
        return this.mPartialCue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean addAudio(byte[] bArr, int i, double d, boolean z) throws Exception {
        if (d != 16000.0d) {
            throw new RuntimeException("unsupported samplerate");
        }
        boolean acceptWaveForm = this.mRecognizer.acceptWaveForm(bArr, i);
        this.mPartialCue = null;
        this.mCue = null;
        if (!acceptWaveForm) {
            if (z) {
                String string = new JSONObject(this.mRecognizer.getPartialResult()).getString("partial");
                if (string.length() > 0) {
                    this.mPartialCue = new Cue(Cue.INVALID_SEC, Cue.INVALID_SEC, string);
                }
            }
            return false;
        }
        JSONObject jSONObject = new JSONObject(this.mRecognizer.getResult());
        String string2 = jSONObject.getString("text");
        SixLog.dlog(TAG, "CraftASR::addAudio: result=[" + string2 + "]");
        if (string2.length() <= 0) {
            return false;
        }
        JSONArray jSONArray = (JSONArray) jSONObject.get("result");
        ArrayList arrayList = new ArrayList();
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
            double d4 = jSONObject2.getDouble("start");
            double d5 = jSONObject2.getDouble("end");
            String string3 = jSONObject2.getString("word");
            double d6 = jSONObject2.getDouble("conf");
            if (i2 == 0) {
                d3 = d4;
            }
            if (i2 == jSONArray.length() - 1) {
                d2 = d5;
            }
            arrayList.add(new CueSeg(d4 - d3, d5 - d4, string3, d6));
        }
        Cue cue = new Cue(d3, d2, arrayList);
        this.mCue = cue;
        cue.setLangCode(this.mModel.getLangCode());
        return true;
    }
}

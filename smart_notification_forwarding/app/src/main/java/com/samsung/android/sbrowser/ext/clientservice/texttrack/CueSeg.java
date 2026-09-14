package com.samsung.android.sbrowser.ext.clientservice.texttrack;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CueSeg {
    private static final String TAG = "CueSeg";
    private final double mConfidence;
    private double mDuration;
    private final double mOffsetSec;
    private final String mText;

    public CueSeg(double d, double d2, String str) {
        this(d, d2, str, 1.0d);
    }

    public CueSeg(double d, double d2, String str, double d3) {
        this.mText = str.replaceAll("\\[.*?\\]", JsonProperty.USE_DEFAULT_NAME).replaceAll("\\{.*?\\}", JsonProperty.USE_DEFAULT_NAME).replaceAll("\\(.*?\\)", JsonProperty.USE_DEFAULT_NAME);
        this.mOffsetSec = d;
        this.mDuration = d2;
        this.mConfidence = d3;
    }

    public static List<CueSeg> cloneCueSegs(List<CueSeg> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (CueSeg cueSeg : list) {
            if (z) {
                arrayList.add(new CueSeg(cueSeg.getOffsetSec(), cueSeg.getDuration(), cueSeg.getText(), cueSeg.getConfidence()));
            } else {
                arrayList.add(cueSeg);
            }
        }
        return arrayList;
    }

    public static void debugCueSegs(List<CueSeg> list) {
        if (SixLog.isDebug()) {
            SixLog.dlog(TAG, "debug CueSegs start ----->");
            double d = Cue.INVALID_SEC;
            for (CueSeg cueSeg : list) {
                d += cueSeg.getDuration();
                SixLog.dlog(TAG, " " + cueSeg);
            }
            SixLog.dlog(TAG, "total duriation " + d);
            SixLog.dlog(TAG, "debug CueSegs end <-----");
        }
    }

    public String getText() {
        return this.mText;
    }

    public double getConfidence() {
        return this.mConfidence;
    }

    public double getDuration() {
        return this.mDuration;
    }

    public void setDuration(double d) {
        this.mDuration = d;
    }

    public double getOffsetSec() {
        return this.mOffsetSec;
    }

    public String toString() {
        return ((((((((("[ O: " + this.mOffsetSec) + " , ") + "D: " + this.mDuration) + " , ") + "C: " + this.mConfidence) + " , ") + "{") + this.mText) + "}") + " ]";
    }
}

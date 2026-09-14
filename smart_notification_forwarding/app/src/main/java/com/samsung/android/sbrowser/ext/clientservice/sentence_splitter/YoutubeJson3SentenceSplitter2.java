package com.samsung.android.sbrowser.ext.clientservice.sentence_splitter;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.CueSeg;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class YoutubeJson3SentenceSplitter2 implements SentenceSplitter {
    private static final double SPLIT_THRESHOLD_SEC = 1.1d;
    private static final String TAG = "YtJson3SentenceSplit2";
    private double mCurrStartSec;
    private String mCurrText;
    private double mPrevDuration;
    private double mPrevStartSec;

    public YoutubeJson3SentenceSplitter2(TextTrack textTrack) {
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.sentence_splitter.SentenceSplitter
    public boolean initSplitter() throws Exception {
        Log.d(TAG, "initSplitter ");
        this.mPrevStartSec = -1.0d;
        this.mCurrStartSec = -1.0d;
        this.mCurrText = JsonProperty.USE_DEFAULT_NAME;
        this.mPrevDuration = Cue.INVALID_SEC;
        return true;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.sentence_splitter.SentenceSplitter
    public List<Cue> addMoreCueForSplit(Cue cue) throws Exception {
        ArrayList arrayList = new ArrayList();
        if (cue == null && this.mCurrText.length() > 0) {
            arrayList.add(new Cue(this.mCurrStartSec, this.mPrevStartSec, this.mCurrText));
            return arrayList;
        }
        if (cue.isOnlyNewLine()) {
            return arrayList;
        }
        Iterator<CueSeg> it = cue.iterator();
        if (this.mCurrStartSec == -1.0d) {
            this.mCurrStartSec = cue.getStartSec();
            this.mCurrText = JsonProperty.USE_DEFAULT_NAME;
        }
        while (it.hasNext()) {
            CueSeg next = it.next();
            double offsetSec = next.getOffsetSec() + cue.getStartSec();
            if (this.mPrevStartSec == -1.0d) {
                this.mPrevStartSec = offsetSec;
                this.mPrevDuration = Cue.INVALID_SEC;
            }
            SixLog.dlog(TAG, String.format("%s %.2f %.2f %.4f %.2f", next.getText(), Double.valueOf(offsetSec), Double.valueOf(this.mPrevStartSec), Double.valueOf(this.mPrevDuration), Double.valueOf(offsetSec - (this.mPrevStartSec + this.mPrevDuration))));
            if (offsetSec - (this.mPrevStartSec + this.mPrevDuration) >= SPLIT_THRESHOLD_SEC) {
                arrayList.add(new Cue(this.mCurrStartSec, next.getOffsetSec() + cue.getStartSec(), this.mCurrText));
                this.mCurrStartSec = offsetSec;
                this.mCurrText = JsonProperty.USE_DEFAULT_NAME;
            }
            this.mCurrText += next.getText();
            this.mCurrText += " ";
            this.mPrevStartSec = offsetSec;
            this.mPrevDuration = calcSegDuration(next);
        }
        return arrayList;
    }

    private double calcSegDuration(CueSeg cueSeg) {
        return cueSeg.getText().length() * 0.1d;
    }
}

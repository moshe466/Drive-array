package com.samsung.android.sbrowser.ext.clientservice.sentence_splitter;

import android.util.Log;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class SyncSentenceSplitter implements SentenceSplitter {
    private static final String TAG = "SyncSentenceSplitter";
    TextTrack mDst;
    Cue mDstCue;
    Iterator<Cue> mDstCueIter;
    Cue mNewCue;

    SyncSentenceSplitter(TextTrack textTrack) {
        this.mDst = textTrack;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.sentence_splitter.SentenceSplitter
    public boolean initSplitter() throws Exception {
        Iterator<Cue> it = this.mDst.iterator();
        this.mDstCueIter = it;
        if (it.hasNext()) {
            this.mDstCue = this.mDstCueIter.next();
            this.mNewCue = new Cue();
            return true;
        }
        Log.e(TAG, "dst texttrack doesn't have any cue");
        this.mDstCue = null;
        this.mNewCue = null;
        return false;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.sentence_splitter.SentenceSplitter
    public List<Cue> addMoreCueForSplit(Cue cue) throws Exception {
        return new ArrayList();
    }
}

package com.samsung.android.sbrowser.ext.clientservice.sentence_splitter;

import android.util.Log;
import com.samsung.android.sbrowser.ext.clientservice.six.SixLog;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.CueSeg;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.TextTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class YoutubeJson3SentenceSplitter implements SentenceSplitter {
    private static final String TAG = "YtJson3SentenceSplitter";
    Iterator<Cue> mCueIter;
    ArrayList<CueSeg> mCueSegList = new ArrayList<>();
    Cue mCurrCue;
    Cue mNextCue;
    TextTrack mRef;
    boolean mSplitByNewline;
    String mText;

    public YoutubeJson3SentenceSplitter(TextTrack textTrack, boolean z) {
        this.mRef = textTrack;
        this.mSplitByNewline = z;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.sentence_splitter.SentenceSplitter
    public boolean initSplitter() throws Exception {
        this.mCueIter = this.mRef.iterator();
        Log.d(TAG, "initSplitter " + this.mCueIter);
        this.mCurrCue = null;
        this.mNextCue = null;
        Cue findNextSentence = findNextSentence(null);
        this.mCurrCue = findNextSentence;
        this.mNextCue = findNextSentence(findNextSentence);
        resetCueSegList();
        return true;
    }

    private void appendCueSegList(Cue cue) {
        Iterator<CueSeg> it = cue.iterator();
        while (it.hasNext()) {
            CueSeg next = it.next();
            String replace = next.getText().replace("\n", " ");
            double startSec = (cue.getStartSec() + next.getOffsetSec()) - this.mCurrCue.getStartSec();
            if (this.mCueSegList.size() >= 1) {
                ArrayList<CueSeg> arrayList = this.mCueSegList;
                CueSeg cueSeg = arrayList.get(arrayList.size() - 1);
                if (cueSeg.getOffsetSec() + cueSeg.getDuration() > startSec) {
                    cueSeg.setDuration(startSec - cueSeg.getOffsetSec());
                }
            }
            this.mCueSegList.add(new CueSeg(startSec, next.getDuration(), replace, next.getConfidence()));
        }
    }

    private void resetCueSegList() {
        this.mCueSegList.clear();
    }

    private Cue createCueFromCueSegList(double d, double d2) {
        if (this.mCueSegList.size() <= 0) {
            SixLog.error(TAG, "createCueFromCueSegList : cue seg list is empty");
            return null;
        }
        List<CueSeg> cloneCueSegs = CueSeg.cloneCueSegs(this.mCueSegList, false);
        CueSeg cueSeg = cloneCueSegs.get(cloneCueSegs.size() - 1);
        if (cueSeg.getOffsetSec() + d + cueSeg.getDuration() > d2) {
            cueSeg.setDuration((d2 - cueSeg.getOffsetSec()) - d);
        }
        if (cueSeg.getText() == null || cueSeg.getText().trim().isEmpty()) {
            return null;
        }
        Cue cue = new Cue(d, d2, cloneCueSegs);
        if (Cue.doubleCmp(cue.getDurationSec(), cue.totalDuration()) < Cue.INVALID_SEC) {
            SixLog.error(TAG, "newCue is invalid " + d + " " + d2 + " " + cue);
            cue.debugPrintCueSegs();
        }
        return cue;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.sentence_splitter.SentenceSplitter
    public List<Cue> addMoreCueForSplit(Cue cue) throws Exception {
        ArrayList arrayList = new ArrayList();
        Cue cue2 = this.mCurrCue;
        if (cue2 == null) {
            Log.e(TAG, "mCurrCue must not be null. maybe end of file");
            return arrayList;
        }
        if (cue2 != null && this.mNextCue == null) {
            if (cue != null) {
                appendCueSegList(cue);
                return arrayList;
            }
            Cue createCueFromCueSegList = createCueFromCueSegList(cue2.getStartSec(), this.mCurrCue.getStartSec() + this.mCurrCue.getDurationSec());
            if (createCueFromCueSegList != null) {
                arrayList.add(createCueFromCueSegList);
            }
            return arrayList;
        }
        if (Cue.doubleCmp(cue.getStartSec(), this.mNextCue.getStartSec()) == Cue.INVALID_SEC && Cue.doubleCmp(cue.getDurationSec(), this.mNextCue.getDurationSec()) == Cue.INVALID_SEC) {
            Cue createCueFromCueSegList2 = createCueFromCueSegList(this.mCurrCue.getStartSec(), this.mNextCue.getStartSec());
            if (createCueFromCueSegList2 != null) {
                arrayList.add(createCueFromCueSegList2);
            }
            resetCueSegList();
            Cue cue3 = this.mNextCue;
            this.mCurrCue = cue3;
            this.mNextCue = findNextSentence(cue3);
            appendCueSegList(cue);
            return arrayList;
        }
        if (cue.isOnlyNewLine()) {
            return arrayList;
        }
        appendCueSegList(cue);
        return arrayList;
    }

    private Cue findNextSentence(Cue cue) {
        if (cue == null) {
            return this.mCueIter.next();
        }
        double startSec = cue.getStartSec() + cue.getDurationSec();
        while (this.mCueIter.hasNext()) {
            Cue next = this.mCueIter.next();
            if (next.isOnlyNewLine()) {
                if (this.mSplitByNewline) {
                    if (this.mCueIter.hasNext()) {
                        return this.mCueIter.next();
                    }
                    return null;
                }
            } else if (Cue.doubleCmp(next.getStartSec(), startSec) >= Cue.INVALID_SEC) {
                return next;
            }
        }
        return null;
    }
}

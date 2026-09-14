package com.samsung.android.sbrowser.ext.clientservice.texttrack;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public class TextTrack {
    private static final String TAG = "TextTrack";
    List<Cue> mCues;

    public TextTrack() {
        this.mCues = new ArrayList();
    }

    public TextTrack(List<Cue> list) {
        this();
        this.mCues = list;
    }

    public void addCue(Cue cue) {
        this.mCues.add(cue);
    }

    public Iterator<CueSeg> cueSegIterator() {
        return new CueSegIter();
    }

    public Iterator<Cue> iterator() {
        return this.mCues.iterator();
    }

    public long size() {
        return this.mCues.size();
    }

    public List<Cue> getCues() {
        return this.mCues;
    }

    /* loaded from: classes.dex */
    class CueSegIter implements Iterator<CueSeg> {
        Iterator<Cue> mCueIter;
        Iterator<CueSeg> mCueSegIter;

        CueSegIter() {
            Iterator<Cue> it = TextTrack.this.iterator();
            this.mCueIter = it;
            if (it.hasNext()) {
                this.mCueSegIter = this.mCueIter.next().iterator();
            } else {
                this.mCueIter = null;
                this.mCueSegIter = null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Iterator<CueSeg> it;
            if (this.mCueIter == null || (it = this.mCueSegIter) == null) {
                return false;
            }
            if (it.hasNext()) {
                return true;
            }
            return this.mCueIter.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CueSeg next() {
            Iterator<CueSeg> it;
            if (this.mCueIter != null && (it = this.mCueSegIter) != null) {
                if (it.hasNext()) {
                    return this.mCueSegIter.next();
                }
                if (this.mCueIter.hasNext()) {
                    Iterator<CueSeg> it2 = this.mCueIter.next().iterator();
                    this.mCueSegIter = it2;
                    return it2.next();
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Log.e(TextTrack.TAG, "remove not supported");
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super CueSeg> consumer) {
            Log.e(TextTrack.TAG, "forEachRemaining not supported");
        }
    }
}

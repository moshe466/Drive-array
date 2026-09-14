package com.samsung.android.sbrowser.ext.clientservice.sentence_splitter;

import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import java.util.List;

/* loaded from: classes.dex */
public interface SentenceSplitter {
    List<Cue> addMoreCueForSplit(Cue cue) throws Exception;

    boolean initSplitter() throws Exception;
}

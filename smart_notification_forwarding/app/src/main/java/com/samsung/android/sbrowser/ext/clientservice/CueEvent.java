package com.samsung.android.sbrowser.ext.clientservice;

import com.samsung.android.sbrowser.ext.clientservice.six.SixEvent;
import com.samsung.android.sbrowser.ext.clientservice.six.SixObject;
import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import java.util.ArrayList;

/* compiled from: LiveCaption.java */
/* loaded from: classes.dex */
class CueEvent extends SixEvent {
    public static final long MAX_CUEEVENT_LEN = 819200;
    static final String NAME = "cueEvent";
    private static final String TAG = "CueEvent";
    ArrayList<Cue> mCues;
    Exception mEx;

    @Override // com.samsung.android.sbrowser.ext.clientservice.six.SixEvent
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CueEvent(ArrayList<Cue> arrayList, Exception exc) {
        this.mCues = arrayList;
        this.mEx = exc;
    }

    @Override // com.samsung.android.sbrowser.ext.clientservice.six.SixEvent
    public ArrayList<String> toMsg() {
        Exception exc = this.mEx;
        if (exc != null) {
            return SixObject.toMsg(false, exc.toString());
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mCues.size(); i++) {
            arrayList.add(this.mCues.get(i).getText());
            arrayList.add(Double.toString(this.mCues.get(i).getStartSec()));
            arrayList.add(Double.toString(this.mCues.get(i).getEndSec()));
            arrayList.add(this.mCues.get(i).getIsTrans() ? "true" : "false");
        }
        return SixObject.toMsg(true, (ArrayList<String>) arrayList);
    }
}

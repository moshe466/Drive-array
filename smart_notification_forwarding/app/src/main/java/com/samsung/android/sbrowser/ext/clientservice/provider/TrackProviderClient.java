package com.samsung.android.sbrowser.ext.clientservice.provider;

import com.samsung.android.sbrowser.ext.clientservice.texttrack.Cue;
import java.util.ArrayList;

/* loaded from: classes.dex */
public interface TrackProviderClient {
    void initTrackProviderClient(TrackProvider trackProvider);

    void onMoreTrackData(ArrayList<Cue> arrayList);

    void onTrackProviderError(Exception exc);

    void resetTrackProviderClient();

    void resetTrackProviderClientSession(boolean z);
}

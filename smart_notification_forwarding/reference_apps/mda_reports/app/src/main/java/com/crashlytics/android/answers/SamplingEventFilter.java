package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
class SamplingEventFilter implements EventFilter {
    static final Set<SessionEvent.Type> b = new HashSet<SessionEvent.Type>() { // from class: com.crashlytics.android.answers.SamplingEventFilter.1
        {
            add(SessionEvent.Type.START);
            add(SessionEvent.Type.RESUME);
            add(SessionEvent.Type.PAUSE);
            add(SessionEvent.Type.STOP);
        }
    };
    final int a;

    public SamplingEventFilter(int i) {
        this.a = i;
    }

    @Override // com.crashlytics.android.answers.EventFilter
    public boolean skipEvent(SessionEvent sessionEvent) {
        return (b.contains(sessionEvent.type) && sessionEvent.sessionEventMetadata.betaDeviceToken == null) && (Math.abs(sessionEvent.sessionEventMetadata.installationId.hashCode() % this.a) != 0);
    }
}

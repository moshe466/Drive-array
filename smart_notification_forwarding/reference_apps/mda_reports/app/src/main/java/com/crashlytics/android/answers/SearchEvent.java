package com.crashlytics.android.answers;

import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;

/* loaded from: classes.dex */
public class SearchEvent extends PredefinedEvent<SearchEvent> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.crashlytics.android.answers.PredefinedEvent
    public String c() {
        return FirebaseAnalytics.Event.SEARCH;
    }

    public SearchEvent putQuery(String str) {
        this.c.a(SearchIntents.EXTRA_QUERY, str);
        return this;
    }
}

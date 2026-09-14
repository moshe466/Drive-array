package com.google.firebase.inappmessaging.internal;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* loaded from: classes2.dex */
final /* synthetic */ class DataCollectionHelper$$Lambda$1 implements EventHandler {
    private final DataCollectionHelper arg$1;

    private DataCollectionHelper$$Lambda$1(DataCollectionHelper dataCollectionHelper) {
        this.arg$1 = dataCollectionHelper;
    }

    public static EventHandler lambdaFactory$(DataCollectionHelper dataCollectionHelper) {
        return new DataCollectionHelper$$Lambda$1(dataCollectionHelper);
    }

    @Override // com.google.firebase.events.EventHandler
    public void handle(Event event) {
        DataCollectionHelper.a(this.arg$1, event);
    }
}

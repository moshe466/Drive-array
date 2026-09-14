package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$20 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$20 instance = new InAppMessageStreamManager$$Lambda$20();

    private InAppMessageStreamManager$$Lambda$20() {
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        InAppMessageStreamManager.a((Throwable) obj);
    }
}

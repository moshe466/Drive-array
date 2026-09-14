package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$27 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$27 instance = new InAppMessageStreamManager$$Lambda$27();

    private InAppMessageStreamManager$$Lambda$27() {
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        InAppMessageStreamManager.f((Throwable) obj);
    }
}

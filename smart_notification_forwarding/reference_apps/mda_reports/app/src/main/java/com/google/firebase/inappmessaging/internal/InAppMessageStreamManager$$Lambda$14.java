package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$14 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$14 instance = new InAppMessageStreamManager$$Lambda$14();

    private InAppMessageStreamManager$$Lambda$14() {
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        InAppMessageStreamManager.c((Throwable) obj);
    }
}

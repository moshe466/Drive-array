package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class InAppMessageStreamManager$$Lambda$1 implements Consumer {
    private static final InAppMessageStreamManager$$Lambda$1 instance = new InAppMessageStreamManager$$Lambda$1();

    private InAppMessageStreamManager$$Lambda$1() {
    }

    @Override // io.reactivex.functions.Consumer
    public void accept(Object obj) {
        InAppMessageStreamManager.a((String) obj);
    }
}

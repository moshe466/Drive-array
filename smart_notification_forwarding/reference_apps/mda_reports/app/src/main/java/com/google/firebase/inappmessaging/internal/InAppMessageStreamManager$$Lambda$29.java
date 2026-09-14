package com.google.firebase.inappmessaging.internal;

import io.reactivex.functions.Predicate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class InAppMessageStreamManager$$Lambda$29 implements Predicate {
    private static final InAppMessageStreamManager$$Lambda$29 instance = new InAppMessageStreamManager$$Lambda$29();

    private InAppMessageStreamManager$$Lambda$29() {
    }

    @Override // io.reactivex.functions.Predicate
    public boolean test(Object obj) {
        return InAppMessageStreamManager.a((Boolean) obj);
    }
}

package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class j0 implements z2.c {

    /* renamed from: a, reason: collision with root package name */
    private final CountDownLatch f7106a;

    private j0(CountDownLatch countDownLatch) {
        this.f7106a = countDownLatch;
    }

    public static z2.c b(CountDownLatch countDownLatch) {
        return new j0(countDownLatch);
    }

    @Override // z2.c
    public Object a(z2.l lVar) {
        return k0.g(this.f7106a, lVar);
    }
}

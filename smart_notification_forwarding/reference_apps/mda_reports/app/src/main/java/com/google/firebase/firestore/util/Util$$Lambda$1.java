package com.google.firebase.firestore.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class Util$$Lambda$1 implements Runnable {
    private final RuntimeException arg$1;

    private Util$$Lambda$1(RuntimeException runtimeException) {
        this.arg$1 = runtimeException;
    }

    public static Runnable lambdaFactory$(RuntimeException runtimeException) {
        return new Util$$Lambda$1(runtimeException);
    }

    @Override // java.lang.Runnable
    public void run() {
        Util.a(this.arg$1);
        throw null;
    }
}

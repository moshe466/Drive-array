package com.google.firebase.firestore.remote;

/* loaded from: classes2.dex */
final /* synthetic */ class AbstractStream$$Lambda$1 implements Runnable {
    private final AbstractStream arg$1;

    private AbstractStream$$Lambda$1(AbstractStream abstractStream) {
        this.arg$1 = abstractStream;
    }

    public static Runnable lambdaFactory$(AbstractStream abstractStream) {
        return new AbstractStream$$Lambda$1(abstractStream);
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractStream.e(this.arg$1);
    }
}

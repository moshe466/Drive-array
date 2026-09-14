package com.google.firebase.functions;

import android.content.Context;

/* loaded from: classes2.dex */
final /* synthetic */ class FirebaseFunctions$$Lambda$1 implements Runnable {
    private final Context arg$1;

    private FirebaseFunctions$$Lambda$1(Context context) {
        this.arg$1 = context;
    }

    public static Runnable lambdaFactory$(Context context) {
        return new FirebaseFunctions$$Lambda$1(context);
    }

    @Override // java.lang.Runnable
    public void run() {
        FirebaseFunctions.a(this.arg$1);
    }
}

package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* loaded from: classes.dex */
final class g8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ ComponentName f6075f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ e8 f6076g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g8(e8 e8Var, ComponentName componentName) {
        this.f6076g = e8Var;
        this.f6075f = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6076g.f6000c.D(this.f6075f);
    }
}

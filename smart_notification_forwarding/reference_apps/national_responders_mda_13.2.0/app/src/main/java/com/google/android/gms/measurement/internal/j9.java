package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class j9 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f6143f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ Bundle f6144g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ h9 f6145h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j9(h9 h9Var, String str, Bundle bundle) {
        this.f6145h = h9Var;
        this.f6143f = str;
        this.f6144g = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6145h.f6090a.r(this.f6145h.f6090a.h0().F(this.f6143f, "_err", this.f6144g, "auto", this.f6145h.f6090a.f().a(), false, false, false), this.f6143f);
    }
}

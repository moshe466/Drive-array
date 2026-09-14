package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class g4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6065a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f6066b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6067c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f6068d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ e4 f6069e;

    public g4(e4 e4Var, String str, boolean z10) {
        this.f6069e = e4Var;
        b2.p.g(str);
        this.f6065a = str;
        this.f6066b = z10;
    }

    public final void a(boolean z10) {
        SharedPreferences.Editor edit = this.f6069e.E().edit();
        edit.putBoolean(this.f6065a, z10);
        edit.apply();
        this.f6068d = z10;
    }

    public final boolean b() {
        if (!this.f6067c) {
            this.f6067c = true;
            this.f6068d = this.f6069e.E().getBoolean(this.f6065a, this.f6066b);
        }
        return this.f6068d;
    }
}

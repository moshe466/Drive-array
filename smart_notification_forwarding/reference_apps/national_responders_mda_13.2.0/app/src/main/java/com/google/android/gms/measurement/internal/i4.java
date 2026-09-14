package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class i4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6110a;

    /* renamed from: b, reason: collision with root package name */
    private final long f6111b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6112c;

    /* renamed from: d, reason: collision with root package name */
    private long f6113d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ e4 f6114e;

    public i4(e4 e4Var, String str, long j10) {
        this.f6114e = e4Var;
        b2.p.g(str);
        this.f6110a = str;
        this.f6111b = j10;
    }

    public final long a() {
        if (!this.f6112c) {
            this.f6112c = true;
            this.f6113d = this.f6114e.E().getLong(this.f6110a, this.f6111b);
        }
        return this.f6113d;
    }

    public final void b(long j10) {
        SharedPreferences.Editor edit = this.f6114e.E().edit();
        edit.putLong(this.f6110a, j10);
        edit.apply();
        this.f6113d = j10;
    }
}

package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;

/* loaded from: classes.dex */
public final class l4 {

    /* renamed from: a, reason: collision with root package name */
    private final String f6186a;

    /* renamed from: b, reason: collision with root package name */
    private final String f6187b;

    /* renamed from: c, reason: collision with root package name */
    private final String f6188c;

    /* renamed from: d, reason: collision with root package name */
    private final long f6189d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ e4 f6190e;

    private l4(e4 e4Var, String str, long j10) {
        this.f6190e = e4Var;
        b2.p.g(str);
        b2.p.a(j10 > 0);
        this.f6186a = String.valueOf(str).concat(":start");
        this.f6187b = String.valueOf(str).concat(":count");
        this.f6188c = String.valueOf(str).concat(":value");
        this.f6189d = j10;
    }

    private final void c() {
        this.f6190e.c();
        long a10 = this.f6190e.f().a();
        SharedPreferences.Editor edit = this.f6190e.E().edit();
        edit.remove(this.f6187b);
        edit.remove(this.f6188c);
        edit.putLong(this.f6186a, a10);
        edit.apply();
    }

    private final long d() {
        return this.f6190e.E().getLong(this.f6186a, 0L);
    }

    public final Pair<String, Long> a() {
        long abs;
        this.f6190e.c();
        this.f6190e.c();
        long d10 = d();
        if (d10 == 0) {
            c();
            abs = 0;
        } else {
            abs = Math.abs(d10 - this.f6190e.f().a());
        }
        long j10 = this.f6189d;
        if (abs < j10) {
            return null;
        }
        if (abs > (j10 << 1)) {
            c();
            return null;
        }
        String string = this.f6190e.E().getString(this.f6188c, null);
        long j11 = this.f6190e.E().getLong(this.f6187b, 0L);
        c();
        return (string == null || j11 <= 0) ? e4.D : new Pair<>(string, Long.valueOf(j11));
    }

    public final void b(String str, long j10) {
        this.f6190e.c();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = "";
        }
        long j11 = this.f6190e.E().getLong(this.f6187b, 0L);
        if (j11 <= 0) {
            SharedPreferences.Editor edit = this.f6190e.E().edit();
            edit.putString(this.f6188c, str);
            edit.putLong(this.f6187b, 1L);
            edit.apply();
            return;
        }
        long j12 = j11 + 1;
        boolean z10 = (this.f6190e.k().H0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j12;
        SharedPreferences.Editor edit2 = this.f6190e.E().edit();
        if (z10) {
            edit2.putString(this.f6188c, str);
        }
        edit2.putLong(this.f6187b, j12);
        edit2.apply();
    }
}

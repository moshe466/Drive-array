package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;

/* loaded from: classes.dex */
public final class y2 {

    /* renamed from: a, reason: collision with root package name */
    final Uri f5701a;

    /* renamed from: b, reason: collision with root package name */
    final String f5702b;

    /* renamed from: c, reason: collision with root package name */
    final String f5703c;

    public y2(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    private y2(String str, Uri uri, String str2, String str3, boolean z10, boolean z11, boolean z12, boolean z13, i3<Context, Boolean> i3Var) {
        this.f5701a = uri;
        this.f5702b = str2;
        this.f5703c = str3;
    }

    public final t2<Double> a(String str, double d10) {
        t2<Double> i10;
        i10 = t2.i(this, str, -3.0d, true);
        return i10;
    }

    public final t2<Long> b(String str, long j10) {
        t2<Long> j11;
        j11 = t2.j(this, str, j10, true);
        return j11;
    }

    public final t2<String> c(String str, String str2) {
        t2<String> k10;
        k10 = t2.k(this, str, str2, true);
        return k10;
    }

    public final t2<Boolean> d(String str, boolean z10) {
        t2<Boolean> l10;
        l10 = t2.l(this, str, z10, true);
        return l10;
    }
}

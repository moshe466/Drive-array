package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class z3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final a4 f6653f;

    /* renamed from: g, reason: collision with root package name */
    private final int f6654g;

    /* renamed from: h, reason: collision with root package name */
    private final Throwable f6655h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f6656i;

    /* renamed from: j, reason: collision with root package name */
    private final String f6657j;

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, List<String>> f6658k;

    private z3(String str, a4 a4Var, int i10, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        b2.p.k(a4Var);
        this.f6653f = a4Var;
        this.f6654g = i10;
        this.f6655h = th;
        this.f6656i = bArr;
        this.f6657j = str;
        this.f6658k = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6653f.a(this.f6657j, this.f6654g, this.f6655h, this.f6656i, this.f6658k);
    }
}

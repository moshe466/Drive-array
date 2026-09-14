package com.google.android.gms.measurement.internal;

/* loaded from: classes.dex */
public final class l3<V> {

    /* renamed from: h, reason: collision with root package name */
    private static final Object f6178h = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final String f6179a;

    /* renamed from: b, reason: collision with root package name */
    private final k3<V> f6180b;

    /* renamed from: c, reason: collision with root package name */
    private final V f6181c;

    /* renamed from: d, reason: collision with root package name */
    private final V f6182d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f6183e;

    /* renamed from: f, reason: collision with root package name */
    private volatile V f6184f;

    /* renamed from: g, reason: collision with root package name */
    private volatile V f6185g;

    private l3(String str, V v10, V v11, k3<V> k3Var) {
        this.f6183e = new Object();
        this.f6184f = null;
        this.f6185g = null;
        this.f6179a = str;
        this.f6181c = v10;
        this.f6182d = v11;
        this.f6180b = k3Var;
    }

    public final V a(V v10) {
        synchronized (this.f6183e) {
        }
        if (v10 != null) {
            return v10;
        }
        if (j3.f6131a == null) {
            return this.f6181c;
        }
        synchronized (f6178h) {
            if (ea.a()) {
                return this.f6185g == null ? this.f6181c : this.f6185g;
            }
            try {
                for (l3 l3Var : s.q0()) {
                    if (ea.a()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v11 = null;
                    try {
                        k3<V> k3Var = l3Var.f6180b;
                        if (k3Var != null) {
                            v11 = k3Var.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (f6178h) {
                        l3Var.f6185g = v11;
                    }
                }
            } catch (SecurityException unused2) {
            }
            k3<V> k3Var2 = this.f6180b;
            if (k3Var2 == null) {
                return this.f6181c;
            }
            try {
                return k3Var2.zza();
            } catch (IllegalStateException unused3) {
                return this.f6181c;
            } catch (SecurityException unused4) {
                return this.f6181c;
            }
        }
    }

    public final String b() {
        return this.f6179a;
    }
}

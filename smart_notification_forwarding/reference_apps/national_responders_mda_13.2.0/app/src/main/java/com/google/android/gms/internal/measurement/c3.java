package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class c3 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5227a;

    public c3(f3 f3Var) {
        n3.c(f3Var, "BuildInfo must be non-null");
        this.f5227a = !f3Var.zza();
    }

    public final boolean a(String str) {
        n3.c(str, "flagName must not be null");
        if (this.f5227a) {
            return e3.f5283a.zza().a(str);
        }
        return true;
    }
}

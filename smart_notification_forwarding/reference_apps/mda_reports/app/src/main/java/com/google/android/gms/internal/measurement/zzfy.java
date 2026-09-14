package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes.dex */
abstract class zzfy {
    private static final zzfy zza;
    private static final zzfy zzb;

    static {
        zzfx zzfxVar = null;
        zza = new zzga();
        zzb = new zzfz();
    }

    private zzfy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfy a() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfy b() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);
}

package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes.dex */
abstract class zzdso {
    private static final zzdso zzhoi;
    private static final zzdso zzhoj;

    static {
        zzdsn zzdsnVar = null;
        zzhoi = new zzdsq();
        zzhoj = new zzdsp();
    }

    private zzdso() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdso a() {
        return zzhoi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdso b() {
        return zzhoj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);
}

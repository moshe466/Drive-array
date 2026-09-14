package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzmp extends zzhg {
    private static final Object zzbcy = new Object();
    private final boolean zzagu;
    private final boolean zzagv;
    private final long zzbcz;
    private final long zzbda;
    private final long zzbdb;
    private final long zzbdc;

    private zzmp(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbcz = j;
        this.zzbda = j2;
        this.zzbdb = 0L;
        this.zzbdc = 0L;
        this.zzagu = z;
        this.zzagv = false;
    }

    public zzmp(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final zzhi zza(int i, zzhi zzhiVar, boolean z) {
        zzoc.zzc(i, 0, 1);
        Object obj = z ? zzbcy : null;
        return zzhiVar.zza(obj, obj, 0, this.zzbcz, 0L, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final zzhl zza(int i, zzhl zzhlVar, boolean z, long j) {
        zzoc.zzc(i, 0, 1);
        boolean z2 = this.zzagu;
        long j2 = this.zzbda;
        zzhlVar.zzagi = null;
        zzhlVar.zzags = -9223372036854775807L;
        zzhlVar.zzagt = -9223372036854775807L;
        zzhlVar.zzagu = z2;
        zzhlVar.zzagv = false;
        zzhlVar.zzagy = 0L;
        zzhlVar.zzagj = j2;
        zzhlVar.zzagw = 0;
        zzhlVar.zzagx = 0;
        zzhlVar.zzagz = 0L;
        return zzhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final int zzc(Object obj) {
        return zzbcy.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final int zzev() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final int zzew() {
        return 1;
    }
}

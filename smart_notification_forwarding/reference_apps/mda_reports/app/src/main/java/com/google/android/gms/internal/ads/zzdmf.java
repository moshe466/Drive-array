package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmf extends zzdrt<zzdmf, zza> implements zzdtg {
    private static volatile zzdtn<zzdmf> zzdz;
    private static final zzdmf zzhbj;
    private zzdng zzhbi;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmf, zza> implements zzdtg {
        private zza() {
            super(zzdmf.zzhbj);
        }

        /* synthetic */ zza(zzdme zzdmeVar) {
            this();
        }
    }

    static {
        zzdmf zzdmfVar = new zzdmf();
        zzhbj = zzdmfVar;
        zzdrt.a((Class<zzdmf>) zzdmf.class, zzdmfVar);
    }

    private zzdmf() {
    }

    public static zzdmf zzaud() {
        return zzhbj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdme zzdmeVar = null;
        switch (zzdme.a[i - 1]) {
            case 1:
                return new zzdmf();
            case 2:
                return new zza(zzdmeVar);
            case 3:
                return zzdrt.a(zzhbj, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzhbi"});
            case 4:
                return zzhbj;
            case 5:
                zzdtn<zzdmf> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmf.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhbj);
                            zzdz = zzdtnVar;
                        }
                    }
                }
                return zzdtnVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzdng zzauc() {
        zzdng zzdngVar = this.zzhbi;
        return zzdngVar == null ? zzdng.zzavo() : zzdngVar;
    }
}

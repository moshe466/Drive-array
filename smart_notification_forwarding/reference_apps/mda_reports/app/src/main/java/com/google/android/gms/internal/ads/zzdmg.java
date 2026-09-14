package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmg extends zzdrt<zzdmg, zza> implements zzdtg {
    private static volatile zzdtn<zzdmg> zzdz;
    private static final zzdmg zzhbl;
    private zzdmj zzhbk;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmg, zza> implements zzdtg {
        private zza() {
            super(zzdmg.zzhbl);
        }

        /* synthetic */ zza(zzdmh zzdmhVar) {
            this();
        }
    }

    static {
        zzdmg zzdmgVar = new zzdmg();
        zzhbl = zzdmgVar;
        zzdrt.a((Class<zzdmg>) zzdmg.class, zzdmgVar);
    }

    private zzdmg() {
    }

    public static zzdmg zzak(zzdqk zzdqkVar) {
        return (zzdmg) zzdrt.a(zzhbl, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmh zzdmhVar = null;
        switch (zzdmh.a[i - 1]) {
            case 1:
                return new zzdmg();
            case 2:
                return new zza(zzdmhVar);
            case 3:
                return zzdrt.a(zzhbl, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzhbk"});
            case 4:
                return zzhbl;
            case 5:
                zzdtn<zzdmg> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmg.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhbl);
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

    public final zzdmj zzauf() {
        zzdmj zzdmjVar = this.zzhbk;
        return zzdmjVar == null ? zzdmj.zzauk() : zzdmjVar;
    }
}

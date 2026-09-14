package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlk extends zzdrt<zzdlk, zza> implements zzdtg {
    private static volatile zzdtn<zzdlk> zzdz;
    private static final zzdlk zzhar;
    private int zzhaf;
    private zzdln zzhap;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlk, zza> implements zzdtg {
        private zza() {
            super(zzdlk.zzhar);
        }

        /* synthetic */ zza(zzdll zzdllVar) {
            this();
        }
    }

    static {
        zzdlk zzdlkVar = new zzdlk();
        zzhar = zzdlkVar;
        zzdrt.a((Class<zzdlk>) zzdlk.class, zzdlkVar);
    }

    private zzdlk() {
    }

    public static zzdlk zzatl() {
        return zzhar;
    }

    public static zzdlk zzz(zzdqk zzdqkVar) {
        return (zzdlk) zzdrt.a(zzhar, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdll zzdllVar = null;
        switch (zzdll.a[i - 1]) {
            case 1:
                return new zzdlk();
            case 2:
                return new zza(zzdllVar);
            case 3:
                return zzdrt.a(zzhar, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhap", "zzhaf"});
            case 4:
                return zzhar;
            case 5:
                zzdtn<zzdlk> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlk.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhar);
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

    public final int getKeySize() {
        return this.zzhaf;
    }

    public final zzdln zzath() {
        zzdln zzdlnVar = this.zzhap;
        return zzdlnVar == null ? zzdln.zzato() : zzdlnVar;
    }
}

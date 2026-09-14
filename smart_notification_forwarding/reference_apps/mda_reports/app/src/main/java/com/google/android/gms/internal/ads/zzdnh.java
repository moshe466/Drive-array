package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

@Deprecated
/* loaded from: classes.dex */
public final class zzdnh extends zzdrt<zzdnh, zza> implements zzdtg {
    private static volatile zzdtn<zzdnh> zzdz;
    private static final zzdnh zzhdp;
    private int zzhdm;
    private boolean zzhdn;
    private String zzhdl = "";
    private String zzhcs = "";
    private String zzhdo = "";

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdnh, zza> implements zzdtg {
        private zza() {
            super(zzdnh.zzhdp);
        }

        /* synthetic */ zza(zzdni zzdniVar) {
            this();
        }
    }

    static {
        zzdnh zzdnhVar = new zzdnh();
        zzhdp = zzdnhVar;
        zzdrt.a((Class<zzdnh>) zzdnh.class, zzdnhVar);
    }

    private zzdnh() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdni zzdniVar = null;
        switch (zzdni.a[i - 1]) {
            case 1:
                return new zzdnh();
            case 2:
                return new zza(zzdniVar);
            case 3:
                return zzdrt.a(zzhdp, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzhdl", "zzhcs", "zzhdm", "zzhdn", "zzhdo"});
            case 4:
                return zzhdp;
            case 5:
                zzdtn<zzdnh> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdnh.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhdp);
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

    public final String zzavi() {
        return this.zzhcs;
    }

    public final String zzavq() {
        return this.zzhdl;
    }

    public final int zzavr() {
        return this.zzhdm;
    }

    public final boolean zzavs() {
        return this.zzhdn;
    }

    public final String zzavt() {
        return this.zzhdo;
    }
}

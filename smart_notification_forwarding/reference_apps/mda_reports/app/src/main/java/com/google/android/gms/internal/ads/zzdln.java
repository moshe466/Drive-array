package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdln extends zzdrt<zzdln, zza> implements zzdtg {
    private static volatile zzdtn<zzdln> zzdz;
    private static final zzdln zzhat;
    private int zzhas;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdln, zza> implements zzdtg {
        private zza() {
            super(zzdln.zzhat);
        }

        /* synthetic */ zza(zzdlm zzdlmVar) {
            this();
        }
    }

    static {
        zzdln zzdlnVar = new zzdln();
        zzhat = zzdlnVar;
        zzdrt.a((Class<zzdln>) zzdln.class, zzdlnVar);
    }

    private zzdln() {
    }

    public static zzdln zzato() {
        return zzhat;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdlm zzdlmVar = null;
        switch (zzdlm.a[i - 1]) {
            case 1:
                return new zzdln();
            case 2:
                return new zza(zzdlmVar);
            case 3:
                return zzdrt.a(zzhat, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzhas"});
            case 4:
                return zzhat;
            case 5:
                zzdtn<zzdln> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdln.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhat);
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

    public final int zzatn() {
        return this.zzhas;
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzfy extends zzdrt<zzfy, zza> implements zzdtg {
    private static final zzfy zzaan;
    private static volatile zzdtn<zzfy> zzdz;
    private zzfz zzaak;
    private zzdqk zzaal;
    private zzdqk zzaam;
    private int zzdl;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzfy, zza> implements zzdtg {
        private zza() {
            super(zzfy.zzaan);
        }

        /* synthetic */ zza(zzfx zzfxVar) {
            this();
        }
    }

    static {
        zzfy zzfyVar = new zzfy();
        zzaan = zzfyVar;
        zzdrt.a((Class<zzfy>) zzfy.class, zzfyVar);
    }

    private zzfy() {
        zzdqk zzdqkVar = zzdqk.zzhhx;
        this.zzaal = zzdqkVar;
        this.zzaam = zzdqkVar;
    }

    public static zzfy zza(zzdqk zzdqkVar, zzdrg zzdrgVar) {
        return (zzfy) zzdrt.a(zzaan, zzdqkVar, zzdrgVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzfx zzfxVar = null;
        switch (zzfx.a[i - 1]) {
            case 1:
                return new zzfy();
            case 2:
                return new zza(zzfxVar);
            case 3:
                return zzdrt.a(zzaan, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzaak", "zzaal", "zzaam"});
            case 4:
                return zzaan;
            case 5:
                zzdtn<zzfy> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzfy.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzaan);
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

    public final zzfz zzct() {
        zzfz zzfzVar = this.zzaak;
        return zzfzVar == null ? zzfz.zzdd() : zzfzVar;
    }

    public final zzdqk zzcu() {
        return this.zzaal;
    }

    public final zzdqk zzcv() {
        return this.zzaam;
    }
}

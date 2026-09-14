package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlg extends zzdrt<zzdlg, zza> implements zzdtg {
    private static volatile zzdtn<zzdlg> zzdz;
    private static final zzdlg zzhao;
    private zzdlk zzham;
    private zzdmw zzhan;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlg, zza> implements zzdtg {
        private zza() {
            super(zzdlg.zzhao);
        }

        /* synthetic */ zza(zzdlh zzdlhVar) {
            this();
        }
    }

    static {
        zzdlg zzdlgVar = new zzdlg();
        zzhao = zzdlgVar;
        zzdrt.a((Class<zzdlg>) zzdlg.class, zzdlgVar);
    }

    private zzdlg() {
    }

    public static zzdlg zzx(zzdqk zzdqkVar) {
        return (zzdlg) zzdrt.a(zzhao, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdlh zzdlhVar = null;
        switch (zzdlh.a[i - 1]) {
            case 1:
                return new zzdlg();
            case 2:
                return new zza(zzdlhVar);
            case 3:
                return zzdrt.a(zzhao, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzham", "zzhan"});
            case 4:
                return zzhao;
            case 5:
                zzdtn<zzdlg> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlg.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhao);
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

    public final zzdlk zzate() {
        zzdlk zzdlkVar = this.zzham;
        return zzdlkVar == null ? zzdlk.zzatl() : zzdlkVar;
    }

    public final zzdmw zzatf() {
        zzdmw zzdmwVar = this.zzhan;
        return zzdmwVar == null ? zzdmw.zzavd() : zzdmwVar;
    }
}

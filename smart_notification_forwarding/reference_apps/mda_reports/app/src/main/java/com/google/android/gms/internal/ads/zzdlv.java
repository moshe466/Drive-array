package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlv extends zzdrt<zzdlv, zza> implements zzdtg {
    private static volatile zzdtn<zzdlv> zzdz;
    private static final zzdlv zzhay;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlv, zza> implements zzdtg {
        private zza() {
            super(zzdlv.zzhay);
        }

        /* synthetic */ zza(zzdlu zzdluVar) {
            this();
        }

        public final zza zzag(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlv) this.a).zzs(zzdqkVar);
            return this;
        }

        public final zza zzeg(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlv) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdlv zzdlvVar = new zzdlv();
        zzhay = zzdlvVar;
        zzdrt.a((Class<zzdlv>) zzdlv.class, zzdlvVar);
    }

    private zzdlv() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    public static zzdlv zzae(zzdqk zzdqkVar) {
        return (zzdlv) zzdrt.a(zzhay, zzdqkVar);
    }

    public static zza zzatw() {
        return zzhay.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdlu zzdluVar = null;
        switch (zzdlu.a[i - 1]) {
            case 1:
                return new zzdlv();
            case 2:
                return new zza(zzdluVar);
            case 3:
                return zzdrt.a(zzhay, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhaa", "zzhab"});
            case 4:
                return zzhay;
            case 5:
                zzdtn<zzdlv> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlv.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhay);
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

    public final int getVersion() {
        return this.zzhaa;
    }

    public final zzdqk zzass() {
        return this.zzhab;
    }
}

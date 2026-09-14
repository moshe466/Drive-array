package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdnz extends zzdrt<zzdnz, zza> implements zzdtg {
    private static volatile zzdtn<zzdnz> zzdz;
    private static final zzdnz zzhet;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdnz, zza> implements zzdtg {
        private zza() {
            super(zzdnz.zzhet);
        }

        /* synthetic */ zza(zzdoa zzdoaVar) {
            this();
        }

        public final zza zzbc(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdnz) this.a).zzs(zzdqkVar);
            return this;
        }

        public final zza zzex(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdnz) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdnz zzdnzVar = new zzdnz();
        zzhet = zzdnzVar;
        zzdrt.a((Class<zzdnz>) zzdnz.class, zzdnzVar);
    }

    private zzdnz() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    public static zza zzawx() {
        return zzhet.b();
    }

    public static zzdnz zzbb(zzdqk zzdqkVar) {
        return (zzdnz) zzdrt.a(zzhet, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdoa zzdoaVar = null;
        switch (zzdoa.a[i - 1]) {
            case 1:
                return new zzdnz();
            case 2:
                return new zza(zzdoaVar);
            case 3:
                return zzdrt.a(zzhet, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzhaa", "zzhab"});
            case 4:
                return zzhet;
            case 5:
                zzdtn<zzdnz> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdnz.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhet);
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

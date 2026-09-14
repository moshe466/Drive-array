package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlj extends zzdrt<zzdlj, zza> implements zzdtg {
    private static volatile zzdtn<zzdlj> zzdz;
    private static final zzdlj zzhaq;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;
    private zzdln zzhap;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlj, zza> implements zzdtg {
        private zza() {
            super(zzdlj.zzhaq);
        }

        /* synthetic */ zza(zzdli zzdliVar) {
            this();
        }

        public final zza zzaa(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlj) this.a).zzs(zzdqkVar);
            return this;
        }

        public final zza zzc(zzdln zzdlnVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlj) this.a).zzb(zzdlnVar);
            return this;
        }

        public final zza zzee(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlj) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdlj zzdljVar = new zzdlj();
        zzhaq = zzdljVar;
        zzdrt.a((Class<zzdlj>) zzdlj.class, zzdljVar);
    }

    private zzdlj() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    public static zza zzati() {
        return zzhaq.b();
    }

    public static zzdlj zzatj() {
        return zzhaq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzdln zzdlnVar) {
        zzdlnVar.getClass();
        this.zzhap = zzdlnVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    public static zzdlj zzy(zzdqk zzdqkVar) {
        return (zzdlj) zzdrt.a(zzhaq, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdli zzdliVar = null;
        switch (zzdli.a[i - 1]) {
            case 1:
                return new zzdlj();
            case 2:
                return new zza(zzdliVar);
            case 3:
                return zzdrt.a(zzhaq, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhaa", "zzhap", "zzhab"});
            case 4:
                return zzhaq;
            case 5:
                zzdtn<zzdlj> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlj.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhaq);
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

    public final zzdln zzath() {
        zzdln zzdlnVar = this.zzhap;
        return zzdlnVar == null ? zzdln.zzato() : zzdlnVar;
    }
}

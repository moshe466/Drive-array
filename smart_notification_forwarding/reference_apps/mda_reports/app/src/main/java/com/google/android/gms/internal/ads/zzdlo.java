package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdlo extends zzdrt<zzdlo, zza> implements zzdtg {
    private static volatile zzdtn<zzdlo> zzdz;
    private static final zzdlo zzhav;
    private int zzhaa;
    private zzdqk zzhab = zzdqk.zzhhx;
    private zzdls zzhau;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdlo, zza> implements zzdtg {
        private zza() {
            super(zzdlo.zzhav);
        }

        /* synthetic */ zza(zzdlp zzdlpVar) {
            this();
        }

        public final zza zzac(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlo) this.a).zzs(zzdqkVar);
            return this;
        }

        public final zza zzb(zzdls zzdlsVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlo) this.a).zza(zzdlsVar);
            return this;
        }

        public final zza zzef(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdlo) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdlo zzdloVar = new zzdlo();
        zzhav = zzdloVar;
        zzdrt.a((Class<zzdlo>) zzdlo.class, zzdloVar);
    }

    private zzdlo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdls zzdlsVar) {
        zzdlsVar.getClass();
        this.zzhau = zzdlsVar;
    }

    public static zzdlo zzab(zzdqk zzdqkVar) {
        return (zzdlo) zzdrt.a(zzhav, zzdqkVar);
    }

    public static zza zzatr() {
        return zzhav.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhab = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdlp zzdlpVar = null;
        switch (zzdlp.a[i - 1]) {
            case 1:
                return new zzdlo();
            case 2:
                return new zza(zzdlpVar);
            case 3:
                return zzdrt.a(zzhav, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzhaa", "zzhau", "zzhab"});
            case 4:
                return zzhav;
            case 5:
                zzdtn<zzdlo> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdlo.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhav);
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

    public final zzdls zzatq() {
        zzdls zzdlsVar = this.zzhau;
        return zzdlsVar == null ? zzdls.zzatu() : zzdlsVar;
    }
}

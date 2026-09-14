package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdmn extends zzdrt<zzdmn, zza> implements zzdtg {
    private static volatile zzdtn<zzdmn> zzdz;
    private static final zzdmn zzhbu;
    private int zzhaa;
    private zzdmj zzhbk;
    private zzdqk zzhbs;
    private zzdqk zzhbt;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdmn, zza> implements zzdtg {
        private zza() {
            super(zzdmn.zzhbu);
        }

        /* synthetic */ zza(zzdmm zzdmmVar) {
            this();
        }

        public final zza zzaq(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmn) this.a).zzan(zzdqkVar);
            return this;
        }

        public final zza zzar(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmn) this.a).zzao(zzdqkVar);
            return this;
        }

        public final zza zzc(zzdmj zzdmjVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmn) this.a).zzb(zzdmjVar);
            return this;
        }

        public final zza zzek(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdmn) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdmn zzdmnVar = new zzdmn();
        zzhbu = zzdmnVar;
        zzdrt.a((Class<zzdmn>) zzdmn.class, zzdmnVar);
    }

    private zzdmn() {
        zzdqk zzdqkVar = zzdqk.zzhhx;
        this.zzhbs = zzdqkVar;
        this.zzhbt = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzan(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhbs = zzdqkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzao(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhbt = zzdqkVar;
    }

    public static zzdmn zzap(zzdqk zzdqkVar) {
        return (zzdmn) zzdrt.a(zzhbu, zzdqkVar);
    }

    public static zza zzaur() {
        return zzhbu.b();
    }

    public static zzdmn zzaus() {
        return zzhbu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(zzdmj zzdmjVar) {
        zzdmjVar.getClass();
        this.zzhbk = zzdmjVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdmm zzdmmVar = null;
        switch (zzdmm.a[i - 1]) {
            case 1:
                return new zzdmn();
            case 2:
                return new zza(zzdmmVar);
            case 3:
                return zzdrt.a(zzhbu, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzhaa", "zzhbk", "zzhbs", "zzhbt"});
            case 4:
                return zzhbu;
            case 5:
                zzdtn<zzdmn> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdmn.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhbu);
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

    public final zzdmj zzauf() {
        zzdmj zzdmjVar = this.zzhbk;
        return zzdmjVar == null ? zzdmj.zzauk() : zzdmjVar;
    }

    public final zzdqk zzaup() {
        return this.zzhbs;
    }

    public final zzdqk zzauq() {
        return this.zzhbt;
    }
}

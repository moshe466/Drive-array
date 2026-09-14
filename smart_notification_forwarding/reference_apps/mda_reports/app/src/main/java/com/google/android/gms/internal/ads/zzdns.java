package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdns extends zzdrt<zzdns, zza> implements zzdtg {
    private static volatile zzdtn<zzdns> zzdz;
    private static final zzdns zzhef;
    private int zzhaa;
    private zzdnt zzhee;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdns, zza> implements zzdtg {
        private zza() {
            super(zzdns.zzhef);
        }

        /* synthetic */ zza(zzdnr zzdnrVar) {
            this();
        }

        public final zza zzb(zzdnt zzdntVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdns) this.a).zza(zzdntVar);
            return this;
        }

        public final zza zzev(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdns) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdns zzdnsVar = new zzdns();
        zzhef = zzdnsVar;
        zzdrt.a((Class<zzdns>) zzdns.class, zzdnsVar);
    }

    private zzdns() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdnt zzdntVar) {
        zzdntVar.getClass();
        this.zzhee = zzdntVar;
    }

    public static zza zzawo() {
        return zzhef.b();
    }

    public static zzdns zzaz(zzdqk zzdqkVar) {
        return (zzdns) zzdrt.a(zzhef, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnr zzdnrVar = null;
        switch (zzdnr.a[i - 1]) {
            case 1:
                return new zzdns();
            case 2:
                return new zza(zzdnrVar);
            case 3:
                return zzdrt.a(zzhef, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhaa", "zzhee"});
            case 4:
                return zzhef;
            case 5:
                zzdtn<zzdns> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdns.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhef);
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

    public final zzdnt zzawn() {
        zzdnt zzdntVar = this.zzhee;
        return zzdntVar == null ? zzdnt.zzaws() : zzdntVar;
    }
}

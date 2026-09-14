package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdno extends zzdrt<zzdno, zza> implements zzdtg {
    private static volatile zzdtn<zzdno> zzdz;
    private static final zzdno zzheb;
    private int zzhaa;
    private zzdnp zzhea;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdno, zza> implements zzdtg {
        private zza() {
            super(zzdno.zzheb);
        }

        /* synthetic */ zza(zzdnn zzdnnVar) {
            this();
        }

        public final zza zzb(zzdnp zzdnpVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdno) this.a).zza(zzdnpVar);
            return this;
        }

        public final zza zzeu(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdno) this.a).setVersion(0);
            return this;
        }
    }

    static {
        zzdno zzdnoVar = new zzdno();
        zzheb = zzdnoVar;
        zzdrt.a((Class<zzdno>) zzdno.class, zzdnoVar);
    }

    private zzdno() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zzhaa = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzdnp zzdnpVar) {
        zzdnpVar.getClass();
        this.zzhea = zzdnpVar;
    }

    public static zza zzawi() {
        return zzheb.b();
    }

    public static zzdno zzax(zzdqk zzdqkVar) {
        return (zzdno) zzdrt.a(zzheb, zzdqkVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnn zzdnnVar = null;
        switch (zzdnn.a[i - 1]) {
            case 1:
                return new zzdno();
            case 2:
                return new zza(zzdnnVar);
            case 3:
                return zzdrt.a(zzheb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzhaa", "zzhea"});
            case 4:
                return zzheb;
            case 5:
                zzdtn<zzdno> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdno.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzheb);
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

    public final zzdnp zzawh() {
        zzdnp zzdnpVar = this.zzhea;
        return zzdnpVar == null ? zzdnp.zzawl() : zzdnpVar;
    }
}

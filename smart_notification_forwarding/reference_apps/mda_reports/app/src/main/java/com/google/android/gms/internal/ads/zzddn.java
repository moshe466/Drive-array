package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzddh;
import com.google.android.gms.internal.ads.zzdrt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class zzddn extends zzdrt<zzddn, zzb> implements zzdtg {
    private static volatile zzdtn<zzddn> zzdz;
    private static final zzddn zzgsw;
    private int zzdl;
    private int zzgst;
    private zzddh zzgsv;
    private String zzdm = "";
    private String zzgsu = "";

    /* loaded from: classes.dex */
    public enum zza implements zzdry {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);

        private static final zzdrx<zza> zzen = new zzddp();
        private final int value;

        zza(int i) {
            this.value = i;
        }

        public static zzdsa zzaf() {
            return zzddo.a;
        }

        public static zza zzdq(int i) {
            if (i == 0) {
                return EVENT_TYPE_UNKNOWN;
            }
            if (i != 1) {
                return null;
            }
            return BLOCKED_IMPRESSION;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
        }

        @Override // com.google.android.gms.internal.ads.zzdry
        public final int zzae() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzdrt.zzb<zzddn, zzb> implements zzdtg {
        private zzb() {
            super(zzddn.zzgsw);
        }

        /* synthetic */ zzb(zzddm zzddmVar) {
            this();
        }

        public final zzb zza(zzddh.zzb zzbVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzddn) this.a).zza((zzddh) zzbVar.zzbaf());
            return this;
        }

        public final zzb zzb(zza zzaVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzddn) this.a).zza(zzaVar);
            return this;
        }

        public final zzb zzgt(String str) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzddn) this.a).zzn(str);
            return this;
        }
    }

    static {
        zzddn zzddnVar = new zzddn();
        zzgsw = zzddnVar;
        zzdrt.a((Class<zzddn>) zzddn.class, zzddnVar);
    }

    private zzddn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzddh zzddhVar) {
        zzddhVar.getClass();
        this.zzgsv = zzddhVar;
        this.zzdl |= 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        this.zzgst = zzaVar.zzae();
        this.zzdl |= 1;
    }

    public static zzb zzaqn() {
        return zzgsw.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzn(String str) {
        str.getClass();
        this.zzdl |= 2;
        this.zzdm = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzddm zzddmVar = null;
        switch (zzddm.a[i - 1]) {
            case 1:
                return new zzddn();
            case 2:
                return new zzb(zzddmVar);
            case 3:
                return zzdrt.a(zzgsw, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003", new Object[]{"zzdl", "zzgst", zza.zzaf(), "zzdm", "zzgsu", "zzgsv"});
            case 4:
                return zzgsw;
            case 5:
                zzdtn<zzddn> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzddn.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzgsw);
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
}

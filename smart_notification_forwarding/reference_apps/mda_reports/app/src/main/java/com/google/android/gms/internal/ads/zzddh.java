package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class zzddh extends zzdrt<zzddh, zzb> implements zzdtg {
    private static volatile zzdtn<zzddh> zzdz;
    private static final zzdsc<Integer, zza> zzgsj = new zzddj();
    private static final zzddh zzgsn;
    private int zzdl;
    private zzdrz zzgsi = zzdrt.c();
    private String zzgsk = "";
    private String zzgsl = "";
    private String zzgsm = "";

    /* loaded from: classes.dex */
    public enum zza implements zzdry {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);

        private static final zzdrx<zza> zzen = new zzddk();
        private final int value;

        zza(int i) {
            this.value = i;
        }

        public static zzdsa zzaf() {
            return zzddl.a;
        }

        public static zza zzdp(int i) {
            if (i == 1) {
                return BLOCKED_REASON_UNKNOWN;
            }
            if (i != 2) {
                return null;
            }
            return BLOCKED_REASON_BACKGROUND;
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
    public static final class zzb extends zzdrt.zzb<zzddh, zzb> implements zzdtg {
        private zzb() {
            super(zzddh.zzgsn);
        }

        /* synthetic */ zzb(zzddj zzddjVar) {
            this();
        }

        public final zzb zzb(zza zzaVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzddh) this.a).zza(zzaVar);
            return this;
        }

        public final zzb zzgs(String str) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzddh) this.a).zzgr(str);
            return this;
        }
    }

    static {
        zzddh zzddhVar = new zzddh();
        zzgsn = zzddhVar;
        zzdrt.a((Class<zzddh>) zzddh.class, zzddhVar);
    }

    private zzddh() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zza zzaVar) {
        zzaVar.getClass();
        if (!this.zzgsi.zzaxp()) {
            this.zzgsi = zzdrt.a(this.zzgsi);
        }
        this.zzgsi.zzgl(zzaVar.zzae());
    }

    public static zzb zzaqk() {
        return zzgsn.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzgr(String str) {
        str.getClass();
        this.zzdl |= 1;
        this.zzgsk = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzddj zzddjVar = null;
        switch (zzddi.a[i - 1]) {
            case 1:
                return new zzddh();
            case 2:
                return new zzb(zzddjVar);
            case 3:
                return zzdrt.a(zzgsn, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002", new Object[]{"zzdl", "zzgsi", zza.zzaf(), "zzgsk", "zzgsl", "zzgsm"});
            case 4:
                return zzgsn;
            case 5:
                zzdtn<zzddh> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzddh.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzgsn);
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

package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class zzdna extends zzdrt<zzdna, zza> implements zzdtg {
    private static volatile zzdtn<zzdna> zzdz;
    private static final zzdna zzhcv;
    private String zzhcs = "";
    private zzdqk zzhct = zzdqk.zzhhx;
    private int zzhcu;

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdna, zza> implements zzdtg {
        private zza() {
            super(zzdna.zzhcv);
        }

        /* synthetic */ zza(zzdnb zzdnbVar) {
            this();
        }

        public final zza zzaw(zzdqk zzdqkVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdna) this.a).zzav(zzdqkVar);
            return this;
        }

        public final zza zzb(zzb zzbVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdna) this.a).zza(zzbVar);
            return this;
        }

        public final zza zzhb(String str) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdna) this.a).zzha(str);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum zzb implements zzdry {
        UNKNOWN_KEYMATERIAL(0),
        SYMMETRIC(1),
        ASYMMETRIC_PRIVATE(2),
        ASYMMETRIC_PUBLIC(3),
        REMOTE(4),
        UNRECOGNIZED(-1);

        private static final zzdrx<zzb> zzen = new zzdnc();
        private final int value;

        zzb(int i) {
            this.value = i;
        }

        public static zzb zzeo(int i) {
            if (i == 0) {
                return UNKNOWN_KEYMATERIAL;
            }
            if (i == 1) {
                return SYMMETRIC;
            }
            if (i == 2) {
                return ASYMMETRIC_PRIVATE;
            }
            if (i == 3) {
                return ASYMMETRIC_PUBLIC;
            }
            if (i != 4) {
                return null;
            }
            return REMOTE;
        }

        @Override // java.lang.Enum
        public final String toString() {
            StringBuilder sb = new StringBuilder("<");
            sb.append(zzb.class.getName());
            sb.append('@');
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            if (this != UNRECOGNIZED) {
                sb.append(" number=");
                sb.append(zzae());
            }
            sb.append(" name=");
            sb.append(name());
            sb.append(Typography.greater);
            return sb.toString();
        }

        @Override // com.google.android.gms.internal.ads.zzdry
        public final int zzae() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        zzdna zzdnaVar = new zzdna();
        zzhcv = zzdnaVar;
        zzdrt.a((Class<zzdna>) zzdna.class, zzdnaVar);
    }

    private zzdna() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        this.zzhcu = zzbVar.zzae();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzav(zzdqk zzdqkVar) {
        zzdqkVar.getClass();
        this.zzhct = zzdqkVar;
    }

    public static zza zzavl() {
        return zzhcv.b();
    }

    public static zzdna zzavm() {
        return zzhcv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzha(String str) {
        str.getClass();
        this.zzhcs = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnb zzdnbVar = null;
        switch (zzdnb.a[i - 1]) {
            case 1:
                return new zzdna();
            case 2:
                return new zza(zzdnbVar);
            case 3:
                return zzdrt.a(zzhcv, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzhcs", "zzhct", "zzhcu"});
            case 4:
                return zzhcv;
            case 5:
                zzdtn<zzdna> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdna.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhcv);
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

    public final String zzavi() {
        return this.zzhcs;
    }

    public final zzdqk zzavj() {
        return this.zzhct;
    }

    public final zzb zzavk() {
        zzb zzeo = zzb.zzeo(this.zzhcu);
        return zzeo == null ? zzb.UNRECOGNIZED : zzeo;
    }
}

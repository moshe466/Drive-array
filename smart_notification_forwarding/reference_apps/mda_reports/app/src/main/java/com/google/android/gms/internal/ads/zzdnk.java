package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import java.util.List;

/* loaded from: classes.dex */
public final class zzdnk extends zzdrt<zzdnk, zzb> implements zzdtg {
    private static volatile zzdtn<zzdnk> zzdz;
    private static final zzdnk zzhds;
    private int zzhdq;
    private zzdsb<zza> zzhdr = zzdrt.d();

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt<zza, C0015zza> implements zzdtg {
        private static volatile zzdtn<zza> zzdz;
        private static final zza zzhdw;
        private int zzhdj;
        private zzdna zzhdt;
        private int zzhdu;
        private int zzhdv;

        /* renamed from: com.google.android.gms.internal.ads.zzdnk$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0015zza extends zzdrt.zzb<zza, C0015zza> implements zzdtg {
            private C0015zza() {
                super(zza.zzhdw);
            }

            /* synthetic */ C0015zza(zzdnj zzdnjVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzhdw = zzaVar;
            zzdrt.a((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzdnj zzdnjVar = null;
            switch (zzdnj.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0015zza(zzdnjVar);
                case 3:
                    return zzdrt.a(zzhdw, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzhdt", "zzhdu", "zzhdv", "zzhdj"});
                case 4:
                    return zzhdw;
                case 5:
                    zzdtn<zza> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zza.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzhdw);
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

        public final zzdne zzasj() {
            zzdne zzep = zzdne.zzep(this.zzhdu);
            return zzep == null ? zzdne.UNRECOGNIZED : zzep;
        }

        public final zzdnw zzask() {
            zzdnw zzew = zzdnw.zzew(this.zzhdj);
            return zzew == null ? zzdnw.UNRECOGNIZED : zzew;
        }

        public final boolean zzavz() {
            return this.zzhdt != null;
        }

        public final zzdna zzawa() {
            zzdna zzdnaVar = this.zzhdt;
            return zzdnaVar == null ? zzdna.zzavm() : zzdnaVar;
        }

        public final int zzawb() {
            return this.zzhdv;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzdrt.zzb<zzdnk, zzb> implements zzdtg {
        private zzb() {
            super(zzdnk.zzhds);
        }

        /* synthetic */ zzb(zzdnj zzdnjVar) {
            this();
        }
    }

    static {
        zzdnk zzdnkVar = new zzdnk();
        zzhds = zzdnkVar;
        zzdrt.a((Class<zzdnk>) zzdnk.class, zzdnkVar);
    }

    private zzdnk() {
    }

    public static zzdnk zzn(byte[] bArr) {
        return (zzdnk) zzdrt.a(zzhds, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnj zzdnjVar = null;
        switch (zzdnj.a[i - 1]) {
            case 1:
                return new zzdnk();
            case 2:
                return new zzb(zzdnjVar);
            case 3:
                return zzdrt.a(zzhds, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzhdq", "zzhdr", zza.class});
            case 4:
                return zzhds;
            case 5:
                zzdtn<zzdnk> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdnk.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhds);
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

    public final int zzavv() {
        return this.zzhdq;
    }

    public final List<zza> zzavw() {
        return this.zzhdr;
    }

    public final int zzavx() {
        return this.zzhdr.size();
    }
}

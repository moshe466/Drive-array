package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class zzdvx {

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt<zza, zzb> implements zzdtg {
        private static volatile zzdtn<zza> zzdz;
        private static final zza zzhum;
        private int zzdl;
        private int zzhuf;
        private C0016zza zzhug;
        private zzdqk zzhuh;
        private zzdqk zzhui;
        private boolean zzhuj;
        private boolean zzhuk;
        private byte zzhul = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzdvx$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0016zza extends zzdrt<C0016zza, C0017zza> implements zzdtg {
            private static volatile zzdtn<C0016zza> zzdz;
            private static final C0016zza zzhur;
            private int zzdl;
            private String zzhun = "";
            private String zzhuo = "";
            private String zzhup = "";
            private int zzhuq;

            /* renamed from: com.google.android.gms.internal.ads.zzdvx$zza$zza$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0017zza extends zzdrt.zzb<C0016zza, C0017zza> implements zzdtg {
                private C0017zza() {
                    super(C0016zza.zzhur);
                }

                /* synthetic */ C0017zza(zzdvz zzdvzVar) {
                    this();
                }
            }

            static {
                C0016zza c0016zza = new C0016zza();
                zzhur = c0016zza;
                zzdrt.a((Class<C0016zza>) C0016zza.class, c0016zza);
            }

            private C0016zza() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new C0016zza();
                    case 2:
                        return new C0017zza(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhur, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0004\u0003", new Object[]{"zzdl", "zzhun", "zzhuo", "zzhup", "zzhuq"});
                    case 4:
                        return zzhur;
                    case 5:
                        zzdtn<C0016zza> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (C0016zza.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhur);
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

        /* loaded from: classes.dex */
        public static final class zzb extends zzdrt.zzb<zza, zzb> implements zzdtg {
            private zzb() {
                super(zza.zzhum);
            }

            /* synthetic */ zzb(zzdvz zzdvzVar) {
                this();
            }
        }

        /* loaded from: classes.dex */
        public enum zzc implements zzdry {
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);

            private static final zzdrx<zzc> zzen = new zzdwb();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zzdwa.a;
            }

            public static zzc zzhd(int i) {
                if (i == 0) {
                    return SAFE;
                }
                if (i == 1) {
                    return DANGEROUS;
                }
                if (i == 2) {
                    return UNKNOWN;
                }
                if (i == 3) {
                    return POTENTIALLY_UNWANTED;
                }
                if (i != 4) {
                    return null;
                }
                return DANGEROUS_HOST;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.ads.zzdry
            public final int zzae() {
                return this.value;
            }
        }

        static {
            zza zzaVar = new zza();
            zzhum = zzaVar;
            zzdrt.a((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
            zzdqk zzdqkVar = zzdqk.zzhhx;
            this.zzhuh = zzdqkVar;
            this.zzhui = zzdqkVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzdvz zzdvzVar = null;
            switch (zzdvz.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzdvzVar);
                case 3:
                    return zzdrt.a(zzhum, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001Ԍ\u0000\u0002\t\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzdl", "zzhuf", zzc.zzaf(), "zzhug", "zzhuh", "zzhui", "zzhuj", "zzhuk"});
                case 4:
                    return zzhum;
                case 5:
                    zzdtn<zza> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zza.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzhum);
                                zzdz = zzdtnVar;
                            }
                        }
                    }
                    return zzdtnVar;
                case 6:
                    return Byte.valueOf(this.zzhul);
                case 7:
                    this.zzhul = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzdrt<zzb, zza> implements zzdtg {
        private static volatile zzdtn<zzb> zzdz;
        private static final zzb zzhvn;
        private int zzbut;
        private int zzdl;
        private int zzhuy;
        private C0018zzb zzhvb;
        private zzf zzhve;
        private boolean zzhvf;
        private boolean zzhvi;
        private boolean zzhvj;
        private zzi zzhvk;
        private byte zzhul = 2;
        private String zzhuo = "";
        private String zzhuz = "";
        private String zzhva = "";
        private zzdsb<zzh> zzhvc = zzdrt.d();
        private String zzhvd = "";
        private zzdsb<String> zzhvg = zzdrt.d();
        private String zzhvh = "";
        private zzdqk zzhuh = zzdqk.zzhhx;
        private zzdsb<String> zzhvl = zzdrt.d();
        private zzdsb<String> zzhvm = zzdrt.d();

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzb, zza> implements zzdtg {
            private zza() {
                super(zzb.zzhvn);
            }

            /* synthetic */ zza(zzdvz zzdvzVar) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zzb, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0018zzb extends zzdrt<C0018zzb, zza> implements zzdtg {
            private static volatile zzdtn<C0018zzb> zzdz;
            private static final C0018zzb zzhvp;
            private int zzdl;
            private String zzhvo = "";

            /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zzb$zza */
            /* loaded from: classes.dex */
            public static final class zza extends zzdrt.zzb<C0018zzb, zza> implements zzdtg {
                private zza() {
                    super(C0018zzb.zzhvp);
                }

                /* synthetic */ zza(zzdvz zzdvzVar) {
                    this();
                }

                public final zza zzhl(String str) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((C0018zzb) this.a).zzhm(str);
                    return this;
                }
            }

            static {
                C0018zzb c0018zzb = new C0018zzb();
                zzhvp = c0018zzb;
                zzdrt.a((Class<C0018zzb>) C0018zzb.class, c0018zzb);
            }

            private C0018zzb() {
            }

            public static zza zzbcw() {
                return zzhvp.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzhm(String str) {
                str.getClass();
                this.zzdl |= 1;
                this.zzhvo = str;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new C0018zzb();
                    case 2:
                        return new zza(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhvp, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdl", "zzhvo"});
                    case 4:
                        return zzhvp;
                    case 5:
                        zzdtn<C0018zzb> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (C0018zzb.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhvp);
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

        /* loaded from: classes.dex */
        public static final class zzc extends zzdrt<zzc, zza> implements zzdtg {
            private static volatile zzdtn<zzc> zzdz;
            private static final zzc zzhvr;
            private int zzdl;
            private zzdqk zzhct;
            private byte zzhul = 2;
            private zzdqk zzhvq;

            /* loaded from: classes.dex */
            public static final class zza extends zzdrt.zzb<zzc, zza> implements zzdtg {
                private zza() {
                    super(zzc.zzhvr);
                }

                /* synthetic */ zza(zzdvz zzdvzVar) {
                    this();
                }

                public final zza zzbk(zzdqk zzdqkVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzc) this.a).zzbm(zzdqkVar);
                    return this;
                }

                public final zza zzbl(zzdqk zzdqkVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzc) this.a).zzav(zzdqkVar);
                    return this;
                }
            }

            static {
                zzc zzcVar = new zzc();
                zzhvr = zzcVar;
                zzdrt.a((Class<zzc>) zzc.class, zzcVar);
            }

            private zzc() {
                zzdqk zzdqkVar = zzdqk.zzhhx;
                this.zzhvq = zzdqkVar;
                this.zzhct = zzdqkVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzav(zzdqk zzdqkVar) {
                zzdqkVar.getClass();
                this.zzdl |= 2;
                this.zzhct = zzdqkVar;
            }

            public static zza zzbcy() {
                return zzhvr.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbm(zzdqk zzdqkVar) {
                zzdqkVar.getClass();
                this.zzdl |= 1;
                this.zzhvq = zzdqkVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhvr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001Ԋ\u0000\u0002\n\u0001", new Object[]{"zzdl", "zzhvq", "zzhct"});
                    case 4:
                        return zzhvr;
                    case 5:
                        zzdtn<zzc> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzc.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhvr);
                                    zzdz = zzdtnVar;
                                }
                            }
                        }
                        return zzdtnVar;
                    case 6:
                        return Byte.valueOf(this.zzhul);
                    case 7:
                        this.zzhul = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class zzd extends zzdrt<zzd, zza> implements zzdtg {
            private static volatile zzdtn<zzd> zzdz;
            private static final zzd zzhvx;
            private int zzdl;
            private C0019zzb zzhvs;
            private zzdqk zzhvu;
            private zzdqk zzhvv;
            private int zzhvw;
            private byte zzhul = 2;
            private zzdsb<zzc> zzhvt = zzdrt.d();

            /* loaded from: classes.dex */
            public static final class zza extends zzdrt.zzb<zzd, zza> implements zzdtg {
                private zza() {
                    super(zzd.zzhvx);
                }

                /* synthetic */ zza(zzdvz zzdvzVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zzd$zzb, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0019zzb extends zzdrt<C0019zzb, zza> implements zzdtg {
                private static volatile zzdtn<C0019zzb> zzdz;
                private static final C0019zzb zzhwb;
                private int zzdl;
                private zzdqk zzhvy;
                private zzdqk zzhvz;
                private zzdqk zzhwa;

                /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zzd$zzb$zza */
                /* loaded from: classes.dex */
                public static final class zza extends zzdrt.zzb<C0019zzb, zza> implements zzdtg {
                    private zza() {
                        super(C0019zzb.zzhwb);
                    }

                    /* synthetic */ zza(zzdvz zzdvzVar) {
                        this();
                    }
                }

                static {
                    C0019zzb c0019zzb = new C0019zzb();
                    zzhwb = c0019zzb;
                    zzdrt.a((Class<C0019zzb>) C0019zzb.class, c0019zzb);
                }

                private C0019zzb() {
                    zzdqk zzdqkVar = zzdqk.zzhhx;
                    this.zzhvy = zzdqkVar;
                    this.zzhvz = zzdqkVar;
                    this.zzhwa = zzdqkVar;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzdrt
                public final Object a(int i, Object obj, Object obj2) {
                    zzdvz zzdvzVar = null;
                    switch (zzdvz.a[i - 1]) {
                        case 1:
                            return new C0019zzb();
                        case 2:
                            return new zza(zzdvzVar);
                        case 3:
                            return zzdrt.a(zzhwb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzhvy", "zzhvz", "zzhwa"});
                        case 4:
                            return zzhwb;
                        case 5:
                            zzdtn<C0019zzb> zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                synchronized (C0019zzb.class) {
                                    zzdtnVar = zzdz;
                                    if (zzdtnVar == null) {
                                        zzdtnVar = new zzdrt.zza<>(zzhwb);
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

            static {
                zzd zzdVar = new zzd();
                zzhvx = zzdVar;
                zzdrt.a((Class<zzd>) zzd.class, zzdVar);
            }

            private zzd() {
                zzdqk zzdqkVar = zzdqk.zzhhx;
                this.zzhvu = zzdqkVar;
                this.zzhvv = zzdqkVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new zza(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhvx, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003", new Object[]{"zzdl", "zzhvs", "zzhvt", zzc.class, "zzhvu", "zzhvv", "zzhvw"});
                    case 4:
                        return zzhvx;
                    case 5:
                        zzdtn<zzd> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzd.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhvx);
                                    zzdz = zzdtnVar;
                                }
                            }
                        }
                        return zzdtnVar;
                    case 6:
                        return Byte.valueOf(this.zzhul);
                    case 7:
                        this.zzhul = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class zze extends zzdrt<zze, zza> implements zzdtg {
            private static volatile zzdtn<zze> zzdz;
            private static final zze zzhwe;
            private int zzdl;
            private byte zzhul = 2;
            private zzdsb<zzc> zzhvt = zzdrt.d();
            private zzdqk zzhvu;
            private zzdqk zzhvv;
            private int zzhvw;
            private C0020zzb zzhwc;
            private zzdqk zzhwd;

            /* loaded from: classes.dex */
            public static final class zza extends zzdrt.zzb<zze, zza> implements zzdtg {
                private zza() {
                    super(zze.zzhwe);
                }

                /* synthetic */ zza(zzdvz zzdvzVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zze$zzb, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0020zzb extends zzdrt<C0020zzb, zza> implements zzdtg {
                private static volatile zzdtn<C0020zzb> zzdz;
                private static final C0020zzb zzhwh;
                private int zzdl;
                private zzdqk zzhwa;
                private int zzhwf;
                private zzdqk zzhwg;

                /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zze$zzb$zza */
                /* loaded from: classes.dex */
                public static final class zza extends zzdrt.zzb<C0020zzb, zza> implements zzdtg {
                    private zza() {
                        super(C0020zzb.zzhwh);
                    }

                    /* synthetic */ zza(zzdvz zzdvzVar) {
                        this();
                    }
                }

                static {
                    C0020zzb c0020zzb = new C0020zzb();
                    zzhwh = c0020zzb;
                    zzdrt.a((Class<C0020zzb>) C0020zzb.class, c0020zzb);
                }

                private C0020zzb() {
                    zzdqk zzdqkVar = zzdqk.zzhhx;
                    this.zzhwg = zzdqkVar;
                    this.zzhwa = zzdqkVar;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.android.gms.internal.ads.zzdrt
                public final Object a(int i, Object obj, Object obj2) {
                    zzdvz zzdvzVar = null;
                    switch (zzdvz.a[i - 1]) {
                        case 1:
                            return new C0020zzb();
                        case 2:
                            return new zza(zzdvzVar);
                        case 3:
                            return zzdrt.a(zzhwh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzhwf", "zzhwg", "zzhwa"});
                        case 4:
                            return zzhwh;
                        case 5:
                            zzdtn<C0020zzb> zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                synchronized (C0020zzb.class) {
                                    zzdtnVar = zzdz;
                                    if (zzdtnVar == null) {
                                        zzdtnVar = new zzdrt.zza<>(zzhwh);
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

            static {
                zze zzeVar = new zze();
                zzhwe = zzeVar;
                zzdrt.a((Class<zze>) zze.class, zzeVar);
            }

            private zze() {
                zzdqk zzdqkVar = zzdqk.zzhhx;
                this.zzhvu = zzdqkVar;
                this.zzhvv = zzdqkVar;
                this.zzhwd = zzdqkVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new zza(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhwe, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001\t\u0000\u0002Л\u0003\n\u0001\u0004\n\u0002\u0005\u0004\u0003\u0006\n\u0004", new Object[]{"zzdl", "zzhwc", "zzhvt", zzc.class, "zzhvu", "zzhvv", "zzhvw", "zzhwd"});
                    case 4:
                        return zzhwe;
                    case 5:
                        zzdtn<zze> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zze.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhwe);
                                    zzdz = zzdtnVar;
                                }
                            }
                        }
                        return zzdtnVar;
                    case 6:
                        return Byte.valueOf(this.zzhul);
                    case 7:
                        this.zzhul = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class zzf extends zzdrt<zzf, zza> implements zzdtg {
            private static volatile zzdtn<zzf> zzdz;
            private static final zzf zzhwk;
            private int zzbut;
            private int zzdl;
            private String zzhwi = "";
            private zzdqk zzhwj = zzdqk.zzhhx;

            /* loaded from: classes.dex */
            public static final class zza extends zzdrt.zzb<zzf, zza> implements zzdtg {
                private zza() {
                    super(zzf.zzhwk);
                }

                /* synthetic */ zza(zzdvz zzdvzVar) {
                    this();
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zzf$zzb, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public enum EnumC0021zzb implements zzdry {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);

                private static final zzdrx<EnumC0021zzb> zzen = new zzdwc();
                private final int value;

                EnumC0021zzb(int i) {
                    this.value = i;
                }

                public static zzdsa zzaf() {
                    return zzdwd.a;
                }

                public static EnumC0021zzb zzhe(int i) {
                    if (i == 0) {
                        return TYPE_UNKNOWN;
                    }
                    if (i != 1) {
                        return null;
                    }
                    return TYPE_CREATIVE;
                }

                @Override // java.lang.Enum
                public final String toString() {
                    return "<" + EnumC0021zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
                }

                @Override // com.google.android.gms.internal.ads.zzdry
                public final int zzae() {
                    return this.value;
                }
            }

            static {
                zzf zzfVar = new zzf();
                zzhwk = zzfVar;
                zzdrt.a((Class<zzf>) zzf.class, zzfVar);
            }

            private zzf() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new zza(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhwk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\n\u0002", new Object[]{"zzdl", "zzbut", EnumC0021zzb.zzaf(), "zzhwi", "zzhwj"});
                    case 4:
                        return zzhwk;
                    case 5:
                        zzdtn<zzf> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzf.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhwk);
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

        /* loaded from: classes.dex */
        public enum zzg implements zzdry {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);

            private static final zzdrx<zzg> zzen = new zzdwf();
            private final int value;

            zzg(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zzdwe.a;
            }

            public static zzg zzhf(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzg.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.ads.zzdry
            public final int zzae() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class zzh extends zzdrt<zzh, C0022zzb> implements zzdtg {
            private static volatile zzdtn<zzh> zzdz;
            private static final zzh zzhxm;
            private int zzdl;
            private int zzhxe;
            private zzd zzhxf;
            private zze zzhxg;
            private int zzhxh;
            private int zzhxk;
            private byte zzhul = 2;
            private String zzhuo = "";
            private zzdrz zzhxi = zzdrt.c();
            private String zzhxj = "";
            private zzdsb<String> zzhxl = zzdrt.d();

            /* loaded from: classes.dex */
            public enum zza implements zzdry {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);

                private static final zzdrx<zza> zzen = new zzdwh();
                private final int value;

                zza(int i) {
                    this.value = i;
                }

                public static zzdsa zzaf() {
                    return zzdwg.a;
                }

                public static zza zzhg(int i) {
                    if (i == 0) {
                        return AD_RESOURCE_UNKNOWN;
                    }
                    if (i == 1) {
                        return AD_RESOURCE_CREATIVE;
                    }
                    if (i == 2) {
                        return AD_RESOURCE_POST_CLICK;
                    }
                    if (i != 3) {
                        return null;
                    }
                    return AD_RESOURCE_AUTO_CLICK_DESTINATION;
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

            /* renamed from: com.google.android.gms.internal.ads.zzdvx$zzb$zzh$zzb, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0022zzb extends zzdrt.zzb<zzh, C0022zzb> implements zzdtg {
                private C0022zzb() {
                    super(zzh.zzhxm);
                }

                /* synthetic */ C0022zzb(zzdvz zzdvzVar) {
                    this();
                }
            }

            static {
                zzh zzhVar = new zzh();
                zzhxm = zzhVar;
                zzdrt.a((Class<zzh>) zzh.class, zzhVar);
            }

            private zzh() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C0022zzb(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhxm, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001Ԅ\u0000\u0002\b\u0001\u0003Љ\u0002\u0004Љ\u0003\u0005\u0004\u0004\u0006\u0016\u0007\b\u0005\b\f\u0006\t\u001a", new Object[]{"zzdl", "zzhxe", "zzhuo", "zzhxf", "zzhxg", "zzhxh", "zzhxi", "zzhxj", "zzhxk", zza.zzaf(), "zzhxl"});
                    case 4:
                        return zzhxm;
                    case 5:
                        zzdtn<zzh> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzh.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhxm);
                                    zzdz = zzdtnVar;
                                }
                            }
                        }
                        return zzdtnVar;
                    case 6:
                        return Byte.valueOf(this.zzhul);
                    case 7:
                        this.zzhul = (byte) (obj != null ? 1 : 0);
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class zzi extends zzdrt<zzi, zza> implements zzdtg {
            private static volatile zzdtn<zzi> zzdz;
            private static final zzi zzhxq;
            private int zzdl;
            private String zzhxn = "";
            private long zzhxo;
            private boolean zzhxp;

            /* loaded from: classes.dex */
            public static final class zza extends zzdrt.zzb<zzi, zza> implements zzdtg {
                private zza() {
                    super(zzi.zzhxq);
                }

                /* synthetic */ zza(zzdvz zzdvzVar) {
                    this();
                }

                public final zza zzbs(boolean z) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzi) this.a).zzbr(z);
                    return this;
                }

                public final zza zzfu(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzi) this.a).zzft(j);
                    return this;
                }

                public final zza zzho(String str) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzi) this.a).zzhn(str);
                    return this;
                }
            }

            static {
                zzi zziVar = new zzi();
                zzhxq = zziVar;
                zzdrt.a((Class<zzi>) zzi.class, zziVar);
            }

            private zzi() {
            }

            public static zza zzbdg() {
                return zzhxq.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbr(boolean z) {
                this.zzdl |= 4;
                this.zzhxp = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzft(long j) {
                this.zzdl |= 2;
                this.zzhxo = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzhn(String str) {
                str.getClass();
                this.zzdl |= 1;
                this.zzhxn = str;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzdvz zzdvzVar = null;
                switch (zzdvz.a[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza(zzdvzVar);
                    case 3:
                        return zzdrt.a(zzhxq, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0007\u0002", new Object[]{"zzdl", "zzhxn", "zzhxo", "zzhxp"});
                    case 4:
                        return zzhxq;
                    case 5:
                        zzdtn<zzi> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzi.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzhxq);
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

        static {
            zzb zzbVar = new zzb();
            zzhvn = zzbVar;
            zzdrt.a((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzdvz zzdvzVar = null;
            switch (zzdvz.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzdvzVar);
                case 3:
                    return zzdrt.a(zzhvn, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001\b\u0002\u0002\b\u0003\u0003\b\u0004\u0004Л\u0005\u0007\b\u0006\u001a\u0007\b\t\b\u0007\n\t\u0007\u000b\n\f\u0000\u000b\f\u0001\f\t\u0005\r\b\u0006\u000e\t\u0007\u000f\n\f\u0011\t\r\u0014\u001a\u0015\u001a", new Object[]{"zzdl", "zzhuo", "zzhuz", "zzhva", "zzhvc", zzh.class, "zzhvf", "zzhvg", "zzhvh", "zzhvi", "zzhvj", "zzbut", zzg.zzaf(), "zzhuy", zza.zzc.zzaf(), "zzhvb", "zzhvd", "zzhve", "zzhuh", "zzhvk", "zzhvl", "zzhvm"});
                case 4:
                    return zzhvn;
                case 5:
                    zzdtn<zzb> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzb.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzhvn);
                                zzdz = zzdtnVar;
                            }
                        }
                    }
                    return zzdtnVar;
                case 6:
                    return Byte.valueOf(this.zzhul);
                case 7:
                    this.zzhul = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}

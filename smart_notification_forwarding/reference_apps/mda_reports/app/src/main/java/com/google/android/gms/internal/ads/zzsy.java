package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import java.util.Iterator;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class zzsy {

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt<zza, zzb> implements zzdtg {
        private static final zza zzbuj;
        private static volatile zzdtn<zza> zzdz;
        private zzdsb<C0024zza> zzbui = zzdrt.d();

        /* renamed from: com.google.android.gms.internal.ads.zzsy$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0024zza extends zzdrt<C0024zza, C0025zza> implements zzdtg {
            private static final C0024zza zzbuh;
            private static volatile zzdtn<C0024zza> zzdz;
            private int zzbue;
            private zzd zzbuf;
            private zze zzbug;
            private int zzdl;

            /* renamed from: com.google.android.gms.internal.ads.zzsy$zza$zza$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0025zza extends zzdrt.zzb<C0024zza, C0025zza> implements zzdtg {
                private C0025zza() {
                    super(C0024zza.zzbuh);
                }

                /* synthetic */ C0025zza(zzsx zzsxVar) {
                    this();
                }

                public final C0025zza zza(zzd.C0026zza c0026zza) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((C0024zza) this.a).zza((zzd) c0026zza.zzbaf());
                    return this;
                }

                public final C0025zza zza(zze.C0027zza c0027zza) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((C0024zza) this.a).zza((zze) c0027zza.zzbaf());
                    return this;
                }

                public final C0025zza zzb(zzc zzcVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((C0024zza) this.a).zza(zzcVar);
                    return this;
                }
            }

            static {
                C0024zza c0024zza = new C0024zza();
                zzbuh = c0024zza;
                zzdrt.a((Class<C0024zza>) C0024zza.class, c0024zza);
            }

            private C0024zza() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzc zzcVar) {
                this.zzbue = zzcVar.zzae();
                this.zzdl |= 1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzd zzdVar) {
                zzdVar.getClass();
                this.zzbuf = zzdVar;
                this.zzdl |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zze zzeVar) {
                zzeVar.getClass();
                this.zzbug = zzeVar;
                this.zzdl |= 4;
            }

            public static C0025zza zzmx() {
                return zzbuh.b();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzsx zzsxVar = null;
                switch (zzsx.a[i - 1]) {
                    case 1:
                        return new C0024zza();
                    case 2:
                        return new C0025zza(zzsxVar);
                    case 3:
                        return zzdrt.a(zzbuh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbue", zzc.zzaf(), "zzbuf", "zzbug"});
                    case 4:
                        return zzbuh;
                    case 5:
                        zzdtn<C0024zza> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (C0024zza.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzbuh);
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
                super(zza.zzbuj);
            }

            /* synthetic */ zzb(zzsx zzsxVar) {
                this();
            }

            public final zzb zza(C0024zza.C0025zza c0025zza) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza((C0024zza) c0025zza.zzbaf());
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum zzc implements zzdry {
            UNSPECIFIED(0),
            IN_MEMORY(1);

            private static final zzdrx<zzc> zzen = new zzsz();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zzta.a;
            }

            public static zzc zzbs(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i != 1) {
                    return null;
                }
                return IN_MEMORY;
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

        /* loaded from: classes.dex */
        public static final class zzd extends zzdrt<zzd, C0026zza> implements zzdtg {
            private static final zzd zzbup;
            private static volatile zzdtn<zzd> zzdz;
            private boolean zzbun;
            private int zzbuo;
            private int zzdl;

            /* renamed from: com.google.android.gms.internal.ads.zzsy$zza$zzd$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0026zza extends zzdrt.zzb<zzd, C0026zza> implements zzdtg {
                private C0026zza() {
                    super(zzd.zzbup);
                }

                /* synthetic */ C0026zza(zzsx zzsxVar) {
                    this();
                }

                public final C0026zza zzbu(int i) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzd) this.a).zzbt(i);
                    return this;
                }

                public final C0026zza zzt(boolean z) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzd) this.a).zzq(z);
                    return this;
                }
            }

            static {
                zzd zzdVar = new zzd();
                zzbup = zzdVar;
                zzdrt.a((Class<zzd>) zzd.class, zzdVar);
            }

            private zzd() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbt(int i) {
                this.zzdl |= 2;
                this.zzbuo = i;
            }

            public static C0026zza zznb() {
                return zzbup.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzq(boolean z) {
                this.zzdl |= 1;
                this.zzbun = z;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzsx zzsxVar = null;
                switch (zzsx.a[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C0026zza(zzsxVar);
                    case 3:
                        return zzdrt.a(zzbup, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u000b\u0001", new Object[]{"zzdl", "zzbun", "zzbuo"});
                    case 4:
                        return zzbup;
                    case 5:
                        zzdtn<zzd> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzd.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzbup);
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
        public static final class zze extends zzdrt<zze, C0027zza> implements zzdtg {
            private static final zze zzbus;
            private static volatile zzdtn<zze> zzdz;
            private int zzbuo;
            private boolean zzbuq;
            private boolean zzbur;
            private int zzdl;

            /* renamed from: com.google.android.gms.internal.ads.zzsy$zza$zze$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0027zza extends zzdrt.zzb<zze, C0027zza> implements zzdtg {
                private C0027zza() {
                    super(zze.zzbus);
                }

                /* synthetic */ C0027zza(zzsx zzsxVar) {
                    this();
                }

                public final C0027zza zzbv(int i) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbt(i);
                    return this;
                }

                public final C0027zza zzu(boolean z) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzr(z);
                    return this;
                }

                public final C0027zza zzv(boolean z) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzs(z);
                    return this;
                }
            }

            static {
                zze zzeVar = new zze();
                zzbus = zzeVar;
                zzdrt.a((Class<zze>) zze.class, zzeVar);
            }

            private zze() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbt(int i) {
                this.zzdl |= 4;
                this.zzbuo = i;
            }

            public static C0027zza zznd() {
                return zzbus.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzr(boolean z) {
                this.zzdl |= 1;
                this.zzbuq = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzs(boolean z) {
                this.zzdl |= 2;
                this.zzbur = z;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzsx zzsxVar = null;
                switch (zzsx.a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0027zza(zzsxVar);
                    case 3:
                        return zzdrt.a(zzbus, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u000b\u0002", new Object[]{"zzdl", "zzbuq", "zzbur", "zzbuo"});
                    case 4:
                        return zzbus;
                    case 5:
                        zzdtn<zze> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zze.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzbus);
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
            zza zzaVar = new zza();
            zzbuj = zzaVar;
            zzdrt.a((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(C0024zza c0024zza) {
            c0024zza.getClass();
            if (!this.zzbui.zzaxp()) {
                this.zzbui = zzdrt.a(this.zzbui);
            }
            this.zzbui.add(c0024zza);
        }

        public static zzb zzmz() {
            return zzbuj.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzsxVar);
                case 3:
                    return zzdrt.a(zzbuj, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbui", C0024zza.class});
                case 4:
                    return zzbuj;
                case 5:
                    zzdtn<zza> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zza.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbuj);
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
    public static final class zzb extends zzdrt<zzb, C0028zzb> implements zzdtg {
        private static final zzb zzbuv;
        private static volatile zzdtn<zzb> zzdz;
        private int zzbut;
        private zzm zzbuu;
        private int zzdl;

        /* loaded from: classes.dex */
        public enum zza implements zzdry {
            AD_FORMAT_TYPE_UNSPECIFIED(0),
            BANNER(1),
            INTERSTITIAL(2),
            NATIVE_EXPRESS(3),
            NATIVE_CONTENT(4),
            NATIVE_APP_INSTALL(5),
            NATIVE_CUSTOM_TEMPLATE(6),
            DFP_BANNER(7),
            DFP_INTERSTITIAL(8),
            REWARD_BASED_VIDEO_AD(9),
            BANNER_SEARCH_ADS(10);

            private static final zzdrx<zza> zzen = new zztb();
            private final int value;

            zza(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zztc.a;
            }

            public static zza zzbw(int i) {
                switch (i) {
                    case 0:
                        return AD_FORMAT_TYPE_UNSPECIFIED;
                    case 1:
                        return BANNER;
                    case 2:
                        return INTERSTITIAL;
                    case 3:
                        return NATIVE_EXPRESS;
                    case 4:
                        return NATIVE_CONTENT;
                    case 5:
                        return NATIVE_APP_INSTALL;
                    case 6:
                        return NATIVE_CUSTOM_TEMPLATE;
                    case 7:
                        return DFP_BANNER;
                    case 8:
                        return DFP_INTERSTITIAL;
                    case 9:
                        return REWARD_BASED_VIDEO_AD;
                    case 10:
                        return BANNER_SEARCH_ADS;
                    default:
                        return null;
                }
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

        /* renamed from: com.google.android.gms.internal.ads.zzsy$zzb$zzb, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0028zzb extends zzdrt.zzb<zzb, C0028zzb> implements zzdtg {
            private C0028zzb() {
                super(zzb.zzbuv);
            }

            /* synthetic */ C0028zzb(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzbuv = zzbVar;
            zzdrt.a((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C0028zzb(zzsxVar);
                case 3:
                    return zzdrt.a(zzbuv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdl", "zzbut", zza.zzaf(), "zzbuu"});
                case 4:
                    return zzbuv;
                case 5:
                    zzdtn<zzb> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzb.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbuv);
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
        private static final zzc zzbvl;
        private static volatile zzdtn<zzc> zzdz;
        private String zzbvi = "";
        private zzdsb<zzb> zzbvj = zzdrt.d();
        private int zzbvk;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzc, zza> implements zzdtg {
            private zza() {
                super(zzc.zzbvl);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzbvl = zzcVar;
            zzdrt.a((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbvl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b\u0003\f\u0001", new Object[]{"zzdl", "zzbvi", "zzbvj", zzb.class, "zzbvk", zzte.zzaf()});
                case 4:
                    return zzbvl;
                case 5:
                    zzdtn<zzc> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzc.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbvl);
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
    public static final class zzd extends zzdrt<zzd, zza> implements zzdtg {
        private static final zzd zzbvs;
        private static volatile zzdtn<zzd> zzdz;
        private int zzbvm;
        private zzo zzbvn;
        private zzo zzbvo;
        private zzo zzbvp;
        private zzdsb<zzo> zzbvq = zzdrt.d();
        private int zzbvr;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzd, zza> implements zzdtg {
            private zza() {
                super(zzd.zzbvs);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzbvs = zzdVar;
            zzdrt.a((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbvs, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b\u0006\u0004\u0004", new Object[]{"zzdl", "zzbvm", "zzbvn", "zzbvo", "zzbvp", "zzbvq", zzo.class, "zzbvr"});
                case 4:
                    return zzbvs;
                case 5:
                    zzdtn<zzd> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzd.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbvs);
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
    public static final class zze extends zzdrt<zze, zza> implements zzdtg {
        private static final zze zzbwb;
        private static volatile zzdtn<zze> zzdz;
        private int zzbvy;
        private zzo zzbwa;
        private int zzdl;
        private String zzbvx = "";
        private zzdrz zzbvz = zzdrt.c();

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zze, zza> implements zzdtg {
            private zza() {
                super(zze.zzbwb);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzbwb = zzeVar;
            zzdrt.a((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbwb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0016\u0004\t\u0002", new Object[]{"zzdl", "zzbvx", "zzbvy", zzte.zzaf(), "zzbvz", "zzbwa"});
                case 4:
                    return zzbwb;
                case 5:
                    zzdtn<zze> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zze.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbwb);
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
    public static final class zzf extends zzdrt<zzf, zza> implements zzdtg {
        private static final zzf zzbwd;
        private static volatile zzdtn<zzf> zzdz;
        private zzdrz zzbvz = zzdrt.c();
        private int zzbwc;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzf, zza> implements zzdtg {
            private zza() {
                super(zzf.zzbwd);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzbwd = zzfVar;
            zzdrt.a((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbwd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u0016", new Object[]{"zzdl", "zzbwc", zzte.zzaf(), "zzbvz"});
                case 4:
                    return zzbwd;
                case 5:
                    zzdtn<zzf> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzf.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbwd);
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
    public static final class zzg extends zzdrt<zzg, zza> implements zzdtg {
        private static final zzg zzbwg;
        private static volatile zzdtn<zzg> zzdz;
        private zzo zzbwa;
        private int zzbwc;
        private zze zzbwe;
        private zzdsb<zzn> zzbwf = zzdrt.d();
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzg, zza> implements zzdtg {
            private zza() {
                super(zzg.zzbwg);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzbwg = zzgVar;
            zzdrt.a((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbwg, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\t\u0000\u0002\u001b\u0003\f\u0001\u0004\t\u0002", new Object[]{"zzdl", "zzbwe", "zzbwf", zzn.class, "zzbwc", zzte.zzaf(), "zzbwa"});
                case 4:
                    return zzbwg;
                case 5:
                    zzdtn<zzg> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzg.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbwg);
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
    public static final class zzh extends zzdrt<zzh, zzb> implements zzdtg {
        private static final zzh zzbwi;
        private static volatile zzdtn<zzh> zzdz;
        private int zzbut;
        private int zzbwh;
        private int zzdl;

        /* loaded from: classes.dex */
        public enum zza implements zzdry {
            CELLULAR_NETWORK_TYPE_UNSPECIFIED(0),
            TWO_G(1),
            THREE_G(2),
            LTE(4);

            private static final zzdrx<zza> zzen = new zzth();
            private final int value;

            zza(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zztg.a;
            }

            public static zza zzby(int i) {
                if (i == 0) {
                    return CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return TWO_G;
                }
                if (i == 2) {
                    return THREE_G;
                }
                if (i != 4) {
                    return null;
                }
                return LTE;
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
        public static final class zzb extends zzdrt.zzb<zzh, zzb> implements zzdtg {
            private zzb() {
                super(zzh.zzbwi);
            }

            /* synthetic */ zzb(zzsx zzsxVar) {
                this();
            }

            public final zzb zzb(zza zzaVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzh) this.a).zza(zzaVar);
                return this;
            }

            public final zzb zzb(zzc zzcVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzh) this.a).zza(zzcVar);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum zzc implements zzdry {
            NETWORKTYPE_UNSPECIFIED(0),
            CELL(1),
            WIFI(2);

            private static final zzdrx<zzc> zzen = new zzti();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zztj.a;
            }

            public static zzc zzbz(int i) {
                if (i == 0) {
                    return NETWORKTYPE_UNSPECIFIED;
                }
                if (i == 1) {
                    return CELL;
                }
                if (i != 2) {
                    return null;
                }
                return WIFI;
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
            zzh zzhVar = new zzh();
            zzbwi = zzhVar;
            zzdrt.a((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            this.zzbwh = zzaVar.zzae();
            this.zzdl |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzbut = zzcVar.zzae();
            this.zzdl |= 1;
        }

        public static zzb zznl() {
            return zzbwi.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb(zzsxVar);
                case 3:
                    return zzdrt.a(zzbwi, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001", new Object[]{"zzdl", "zzbut", zzc.zzaf(), "zzbwh", zza.zzaf()});
                case 4:
                    return zzbwi;
                case 5:
                    zzdtn<zzh> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzh.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbwi);
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
    public static final class zzi extends zzdrt<zzi, zza> implements zzdtg {
        private static final zzi zzbwu;
        private static volatile zzdtn<zzi> zzdz;
        private int zzbws;
        private zzo zzbwt;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzi, zza> implements zzdtg {
            private zza() {
                super(zzi.zzbwu);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzi zziVar = new zzi();
            zzbwu = zziVar;
            zzdrt.a((Class<zzi>) zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbwu, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdl", "zzbws", zzte.zzaf(), "zzbwt"});
                case 4:
                    return zzbwu;
                case 5:
                    zzdtn<zzi> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzi.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbwu);
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
    public static final class zzj extends zzdrt<zzj, zzb> implements zzdtg {
        private static final zzj zzbxa;
        private static volatile zzdtn<zzj> zzdz;
        private int zzbwv;
        private int zzbww;
        private long zzbwx;
        private long zzbwz;
        private int zzdl;
        private zzdsb<zza> zzbui = zzdrt.d();
        private String zzdm = "";
        private String zzbwy = "";

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt<zza, C0029zza> implements zzdtg {
            private static final zzdsc<Integer, zzb.zza> zzbxg = new zztk();
            private static final zza zzbxo;
            private static volatile zzdtn<zza> zzdz;
            private long zzbxb;
            private int zzbxc;
            private long zzbxd;
            private long zzbxe;
            private zzdrz zzbxf = zzdrt.c();
            private zzh zzbxh;
            private int zzbxi;
            private int zzbxj;
            private int zzbxk;
            private int zzbxl;
            private int zzbxm;
            private int zzbxn;
            private int zzdl;

            /* renamed from: com.google.android.gms.internal.ads.zzsy$zzj$zza$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0029zza extends zzdrt.zzb<zza, C0029zza> implements zzdtg {
                private C0029zza() {
                    super(zza.zzbxo);
                }

                /* synthetic */ C0029zza(zzsx zzsxVar) {
                    this();
                }

                public final C0029zza zzb(zzh zzhVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zza(zzhVar);
                    return this;
                }

                public final C0029zza zzb(zzc zzcVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zza(zzcVar);
                    return this;
                }

                public final C0029zza zzcf(int i) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zzcc(i);
                    return this;
                }

                public final C0029zza zzd(Iterable<? extends zzb.zza> iterable) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zzb(iterable);
                    return this;
                }

                public final C0029zza zzeu(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).setTimestamp(j);
                    return this;
                }

                public final C0029zza zzev(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zzeq(j);
                    return this;
                }

                public final C0029zza zzew(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zzer(j);
                    return this;
                }

                public final C0029zza zzf(zzte zzteVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zza(zzteVar);
                    return this;
                }

                public final C0029zza zzg(zzte zzteVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zzb(zzteVar);
                    return this;
                }

                public final C0029zza zzh(zzte zzteVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zzc(zzteVar);
                    return this;
                }

                public final C0029zza zzi(zzte zzteVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zzd(zzteVar);
                    return this;
                }

                public final C0029zza zzj(zzte zzteVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zza) this.a).zze(zzteVar);
                    return this;
                }
            }

            static {
                zza zzaVar = new zza();
                zzbxo = zzaVar;
                zzdrt.a((Class<zza>) zza.class, zzaVar);
            }

            private zza() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void setTimestamp(long j) {
                this.zzdl |= 1;
                this.zzbxb = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzh zzhVar) {
                zzhVar.getClass();
                this.zzbxh = zzhVar;
                this.zzdl |= 16;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzc zzcVar) {
                this.zzbxn = zzcVar.zzae();
                this.zzdl |= 1024;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zza(zzte zzteVar) {
                this.zzbxc = zzteVar.zzae();
                this.zzdl |= 2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzb(zzte zzteVar) {
                this.zzbxi = zzteVar.zzae();
                this.zzdl |= 32;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzb(Iterable<? extends zzb.zza> iterable) {
                if (!this.zzbxf.zzaxp()) {
                    this.zzbxf = zzdrt.a(this.zzbxf);
                }
                Iterator<? extends zzb.zza> it = iterable.iterator();
                while (it.hasNext()) {
                    this.zzbxf.zzgl(it.next().zzae());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzc(zzte zzteVar) {
                this.zzbxj = zzteVar.zzae();
                this.zzdl |= 64;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcc(int i) {
                this.zzdl |= 256;
                this.zzbxl = i;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzd(zzte zzteVar) {
                this.zzbxk = zzteVar.zzae();
                this.zzdl |= 128;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zze(zzte zzteVar) {
                this.zzbxm = zzteVar.zzae();
                this.zzdl |= 512;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzeq(long j) {
                this.zzdl |= 4;
                this.zzbxd = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzer(long j) {
                this.zzdl |= 8;
                this.zzbxe = j;
            }

            public static zza zzg(byte[] bArr) {
                return (zza) zzdrt.a(zzbxo, bArr);
            }

            public static C0029zza zznr() {
                return zzbxo.b();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzsx zzsxVar = null;
                switch (zzsx.a[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C0029zza(zzsxVar);
                    case 3:
                        return zzdrt.a(zzbxo, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\u0002\u0000\u0002\f\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u001e\u0006\t\u0004\u0007\f\u0005\b\f\u0006\t\f\u0007\n\u0004\b\u000b\f\t\f\f\n", new Object[]{"zzdl", "zzbxb", "zzbxc", zzte.zzaf(), "zzbxd", "zzbxe", "zzbxf", zzb.zza.zzaf(), "zzbxh", "zzbxi", zzte.zzaf(), "zzbxj", zzte.zzaf(), "zzbxk", zzte.zzaf(), "zzbxl", "zzbxm", zzte.zzaf(), "zzbxn", zzc.zzaf()});
                    case 4:
                        return zzbxo;
                    case 5:
                        zzdtn<zza> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zza.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzbxo);
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

            public final long getTimestamp() {
                return this.zzbxb;
            }

            public final zzte zznq() {
                zzte zzbx = zzte.zzbx(this.zzbxc);
                return zzbx == null ? zzte.ENUM_FALSE : zzbx;
            }
        }

        /* loaded from: classes.dex */
        public static final class zzb extends zzdrt.zzb<zzj, zzb> implements zzdtg {
            private zzb() {
                super(zzj.zzbxa);
            }

            /* synthetic */ zzb(zzsx zzsxVar) {
                this();
            }

            public final zzb zzc(Iterable<? extends zza> iterable) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzj) this.a).zza(iterable);
                return this;
            }

            public final zzb zzca(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzj) this.a).zzn(str);
                return this;
            }

            public final zzb zzcb(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzj) this.a).zzbz(str);
                return this;
            }

            public final zzb zzcd(int i) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzj) this.a).zzca(i);
                return this;
            }

            public final zzb zzce(int i) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzj) this.a).zzcb(i);
                return this;
            }

            public final zzb zzes(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzj) this.a).zzeo(j);
                return this;
            }

            public final zzb zzet(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzj) this.a).zzep(j);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum zzc implements zzdry {
            UNSPECIFIED(0),
            CONNECTING(1),
            CONNECTED(2),
            DISCONNECTING(3),
            DISCONNECTED(4),
            SUSPENDED(5);

            private static final zzdrx<zzc> zzen = new zztl();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zztm.a;
            }

            public static zzc zzcg(int i) {
                if (i == 0) {
                    return UNSPECIFIED;
                }
                if (i == 1) {
                    return CONNECTING;
                }
                if (i == 2) {
                    return CONNECTED;
                }
                if (i == 3) {
                    return DISCONNECTING;
                }
                if (i == 4) {
                    return DISCONNECTED;
                }
                if (i != 5) {
                    return null;
                }
                return SUSPENDED;
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
            zzj zzjVar = new zzj();
            zzbxa = zzjVar;
            zzdrt.a((Class<zzj>) zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zza> iterable) {
            if (!this.zzbui.zzaxp()) {
                this.zzbui = zzdrt.a(this.zzbui);
            }
            zzdqa.a(iterable, this.zzbui);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzbz(String str) {
            str.getClass();
            this.zzdl |= 16;
            this.zzbwy = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzca(int i) {
            this.zzdl |= 1;
            this.zzbwv = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcb(int i) {
            this.zzdl |= 2;
            this.zzbww = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzeo(long j) {
            this.zzdl |= 4;
            this.zzbwx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzep(long j) {
            this.zzdl |= 32;
            this.zzbwz = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzdl |= 8;
            this.zzdm = str;
        }

        public static zzb zzno() {
            return zzbxa.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zzb(zzsxVar);
                case 3:
                    return zzdrt.a(zzbxa, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002\u0004\u0000\u0003\u0004\u0001\u0004\u0002\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005", new Object[]{"zzdl", "zzbui", zza.class, "zzbwv", "zzbww", "zzbwx", "zzdm", "zzbwy", "zzbwz"});
                case 4:
                    return zzbxa;
                case 5:
                    zzdtn<zzj> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzj.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbxa);
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
    public static final class zzk extends zzdrt<zzk, zza> implements zzdtg {
        private static final zzk zzbyh;
        private static volatile zzdtn<zzk> zzdz;
        private int zzbxw = 1000;
        private int zzbxx = 1000;
        private int zzbxy;
        private int zzbxz;
        private int zzbya;
        private int zzbyb;
        private int zzbyc;
        private int zzbyd;
        private int zzbye;
        private int zzbyf;
        private zzl zzbyg;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzk, zza> implements zzdtg {
            private zza() {
                super(zzk.zzbyh);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzbyh = zzkVar;
            zzdrt.a((Class<zzk>) zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbyh, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0004\u0005\u0007\u0004\u0006\b\u0004\u0007\t\u0004\b\n\u0004\t\u000b\t\n", new Object[]{"zzdl", "zzbxw", zzte.zzaf(), "zzbxx", zzte.zzaf(), "zzbxy", "zzbxz", "zzbya", "zzbyb", "zzbyc", "zzbyd", "zzbye", "zzbyf", "zzbyg"});
                case 4:
                    return zzbyh;
                case 5:
                    zzdtn<zzk> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzk.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbyh);
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
    public static final class zzl extends zzdrt<zzl, zza> implements zzdtg {
        private static final zzl zzbyk;
        private static volatile zzdtn<zzl> zzdz;
        private int zzbyi;
        private int zzbyj;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzl, zza> implements zzdtg {
            private zza() {
                super(zzl.zzbyk);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzl zzlVar = new zzl();
            zzbyk = zzlVar;
            zzdrt.a((Class<zzl>) zzl.class, zzlVar);
        }

        private zzl() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbyk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzbyi", "zzbyj"});
                case 4:
                    return zzbyk;
                case 5:
                    zzdtn<zzl> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzl.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbyk);
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
    public static final class zzm extends zzdrt<zzm, zza> implements zzdtg {
        private static final zzm zzbyn;
        private static volatile zzdtn<zzm> zzdz;
        private int zzbyl;
        private int zzbym;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzm, zza> implements zzdtg {
            private zza() {
                super(zzm.zzbyn);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzbyn = zzmVar;
            zzdrt.a((Class<zzm>) zzm.class, zzmVar);
        }

        private zzm() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbyn, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzbyl", "zzbym"});
                case 4:
                    return zzbyn;
                case 5:
                    zzdtn<zzm> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzm.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbyn);
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
    public static final class zzn extends zzdrt<zzn, zza> implements zzdtg {
        private static final zzn zzbyo;
        private static volatile zzdtn<zzn> zzdz;
        private String zzbvx = "";
        private int zzbvy;
        private zzo zzbwa;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzn, zza> implements zzdtg {
            private zza() {
                super(zzn.zzbyo);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzn zznVar = new zzn();
            zzbyo = zznVar;
            zzdrt.a((Class<zzn>) zzn.class, zznVar);
        }

        private zzn() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbyo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbvx", "zzbvy", zzte.zzaf(), "zzbwa"});
                case 4:
                    return zzbyo;
                case 5:
                    zzdtn<zzn> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzn.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbyo);
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
    public static final class zzo extends zzdrt<zzo, zza> implements zzdtg {
        private static final zzo zzbyr;
        private static volatile zzdtn<zzo> zzdz;
        private int zzbyp;
        private int zzbyq;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzo, zza> implements zzdtg {
            private zza() {
                super(zzo.zzbyr);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzbyr = zzoVar;
            zzdrt.a((Class<zzo>) zzo.class, zzoVar);
        }

        private zzo() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbyr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzbyp", "zzbyq"});
                case 4:
                    return zzbyr;
                case 5:
                    zzdtn<zzo> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzo.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbyr);
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
    public static final class zzp extends zzdrt<zzp, zza> implements zzdtg {
        private static final zzp zzbyu;
        private static volatile zzdtn<zzp> zzdz;
        private int zzbwc = 1000;
        private zzq zzbys;
        private zzo zzbyt;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzp, zza> implements zzdtg {
            private zza() {
                super(zzp.zzbyu);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzp zzpVar = new zzp();
            zzbyu = zzpVar;
            zzdrt.a((Class<zzp>) zzp.class, zzpVar);
        }

        private zzp() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzp();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbyu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbwc", zzte.zzaf(), "zzbys", "zzbyt"});
                case 4:
                    return zzbyu;
                case 5:
                    zzdtn<zzp> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzp.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbyu);
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
    public static final class zzq extends zzdrt<zzq, zzb> implements zzdtg {
        private static final zzq zzbyw;
        private static volatile zzdtn<zzq> zzdz;
        private int zzbyv;
        private int zzdl;

        /* loaded from: classes.dex */
        public enum zza implements zzdry {
            VIDEO_ERROR_CODE_UNSPECIFIED(0),
            OPENGL_RENDERING_FAILED(1),
            CACHE_LOAD_FAILED(2),
            ANDROID_TARGET_API_TOO_LOW(3);

            private static final zzdrx<zza> zzen = new zzto();
            private final int value;

            zza(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zztn.a;
            }

            public static zza zzch(int i) {
                if (i == 0) {
                    return VIDEO_ERROR_CODE_UNSPECIFIED;
                }
                if (i == 1) {
                    return OPENGL_RENDERING_FAILED;
                }
                if (i == 2) {
                    return CACHE_LOAD_FAILED;
                }
                if (i != 3) {
                    return null;
                }
                return ANDROID_TARGET_API_TOO_LOW;
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
        public static final class zzb extends zzdrt.zzb<zzq, zzb> implements zzdtg {
            private zzb() {
                super(zzq.zzbyw);
            }

            /* synthetic */ zzb(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzq zzqVar = new zzq();
            zzbyw = zzqVar;
            zzdrt.a((Class<zzq>) zzq.class, zzqVar);
        }

        private zzq() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zzb(zzsxVar);
                case 3:
                    return zzdrt.a(zzbyw, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f\u0000", new Object[]{"zzdl", "zzbyv", zza.zzaf()});
                case 4:
                    return zzbyw;
                case 5:
                    zzdtn<zzq> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzq.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbyw);
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
    public static final class zzr extends zzdrt<zzr, zza> implements zzdtg {
        private static final zzr zzbzf;
        private static volatile zzdtn<zzr> zzdz;
        private int zzbwc = 1000;
        private zzq zzbys;
        private int zzbzc;
        private int zzbzd;
        private int zzbze;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzr, zza> implements zzdtg {
            private zza() {
                super(zzr.zzbzf);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzr zzrVar = new zzr();
            zzbzf = zzrVar;
            zzdrt.a((Class<zzr>) zzr.class, zzrVar);
        }

        private zzr() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbzf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"zzdl", "zzbwc", zzte.zzaf(), "zzbys", "zzbzc", "zzbzd", "zzbze"});
                case 4:
                    return zzbzf;
                case 5:
                    zzdtn<zzr> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzr.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbzf);
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
    public static final class zzs extends zzdrt<zzs, zza> implements zzdtg {
        private static final zzs zzbzg;
        private static volatile zzdtn<zzs> zzdz;
        private int zzbwc = 1000;
        private zzq zzbys;
        private zzo zzbyt;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzs, zza> implements zzdtg {
            private zza() {
                super(zzs.zzbzg);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzs zzsVar = new zzs();
            zzbzg = zzsVar;
            zzdrt.a((Class<zzs>) zzs.class, zzsVar);
        }

        private zzs() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbwc", zzte.zzaf(), "zzbys", "zzbyt"});
                case 4:
                    return zzbzg;
                case 5:
                    zzdtn<zzs> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzs.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbzg);
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
    public static final class zzt extends zzdrt<zzt, zza> implements zzdtg {
        private static final zzt zzbzi;
        private static volatile zzdtn<zzt> zzdz;
        private int zzbwc = 1000;
        private zzq zzbys;
        private int zzbzc;
        private int zzbzd;
        private int zzbze;
        private long zzbzh;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzt, zza> implements zzdtg {
            private zza() {
                super(zzt.zzbzi);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzt zztVar = new zzt();
            zzbzi = zztVar;
            zzdrt.a((Class<zzt>) zzt.class, zztVar);
        }

        private zzt() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbzi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u0003\u0005", new Object[]{"zzdl", "zzbwc", zzte.zzaf(), "zzbys", "zzbzc", "zzbzd", "zzbze", "zzbzh"});
                case 4:
                    return zzbzi;
                case 5:
                    zzdtn<zzt> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzt.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbzi);
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
    public static final class zzu extends zzdrt<zzu, zza> implements zzdtg {
        private static final zzu zzbzj;
        private static volatile zzdtn<zzu> zzdz;
        private int zzbwc = 1000;
        private zzq zzbys;
        private zzo zzbyt;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzu, zza> implements zzdtg {
            private zza() {
                super(zzu.zzbzj);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzu zzuVar = new zzu();
            zzbzj = zzuVar;
            zzdrt.a((Class<zzu>) zzu.class, zzuVar);
        }

        private zzu() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbzj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001\u0003\t\u0002", new Object[]{"zzdl", "zzbwc", zzte.zzaf(), "zzbys", "zzbyt"});
                case 4:
                    return zzbzj;
                case 5:
                    zzdtn<zzu> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzu.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbzj);
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
    public static final class zzv extends zzdrt<zzv, zza> implements zzdtg {
        private static final zzv zzbzk;
        private static volatile zzdtn<zzv> zzdz;
        private int zzbwc = 1000;
        private zzq zzbys;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzv, zza> implements zzdtg {
            private zza() {
                super(zzv.zzbzk);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }
        }

        static {
            zzv zzvVar = new zzv();
            zzbzk = zzvVar;
            zzdrt.a((Class<zzv>) zzv.class, zzvVar);
        }

        private zzv() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbzk, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\t\u0001", new Object[]{"zzdl", "zzbwc", zzte.zzaf(), "zzbys"});
                case 4:
                    return zzbzk;
                case 5:
                    zzdtn<zzv> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzv.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbzk);
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
    public static final class zzw extends zzdrt<zzw, zza> implements zzdtg {
        private static final zzw zzbzn;
        private static volatile zzdtn<zzw> zzdz;
        private boolean zzbzl;
        private int zzbzm;
        private int zzdl;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzw, zza> implements zzdtg {
            private zza() {
                super(zzw.zzbzn);
            }

            /* synthetic */ zza(zzsx zzsxVar) {
                this();
            }

            public final zza zzci(int i) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzw) this.a).zzcj(i);
                return this;
            }

            public final boolean zzof() {
                return ((zzw) this.a).zzof();
            }

            public final zza zzw(boolean z) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzw) this.a).zzx(z);
                return this;
            }
        }

        static {
            zzw zzwVar = new zzw();
            zzbzn = zzwVar;
            zzdrt.a((Class<zzw>) zzw.class, zzwVar);
        }

        private zzw() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzcj(int i) {
            this.zzdl |= 2;
            this.zzbzm = i;
        }

        public static zza zzog() {
            return zzbzn.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzx(boolean z) {
            this.zzdl |= 1;
            this.zzbzl = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzsx zzsxVar = null;
            switch (zzsx.a[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza(zzsxVar);
                case 3:
                    return zzdrt.a(zzbzn, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0004\u0001", new Object[]{"zzdl", "zzbzl", "zzbzm"});
                case 4:
                    return zzbzn;
                case 5:
                    zzdtn<zzw> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzw.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzbzn);
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

        public final boolean zzof() {
            return this.zzbzl;
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzbo {

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt<zza, C0011zza> implements zzdtg {
        private static volatile zzdtn<zza> zzdz;
        private static final zza zzef;
        private int zzdl;
        private zzb zzed;
        private zzc zzee;

        /* renamed from: com.google.android.gms.internal.ads.zzbo$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0011zza extends zzdrt.zzb<zza, C0011zza> implements zzdtg {
            private C0011zza() {
                super(zza.zzef);
            }

            /* synthetic */ C0011zza(zzbn zzbnVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzef = zzaVar;
            zzdrt.a((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbn zzbnVar = null;
            switch (zzbn.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0011zza(zzbnVar);
                case 3:
                    return zzdrt.a(zzef, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzdl", "zzed", "zzee"});
                case 4:
                    return zzef;
                case 5:
                    zzdtn<zza> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zza.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzef);
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

        public final boolean zzw() {
            return (this.zzdl & 1) != 0;
        }

        public final zzb zzx() {
            zzb zzbVar = this.zzed;
            return zzbVar == null ? zzb.zzac() : zzbVar;
        }

        public final boolean zzy() {
            return (this.zzdl & 2) != 0;
        }

        public final zzc zzz() {
            zzc zzcVar = this.zzee;
            return zzcVar == null ? zzc.zzah() : zzcVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzdrt<zzb, zza> implements zzdtg {
        private static volatile zzdtn<zzb> zzdz;
        private static final zzb zzeh;
        private int zzdl;
        private int zzeg = 2;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzb, zza> implements zzdtg {
            private zza() {
                super(zzb.zzeh);
            }

            /* synthetic */ zza(zzbn zzbnVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzeh = zzbVar;
            zzdrt.a((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zzb zzac() {
            return zzeh;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbn zzbnVar = null;
            switch (zzbn.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzbnVar);
                case 3:
                    return zzdrt.a(zzeh, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b\f\u0000", new Object[]{"zzdl", "zzeg", zzbq.zzaf()});
                case 4:
                    return zzeh;
                case 5:
                    zzdtn<zzb> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzb.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzeh);
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

        public final zzbq zzab() {
            zzbq zze = zzbq.zze(this.zzeg);
            return zze == null ? zzbq.ENUM_SIGNAL_SOURCE_ADSHIELD : zze;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc extends zzdrt<zzc, zza> implements zzdtg {
        private static volatile zzdtn<zzc> zzdz;
        private static final zzc zzev;
        private int zzdl;
        private String zzep = "";
        private String zzeq = "";
        private String zzer = "";
        private String zzes = "";
        private String zzet = "";
        private String zzeu = "";

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzc, zza> implements zzdtg {
            private zza() {
                super(zzc.zzev);
            }

            /* synthetic */ zza(zzbn zzbnVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzev = zzcVar;
            zzdrt.a((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        public static zzc zzah() {
            return zzev;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbn zzbnVar = null;
            switch (zzbn.a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzbnVar);
                case 3:
                    return zzdrt.a(zzev, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005", new Object[]{"zzdl", "zzep", "zzeq", "zzer", "zzes", "zzet", "zzeu"});
                case 4:
                    return zzev;
                case 5:
                    zzdtn<zzc> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzc.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzev);
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

        public final String zzag() {
            return this.zzep;
        }
    }
}

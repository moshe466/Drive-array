package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzbo {

    /* loaded from: classes.dex */
    public static final class zza extends zzfd<zza, C0031zza> implements zzgq {
        private static final zza zzh;
        private static volatile zzgx<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        /* renamed from: com.google.android.gms.internal.measurement.zzbo$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0031zza extends zzfd.zzb<zza, C0031zza> implements zzgq {
            private C0031zza() {
                super(zza.zzh);
            }

            /* synthetic */ C0031zza(zzbq zzbqVar) {
                this();
            }

            public final C0031zza zza(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza(str);
                return this;
            }

            public final String zza() {
                return ((zza) this.a).zza();
            }

            public final boolean zzb() {
                return ((zza) this.a).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.a).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.a).zzd();
            }

            public final int zze() {
                return ((zza) this.a).zze();
            }
        }

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            zzfd.a((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfd
        public final Object a(int i, Object obj, Object obj2) {
            zzbq zzbqVar = null;
            switch (zzbq.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0031zza(zzbqVar);
                case 3:
                    return zzfd.a(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgx<zza> zzgxVar = zzi;
                    if (zzgxVar == null) {
                        synchronized (zza.class) {
                            zzgxVar = zzi;
                            if (zzgxVar == null) {
                                zzgxVar = new zzfd.zza<>(zzh);
                                zzi = zzgxVar;
                            }
                        }
                    }
                    return zzgxVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzfd<zzb, zza> implements zzgq {
        private static final zzb zzl;
        private static volatile zzgx<zzb> zzm;
        private int zzc;
        private long zzd;
        private int zzf;
        private boolean zzk;
        private String zze = "";
        private zzfl<zzc> zzg = zzfd.e();
        private zzfl<zza> zzh = zzfd.e();
        private zzfl<zzbj.zza> zzi = zzfd.e();
        private String zzj = "";

        /* loaded from: classes.dex */
        public static final class zza extends zzfd.zzb<zzb, zza> implements zzgq {
            private zza() {
                super(zzb.zzl);
            }

            /* synthetic */ zza(zzbq zzbqVar) {
                this();
            }

            public final int zza() {
                return ((zzb) this.a).zzf();
            }

            public final zza zza(int i) {
                return ((zzb) this.a).zza(i);
            }

            public final zza zza(int i, zza.C0031zza c0031zza) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzb) this.a).zza(i, (zza) c0031zza.zzu());
                return this;
            }

            public final List<zzbj.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.a).zzg());
            }

            public final zza zzc() {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzb) this.a).zzl();
                return this;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzl = zzbVar;
            zzfd.a((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zza zzaVar) {
            zzaVar.getClass();
            if (!this.zzh.zza()) {
                this.zzh = zzfd.a(this.zzh);
            }
            this.zzh.set(i, zzaVar);
        }

        public static zza zzi() {
            return zzl.b();
        }

        public static zzb zzj() {
            return zzl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzfd.e();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfd
        public final Object a(int i, Object obj, Object obj2) {
            zzbq zzbqVar = null;
            switch (zzbq.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzbqVar);
                case 3:
                    return zzfd.a(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\u0004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\b\u0003\b\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbj.zza.class, "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgx<zzb> zzgxVar = zzm;
                    if (zzgxVar == null) {
                        synchronized (zzb.class) {
                            zzgxVar = zzm;
                            if (zzgxVar == null) {
                                zzgxVar = new zzfd.zza<>(zzl);
                                zzm = zzgxVar;
                            }
                        }
                    }
                    return zzgxVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final zza zza(int i) {
            return this.zzh.get(i);
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final List<zzbj.zza> zzg() {
            return this.zzi;
        }

        public final boolean zzh() {
            return this.zzk;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc extends zzfd<zzc, zza> implements zzgq {
        private static final zzc zzf;
        private static volatile zzgx<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        /* loaded from: classes.dex */
        public static final class zza extends zzfd.zzb<zzc, zza> implements zzgq {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzbq zzbqVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzf = zzcVar;
            zzfd.a((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzfd
        public final Object a(int i, Object obj, Object obj2) {
            zzbq zzbqVar = null;
            switch (zzbq.a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzbqVar);
                case 3:
                    return zzfd.a(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzc> zzgxVar = zzg;
                    if (zzgxVar == null) {
                        synchronized (zzc.class) {
                            zzgxVar = zzg;
                            if (zzgxVar == null) {
                                zzgxVar = new zzfd.zza<>(zzf);
                                zzg = zzgxVar;
                            }
                        }
                    }
                    return zzgxVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }
    }
}

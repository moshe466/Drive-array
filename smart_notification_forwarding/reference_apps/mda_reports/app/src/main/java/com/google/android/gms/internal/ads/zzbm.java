package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzbm {

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt<zza, C0009zza> implements zzdtg {
        private static final zza zzdy;
        private static volatile zzdtn<zza> zzdz;
        private int zzdl;
        private long zzdn;
        private long zzdr;
        private long zzds;
        private long zzdu;
        private String zzdm = "";
        private String zzdo = "";
        private String zzdp = "";
        private String zzdq = "";
        private String zzdt = "";
        private String zzdv = "";
        private String zzdw = "";
        private zzdsb<zzb> zzdx = zzdrt.d();

        /* renamed from: com.google.android.gms.internal.ads.zzbm$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0009zza extends zzdrt.zzb<zza, C0009zza> implements zzdtg {
            private C0009zza() {
                super(zza.zzdy);
            }

            /* synthetic */ C0009zza(zzbl zzblVar) {
                this();
            }

            public final C0009zza zza(zzb.C0010zza c0010zza) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza((zzb) c0010zza.zzbaf());
                return this;
            }

            public final C0009zza zzc(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzd(j);
                return this;
            }

            public final C0009zza zzi(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzn(str);
                return this;
            }

            public final C0009zza zzj(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzo(str);
                return this;
            }

            public final C0009zza zzk(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzp(str);
                return this;
            }

            public final C0009zza zzl(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzq(str);
                return this;
            }

            public final C0009zza zzm(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzr(str);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public static final class zzb extends zzdrt<zzb, C0010zza> implements zzdtg {
            private static volatile zzdtn<zzb> zzdz;
            private static final zzb zzec;
            private int zzdl;
            private String zzea = "";
            private String zzeb = "";

            /* renamed from: com.google.android.gms.internal.ads.zzbm$zza$zzb$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0010zza extends zzdrt.zzb<zzb, C0010zza> implements zzdtg {
                private C0010zza() {
                    super(zzb.zzec);
                }

                /* synthetic */ C0010zza(zzbl zzblVar) {
                    this();
                }

                public final C0010zza zzs(String str) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzb) this.a).zzu(str);
                    return this;
                }

                public final C0010zza zzt(String str) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzb) this.a).zzv(str);
                    return this;
                }
            }

            static {
                zzb zzbVar = new zzb();
                zzec = zzbVar;
                zzdrt.a((Class<zzb>) zzb.class, zzbVar);
            }

            private zzb() {
            }

            public static C0010zza zzu() {
                return zzec.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzu(String str) {
                str.getClass();
                this.zzdl |= 1;
                this.zzea = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzv(String str) {
                str.getClass();
                this.zzdl |= 2;
                this.zzeb = str;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzbl zzblVar = null;
                switch (zzbl.a[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C0010zza(zzblVar);
                    case 3:
                        return zzdrt.a(zzec, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzdl", "zzea", "zzeb"});
                    case 4:
                        return zzec;
                    case 5:
                        zzdtn<zzb> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzb.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzec);
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
            zzdy = zzaVar;
            zzdrt.a((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            zzbVar.getClass();
            if (!this.zzdx.zzaxp()) {
                this.zzdx = zzdrt.a(this.zzdx);
            }
            this.zzdx.add(zzbVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzdl |= 2;
            this.zzdn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzdl |= 1;
            this.zzdm = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzdl |= 4;
            this.zzdo = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzdl |= 8;
            this.zzdp = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zzdl |= 16;
            this.zzdq = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzdl |= 1024;
            this.zzdw = str;
        }

        public static C0009zza zzs() {
            return zzdy.b();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbl zzblVar = null;
            switch (zzbl.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0009zza(zzblVar);
                case 3:
                    return zzdrt.a(zzdy, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u001b", new Object[]{"zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt", "zzdu", "zzdv", "zzdw", "zzdx", zzb.class});
                case 4:
                    return zzdy;
                case 5:
                    zzdtn<zza> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zza.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzdy);
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
}

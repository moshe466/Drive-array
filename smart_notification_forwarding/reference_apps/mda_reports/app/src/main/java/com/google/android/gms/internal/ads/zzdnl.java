package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;

/* loaded from: classes.dex */
public final class zzdnl extends zzdrt<zzdnl, zza> implements zzdtg {
    private static volatile zzdtn<zzdnl> zzdz;
    private static final zzdnl zzhdy;
    private int zzhdq;
    private zzdsb<zzb> zzhdx = zzdrt.d();

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt.zzb<zzdnl, zza> implements zzdtg {
        private zza() {
            super(zzdnl.zzhdy);
        }

        /* synthetic */ zza(zzdnm zzdnmVar) {
            this();
        }

        public final zza zzb(zzb zzbVar) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdnl) this.a).zza(zzbVar);
            return this;
        }

        public final zza zzer(int i) {
            if (this.b) {
                a();
                this.b = false;
            }
            ((zzdnl) this.a).zzeq(i);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzdrt<zzb, zza> implements zzdtg {
        private static volatile zzdtn<zzb> zzdz;
        private static final zzb zzhdz;
        private String zzhcs = "";
        private int zzhdj;
        private int zzhdu;
        private int zzhdv;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzb, zza> implements zzdtg {
            private zza() {
                super(zzb.zzhdz);
            }

            /* synthetic */ zza(zzdnm zzdnmVar) {
                this();
            }

            public final zza zza(zzdne zzdneVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzb) this.a).zzb(zzdneVar);
                return this;
            }

            public final zza zza(zzdnw zzdnwVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzb) this.a).zzb(zzdnwVar);
                return this;
            }

            public final zza zzes(int i) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzb) this.a).zzet(i);
                return this;
            }

            public final zza zzhc(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzb) this.a).zzha(str);
                return this;
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzhdz = zzbVar;
            zzdrt.a((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zza zzawf() {
            return zzhdz.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzdne zzdneVar) {
            this.zzhdu = zzdneVar.zzae();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzdnw zzdnwVar) {
            this.zzhdj = zzdnwVar.zzae();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzet(int i) {
            this.zzhdv = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzha(String str) {
            str.getClass();
            this.zzhcs = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzdnm zzdnmVar = null;
            switch (zzdnm.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzdnmVar);
                case 3:
                    return zzdrt.a(zzhdz, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzhcs", "zzhdu", "zzhdv", "zzhdj"});
                case 4:
                    return zzhdz;
                case 5:
                    zzdtn<zzb> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzb.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzhdz);
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
        zzdnl zzdnlVar = new zzdnl();
        zzhdy = zzdnlVar;
        zzdrt.a((Class<zzdnl>) zzdnl.class, zzdnlVar);
    }

    private zzdnl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzb zzbVar) {
        zzbVar.getClass();
        if (!this.zzhdx.zzaxp()) {
            this.zzhdx = zzdrt.a(this.zzhdx);
        }
        this.zzhdx.add(zzbVar);
    }

    public static zza zzawd() {
        return zzhdy.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzeq(int i) {
        this.zzhdq = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdrt
    public final Object a(int i, Object obj, Object obj2) {
        zzdnm zzdnmVar = null;
        switch (zzdnm.a[i - 1]) {
            case 1:
                return new zzdnl();
            case 2:
                return new zza(zzdnmVar);
            case 3:
                return zzdrt.a(zzhdy, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzhdq", "zzhdx", zzb.class});
            case 4:
                return zzhdy;
            case 5:
                zzdtn<zzdnl> zzdtnVar = zzdz;
                if (zzdtnVar == null) {
                    synchronized (zzdnl.class) {
                        zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            zzdtnVar = new zzdrt.zza<>(zzhdy);
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

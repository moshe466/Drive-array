package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaky;
import com.google.android.gms.internal.p002firebaseauthapi.zzws;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public final class zzxc extends zzaky<zzxc, zzb> implements zzame {
    private static final zzxc zzc;
    private static volatile zzamp<zzxc> zzd;
    private int zze;
    private zzalc<zza> zzf = zzaky.zzp();

    /* loaded from: classes.dex */
    public static final class zza extends zzaky<zza, C0000zza> implements zzame {
        private static final zza zzc;
        private static volatile zzamp<zza> zzd;
        private int zze;
        private zzws zzf;
        private int zzg;
        private int zzh;
        private int zzi;

        /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxc$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0000zza extends zzaky.zza<zza, C0000zza> implements zzame {
            public final C0000zza zza(zzws.zzb zzbVar) {
                zzh();
                zza.zza((zza) this.zza, (zzws) ((zzaky) zzbVar.zze()));
                return this;
            }

            private C0000zza() {
                super(zza.zzc);
            }

            public final C0000zza zza(zzws zzwsVar) {
                zzh();
                zza.zza((zza) this.zza, zzwsVar);
                return this;
            }

            public final C0000zza zza(int i) {
                zzh();
                ((zza) this.zza).zzh = i;
                return this;
            }

            public final C0000zza zza(zzxu zzxuVar) {
                zzh();
                zza.zza((zza) this.zza, zzxuVar);
                return this;
            }

            public final C0000zza zza(zzwt zzwtVar) {
                zzh();
                zza.zza((zza) this.zza, zzwtVar);
                return this;
            }
        }

        static {
            zza zzaVar = new zza();
            zzc = zzaVar;
            zzaky.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public static C0000zza zzd() {
            return (C0000zza) zzc.zzm();
        }

        public final boolean e_() {
            if ((this.zze & 1) != 0) {
                return true;
            }
            return false;
        }

        public final int zza() {
            return this.zzh;
        }

        public final zzws zzb() {
            zzws zzwsVar = this.zzf;
            if (zzwsVar == null) {
                return zzws.zzd();
            }
            return zzwsVar;
        }

        public final zzwt zzc() {
            zzwt zza = zzwt.zza(this.zzg);
            if (zza == null) {
                return zzwt.UNRECOGNIZED;
            }
            return zza;
        }

        public final zzxu zzf() {
            zzxu zza = zzxu.zza(this.zzi);
            if (zza == null) {
                return zzxu.UNRECOGNIZED;
            }
            return zza;
        }

        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
        public final Object zza(int i, Object obj, Object obj2) {
            zzamp zzampVar;
            switch (zzxb.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0000zza();
                case 3:
                    return zzaky.zza(zzc, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzc;
                case 5:
                    zzamp<zza> zzampVar2 = zzd;
                    if (zzampVar2 != null) {
                        return zzampVar2;
                    }
                    synchronized (zza.class) {
                        try {
                            zzampVar = zzd;
                            if (zzampVar == null) {
                                zzampVar = new zzaky.zzc(zzc);
                                zzd = zzampVar;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return zzampVar;
                case 6:
                    return (byte) 1;
                default:
                    throw null;
            }
        }

        public static /* synthetic */ void zza(zza zzaVar, zzws zzwsVar) {
            zzwsVar.getClass();
            zzaVar.zzf = zzwsVar;
            zzaVar.zze |= 1;
        }

        public static /* synthetic */ void zza(zza zzaVar, zzxu zzxuVar) {
            zzaVar.zzi = zzxuVar.zza();
        }

        public static /* synthetic */ void zza(zza zzaVar, zzwt zzwtVar) {
            zzaVar.zzg = zzwtVar.zza();
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzaky.zza<zzxc, zzb> implements zzame {
        public final zzb zza(zza zzaVar) {
            zzh();
            zzxc.zza((zzxc) this.zza, zzaVar);
            return this;
        }

        private zzb() {
            super(zzxc.zzc);
        }

        public final zzb zza(int i) {
            zzh();
            ((zzxc) this.zza).zze = i;
            return this;
        }
    }

    static {
        zzxc zzxcVar = new zzxc();
        zzc = zzxcVar;
        zzaky.zza((Class<zzxc>) zzxc.class, zzxcVar);
    }

    private zzxc() {
    }

    public static zzb zzc() {
        return (zzb) zzc.zzm();
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final List<zza> zze() {
        return this.zzf;
    }

    public final zza zza(int i) {
        return this.zzf.get(i);
    }

    public static zzxc zza(InputStream inputStream, zzakk zzakkVar) {
        return (zzxc) zzaky.zza(zzc, inputStream, zzakkVar);
    }

    public static zzxc zza(byte[] bArr, zzakk zzakkVar) {
        return (zzxc) zzaky.zza(zzc, bArr, zzakkVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaky
    public final Object zza(int i, Object obj, Object obj2) {
        zzamp zzampVar;
        switch (zzxb.zza[i - 1]) {
            case 1:
                return new zzxc();
            case 2:
                return new zzb();
            case 3:
                return zzaky.zza(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zze", "zzf", zza.class});
            case 4:
                return zzc;
            case 5:
                zzamp<zzxc> zzampVar2 = zzd;
                if (zzampVar2 != null) {
                    return zzampVar2;
                }
                synchronized (zzxc.class) {
                    try {
                        zzampVar = zzd;
                        if (zzampVar == null) {
                            zzampVar = new zzaky.zzc(zzc);
                            zzd = zzampVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return zzampVar;
            case 6:
                return (byte) 1;
            default:
                throw null;
        }
    }

    public static /* synthetic */ void zza(zzxc zzxcVar, zza zzaVar) {
        zzaVar.getClass();
        zzalc<zza> zzalcVar = zzxcVar.zzf;
        if (!zzalcVar.zzc()) {
            zzxcVar.zzf = zzaky.zza(zzalcVar);
        }
        zzxcVar.zzf.add(zzaVar);
    }
}

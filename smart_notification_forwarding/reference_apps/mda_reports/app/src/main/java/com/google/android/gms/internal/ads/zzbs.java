package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import com.google.common.primitives.Ints;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class zzbs {

    /* loaded from: classes.dex */
    public static final class zza extends zzdrt<zza, zzb> implements zzdtg {
        private static volatile zzdtn<zza> zzdz;
        private static final zza zzht;
        private int zzdl;
        private int zzex;
        private int zzey;
        private long zzfa;
        private long zzfb;
        private long zzfc;
        private long zzfd;
        private long zzfe;
        private long zzff;
        private long zzfg;
        private long zzfh;
        private long zzfi;
        private long zzfj;
        private long zzfl;
        private long zzfm;
        private long zzfn;
        private long zzfo;
        private long zzfp;
        private long zzfq;
        private long zzfr;
        private long zzfs;
        private long zzft;
        private long zzfw;
        private long zzfx;
        private long zzfy;
        private long zzfz;
        private zzb zzgc;
        private zze zzgs;
        private zzf zzgu;
        private int zzhf;
        private int zzhg;
        private int zzhh;
        private zze zzhi;
        private long zzhm;
        private boolean zzhp;
        private long zzhr;
        private zzd zzhs;
        private String zzez = "";
        private String zzdv = "";
        private String zzfk = "";
        private String zzep = "";
        private String zzfu = "D";
        private String zzfv = "";
        private String zzer = "";
        private long zzga = -1;
        private long zzgb = -1;
        private long zzgd = -1;
        private long zzge = -1;
        private long zzgf = -1;
        private long zzgg = -1;
        private long zzgh = -1;
        private long zzgi = -1;
        private String zzes = "D";
        private String zzet = "D";
        private long zzgj = -1;
        private int zzgk = 1000;
        private int zzgl = 1000;
        private long zzgm = -1;
        private long zzgn = -1;
        private long zzgo = -1;
        private long zzgp = -1;
        private long zzgq = -1;
        private int zzgr = 1000;
        private zzdsb<zze> zzgt = zzdrt.d();
        private long zzgv = -1;
        private long zzgw = -1;
        private long zzgx = -1;
        private long zzgy = -1;
        private long zzgz = -1;
        private long zzha = -1;
        private long zzhb = -1;
        private long zzhc = -1;
        private String zzhd = "D";
        private long zzhe = -1;
        private long zzhj = -1;
        private int zzhk = 1000;
        private int zzhl = 1000;
        private String zzhn = "";
        private int zzho = 2;
        private String zzhq = "";

        /* renamed from: com.google.android.gms.internal.ads.zzbs$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public enum EnumC0012zza implements zzdry {
            DEBUGGER_STATE_UNSPECIFIED(0),
            DEBUGGER_STATE_NOT_INSTALLED(1),
            DEBUGGER_STATE_INSTALLED(2),
            DEBUGGER_STATE_ACTIVE(3),
            DEBUGGER_STATE_ENVVAR(4),
            DEBUGGER_STATE_MACHPORT(5),
            DEBUGGER_STATE_ENVVAR_MACHPORT(6);

            private static final zzdrx<EnumC0012zza> zzen = new zzbv();
            private final int value;

            EnumC0012zza(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zzbu.a;
            }

            public static EnumC0012zza zzg(int i) {
                switch (i) {
                    case 0:
                        return DEBUGGER_STATE_UNSPECIFIED;
                    case 1:
                        return DEBUGGER_STATE_NOT_INSTALLED;
                    case 2:
                        return DEBUGGER_STATE_INSTALLED;
                    case 3:
                        return DEBUGGER_STATE_ACTIVE;
                    case 4:
                        return DEBUGGER_STATE_ENVVAR;
                    case 5:
                        return DEBUGGER_STATE_MACHPORT;
                    case 6:
                        return DEBUGGER_STATE_ENVVAR_MACHPORT;
                    default:
                        return null;
                }
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + EnumC0012zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.ads.zzdry
            public final int zzae() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class zzb extends zzdrt.zzb<zza, zzb> implements zzdtg {
            private zzb() {
                super(zza.zzht);
            }

            /* synthetic */ zzb(zzbt zzbtVar) {
                this();
            }

            public final zzb zzaf(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzw(str);
                return this;
            }

            public final zzb zzag(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzx(str);
                return this;
            }

            public final zzb zzah(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzy(str);
                return this;
            }

            public final zzb zzai(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzz(str);
                return this;
            }

            public final zzb zzaj(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzaa(str);
                return this;
            }

            public final zzb zzak(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzab(str);
                return this;
            }

            public final zzb zzal(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zze(j);
                return this;
            }

            public final zzb zzal(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzac(str);
                return this;
            }

            public final zzb zzam(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzf(j);
                return this;
            }

            public final zzb zzam(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzad(str);
                return this;
            }

            public final zzb zzan(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzg(j);
                return this;
            }

            public final zzb zzan(String str) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzae(str);
                return this;
            }

            public final zzb zzao(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzh(j);
                return this;
            }

            public final zzb zzap() {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzak();
                return this;
            }

            public final zzb zzap(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzi(j);
                return this;
            }

            public final zzb zzaq(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzj(j);
                return this;
            }

            public final zzb zzar(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzk(j);
                return this;
            }

            public final zzb zzas(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzl(j);
                return this;
            }

            public final zzb zzat(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzm(j);
                return this;
            }

            public final zzb zzau(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzn(j);
                return this;
            }

            public final zzb zzav(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzo(j);
                return this;
            }

            public final zzb zzaw(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzp(j);
                return this;
            }

            public final zzb zzax(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzq(j);
                return this;
            }

            public final zzb zzay(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzr(j);
                return this;
            }

            public final zzb zzaz(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzs(j);
                return this;
            }

            public final zzb zzb(zzc zzcVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza(zzcVar);
                return this;
            }

            public final zzb zzb(zzf zzfVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza(zzfVar);
                return this;
            }

            public final zzb zzb(boolean z) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza(z);
                return this;
            }

            public final zzb zzba(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzt(j);
                return this;
            }

            @Deprecated
            public final zzb zzbb(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzu(j);
                return this;
            }

            public final zzb zzbc(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzv(j);
                return this;
            }

            public final zzb zzbd(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzw(j);
                return this;
            }

            public final zzb zzbe(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzx(j);
                return this;
            }

            public final zzb zzbf(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzy(j);
                return this;
            }

            public final zzb zzbg(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzz(j);
                return this;
            }

            public final zzb zzbh(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzaa(j);
                return this;
            }

            public final zzb zzbi(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzab(j);
                return this;
            }

            public final zzb zzbj(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzac(j);
                return this;
            }

            public final zzb zzbk(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzad(j);
                return this;
            }

            public final zzb zzbl(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzae(j);
                return this;
            }

            public final zzb zzbm(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzaf(j);
                return this;
            }

            public final zzb zzbn(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzag(j);
                return this;
            }

            public final zzb zzbo(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzah(j);
                return this;
            }

            public final zzb zzbp(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzai(j);
                return this;
            }

            public final zzb zzbq(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzaj(j);
                return this;
            }

            public final zzb zzbr(long j) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzak(j);
                return this;
            }

            public final zzb zzc(zze zzeVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza(zzeVar);
                return this;
            }

            public final zzb zzd(zze zzeVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzb(zzeVar);
                return this;
            }

            public final zzb zze(zzcd zzcdVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zza(zzcdVar);
                return this;
            }

            public final zzb zzf(zzcd zzcdVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzb(zzcdVar);
                return this;
            }

            public final zzb zzg(zzcd zzcdVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzc(zzcdVar);
                return this;
            }

            public final zzb zzh(zzcd zzcdVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zza) this.a).zzd(zzcdVar);
                return this;
            }
        }

        /* loaded from: classes.dex */
        public enum zzc implements zzdry {
            DEVICE_IDENTIFIER_NO_ID(0),
            DEVICE_IDENTIFIER_APP_SPECIFIC_ID(1),
            DEVICE_IDENTIFIER_GLOBAL_ID(2),
            DEVICE_IDENTIFIER_ADVERTISER_ID(3),
            DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED(4),
            DEVICE_IDENTIFIER_ANDROID_AD_ID(5),
            DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID(6);

            private static final zzdrx<zzc> zzen = new zzbw();
            private final int value;

            zzc(int i) {
                this.value = i;
            }

            public static zzdsa zzaf() {
                return zzbx.a;
            }

            public static zzc zzh(int i) {
                switch (i) {
                    case 0:
                        return DEVICE_IDENTIFIER_NO_ID;
                    case 1:
                        return DEVICE_IDENTIFIER_APP_SPECIFIC_ID;
                    case 2:
                        return DEVICE_IDENTIFIER_GLOBAL_ID;
                    case 3:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID;
                    case 4:
                        return DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED;
                    case 5:
                        return DEVICE_IDENTIFIER_ANDROID_AD_ID;
                    case 6:
                        return DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID;
                    default:
                        return null;
                }
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
        public enum zzd implements zzdry {
            ERROR_ENCODE_SIZE_FAIL(1),
            ERROR_UNKNOWN(3),
            ERROR_NO_SIGNALS(5),
            ERROR_ENCRYPTION(7),
            ERROR_MEMORY(9),
            ERROR_SIMULATOR(11),
            ERROR_SERVICE(13),
            ERROR_THREAD(15),
            PSN_WEB64_FAIL(2),
            PSN_DECRYPT_SIZE_FAIL(4),
            PSN_MD5_CHECK_FAIL(8),
            PSN_MD5_SIZE_FAIL(16),
            PSN_MD5_FAIL(32),
            PSN_DECODE_FAIL(64),
            PSN_SALT_FAIL(128),
            PSN_BITSLICER_FAIL(256),
            PSN_REQUEST_TYPE_FAIL(512),
            PSN_INVALID_ERROR_CODE(1024),
            PSN_TIMESTAMP_EXPIRED(2048),
            PSN_ENCODE_SIZE_FAIL(4096),
            PSN_BLANK_VALUE(8192),
            PSN_INITIALIZATION_FAIL(16384),
            PSN_GASS_CLIENT_FAIL(32768),
            PSN_SIGNALS_TIMEOUT(65536),
            PSN_TINK_FAIL(131072);

            private static final zzdrx<zzd> zzen = new zzby();
            private final int value;

            zzd(int i) {
                this.value = i;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            @Override // com.google.android.gms.internal.ads.zzdry
            public final int zzae() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public static final class zze extends zzdrt<zze, C0013zza> implements zzdtg {
            private static volatile zzdtn<zze> zzdz;
            private static final zze zzkd;
            private int zzdl;
            private long zzjx;
            private long zzjy;
            private long zzfl = -1;
            private long zzfm = -1;
            private long zzjk = -1;
            private long zzjl = -1;
            private long zzjm = -1;
            private long zzjn = -1;
            private int zzjo = 1000;
            private long zzjp = -1;
            private long zzjq = -1;
            private long zzjr = -1;
            private int zzjs = 1000;
            private long zzjt = -1;
            private long zzju = -1;
            private long zzjv = -1;
            private long zzjw = -1;
            private long zzjz = -1;
            private long zzka = -1;
            private long zzkb = -1;
            private long zzkc = -1;

            /* renamed from: com.google.android.gms.internal.ads.zzbs$zza$zze$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0013zza extends zzdrt.zzb<zze, C0013zza> implements zzdtg {
                private C0013zza() {
                    super(zze.zzkd);
                }

                /* synthetic */ C0013zza(zzbt zzbtVar) {
                    this();
                }

                public final C0013zza zzav() {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzaq();
                    return this;
                }

                public final C0013zza zzcl(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzj(j);
                    return this;
                }

                public final C0013zza zzcm(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzk(j);
                    return this;
                }

                public final C0013zza zzcn(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbs(j);
                    return this;
                }

                public final C0013zza zzco(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbt(j);
                    return this;
                }

                public final C0013zza zzcp(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbu(j);
                    return this;
                }

                public final C0013zza zzcq(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbv(j);
                    return this;
                }

                public final C0013zza zzcr(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbw(j);
                    return this;
                }

                public final C0013zza zzcs(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbx(j);
                    return this;
                }

                public final C0013zza zzct(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzby(j);
                    return this;
                }

                public final C0013zza zzcu(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzbz(j);
                    return this;
                }

                public final C0013zza zzcv(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzca(j);
                    return this;
                }

                public final C0013zza zzcw(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzcb(j);
                    return this;
                }

                public final C0013zza zzcx(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzcc(j);
                    return this;
                }

                public final C0013zza zzcy(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzcd(j);
                    return this;
                }

                public final C0013zza zzcz(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzce(j);
                    return this;
                }

                public final C0013zza zzda(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzcf(j);
                    return this;
                }

                public final C0013zza zzdb(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzcg(j);
                    return this;
                }

                public final C0013zza zzk(zzcd zzcdVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzi(zzcdVar);
                    return this;
                }

                public final C0013zza zzl(zzcd zzcdVar) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zze) this.a).zzj(zzcdVar);
                    return this;
                }
            }

            static {
                zze zzeVar = new zze();
                zzkd = zzeVar;
                zzdrt.a((Class<zze>) zze.class, zzeVar);
            }

            private zze() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzaq() {
                this.zzdl &= -9;
                this.zzjl = -1L;
            }

            public static C0013zza zzar() {
                return zzkd.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbs(long j) {
                this.zzdl |= 4;
                this.zzjk = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbt(long j) {
                this.zzdl |= 8;
                this.zzjl = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbu(long j) {
                this.zzdl |= 16;
                this.zzjm = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbv(long j) {
                this.zzdl |= 32;
                this.zzjn = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbw(long j) {
                this.zzdl |= 128;
                this.zzjp = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbx(long j) {
                this.zzdl |= 256;
                this.zzjq = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzby(long j) {
                this.zzdl |= 512;
                this.zzjr = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzbz(long j) {
                this.zzdl |= 2048;
                this.zzjt = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzca(long j) {
                this.zzdl |= 4096;
                this.zzju = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcb(long j) {
                this.zzdl |= 8192;
                this.zzjv = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcc(long j) {
                this.zzdl |= 16384;
                this.zzjw = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcd(long j) {
                this.zzdl |= 32768;
                this.zzjx = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzce(long j) {
                this.zzdl |= 65536;
                this.zzjy = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcf(long j) {
                this.zzdl |= 131072;
                this.zzjz = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcg(long j) {
                this.zzdl |= 262144;
                this.zzka = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzi(zzcd zzcdVar) {
                this.zzjo = zzcdVar.zzae();
                this.zzdl |= 64;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzj(long j) {
                this.zzdl |= 1;
                this.zzfl = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzj(zzcd zzcdVar) {
                this.zzjs = zzcdVar.zzae();
                this.zzdl |= 1024;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzk(long j) {
                this.zzdl |= 2;
                this.zzfm = j;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzbt zzbtVar = null;
                switch (zzbt.a[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C0013zza(zzbtVar);
                    case 3:
                        return zzdrt.a(zzkd, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\f\u0006\b\u0002\u0007\t\u0002\b\n\u0002\t\u000b\f\n\f\u0002\u000b\r\u0002\f\u000e\u0002\r\u000f\u0002\u000e\u0010\u0002\u000f\u0011\u0002\u0010\u0012\u0002\u0011\u0013\u0002\u0012\u0014\u0002\u0013\u0015\u0002\u0014", new Object[]{"zzdl", "zzfl", "zzfm", "zzjk", "zzjl", "zzjm", "zzjn", "zzjo", zzcd.zzaf(), "zzjp", "zzjq", "zzjr", "zzjs", zzcd.zzaf(), "zzjt", "zzju", "zzjv", "zzjw", "zzjx", "zzjy", "zzjz", "zzka", "zzkb", "zzkc"});
                    case 4:
                        return zzkd;
                    case 5:
                        zzdtn<zze> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zze.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzkd);
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
        public static final class zzf extends zzdrt<zzf, C0014zza> implements zzdtg {
            private static volatile zzdtn<zzf> zzdz;
            private static final zzf zzki;
            private int zzdl;
            private long zzgp = -1;
            private long zzgq = -1;
            private long zzke = -1;
            private long zzkf = -1;
            private long zzkg = -1;
            private long zzkh = -1;

            /* renamed from: com.google.android.gms.internal.ads.zzbs$zza$zzf$zza, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0014zza extends zzdrt.zzb<zzf, C0014zza> implements zzdtg {
                private C0014zza() {
                    super(zzf.zzki);
                }

                /* synthetic */ C0014zza(zzbt zzbtVar) {
                    this();
                }

                public final C0014zza zzdc(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzf) this.a).zzch(j);
                    return this;
                }

                public final C0014zza zzdd(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzf) this.a).zzci(j);
                    return this;
                }

                public final C0014zza zzde(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzf) this.a).zzcj(j);
                    return this;
                }

                public final C0014zza zzdf(long j) {
                    if (this.b) {
                        a();
                        this.b = false;
                    }
                    ((zzf) this.a).zzck(j);
                    return this;
                }
            }

            static {
                zzf zzfVar = new zzf();
                zzki = zzfVar;
                zzdrt.a((Class<zzf>) zzf.class, zzfVar);
            }

            private zzf() {
            }

            public static C0014zza zzat() {
                return zzki.b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzch(long j) {
                this.zzdl |= 4;
                this.zzke = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzci(long j) {
                this.zzdl |= 8;
                this.zzkf = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzcj(long j) {
                this.zzdl |= 16;
                this.zzkg = j;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void zzck(long j) {
                this.zzdl |= 32;
                this.zzkh = j;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.ads.zzdrt
            public final Object a(int i, Object obj, Object obj2) {
                zzbt zzbtVar = null;
                switch (zzbt.a[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C0014zza(zzbtVar);
                    case 3:
                        return zzdrt.a(zzki, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005", new Object[]{"zzdl", "zzgp", "zzgq", "zzke", "zzkf", "zzkg", "zzkh"});
                    case 4:
                        return zzki;
                    case 5:
                        zzdtn<zzf> zzdtnVar = zzdz;
                        if (zzdtnVar == null) {
                            synchronized (zzf.class) {
                                zzdtnVar = zzdz;
                                if (zzdtnVar == null) {
                                    zzdtnVar = new zzdrt.zza<>(zzki);
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
            zzht = zzaVar;
            zzdrt.a((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza zza(byte[] bArr, zzdrg zzdrgVar) {
            return (zza) zzdrt.a(zzht, bArr, zzdrgVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zzho = zzcVar.zzae();
            this.zzey |= 128;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zze zzeVar) {
            zzeVar.getClass();
            this.zzgs = zzeVar;
            this.zzex |= 262144;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            this.zzgu = zzfVar;
            this.zzex |= 524288;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzcd zzcdVar) {
            this.zzgk = zzcdVar.zzae();
            this.zzex |= 1024;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzey |= 256;
            this.zzhp = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaa(long j) {
            this.zzex |= 32;
            this.zzgh = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaa(String str) {
            str.getClass();
            this.zzdl |= 268435456;
            this.zzer = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzab(long j) {
            this.zzex |= 64;
            this.zzgi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzab(String str) {
            str.getClass();
            this.zzex |= 128;
            this.zzes = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzac(long j) {
            this.zzex |= 4096;
            this.zzgm = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzac(String str) {
            str.getClass();
            this.zzex |= 256;
            this.zzet = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzad(long j) {
            this.zzex |= 8192;
            this.zzgn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzad(String str) {
            str.getClass();
            this.zzex |= 268435456;
            this.zzhd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzae(long j) {
            this.zzex |= 16384;
            this.zzgo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzae(String str) {
            str.getClass();
            this.zzey |= 64;
            this.zzhn = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaf(long j) {
            this.zzex |= 2097152;
            this.zzgw = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzag(long j) {
            this.zzex |= 4194304;
            this.zzgx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzah(long j) {
            this.zzex |= 8388608;
            this.zzgy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzai(long j) {
            this.zzex |= 67108864;
            this.zzhb = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzaj(long j) {
            this.zzex |= 134217728;
            this.zzhc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzak() {
            this.zzgt = zzdrt.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzak(long j) {
            this.zzey |= 1024;
            this.zzhr = j;
        }

        public static zzb zzan() {
            return zzht.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zze zzeVar) {
            zzeVar.getClass();
            if (!this.zzgt.zzaxp()) {
                this.zzgt = zzdrt.a(this.zzgt);
            }
            this.zzgt.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzcd zzcdVar) {
            this.zzgl = zzcdVar.zzae();
            this.zzex |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzcd zzcdVar) {
            this.zzgr = zzcdVar.zzae();
            this.zzex |= 131072;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zzcd zzcdVar) {
            this.zzhk = zzcdVar.zzae();
            this.zzey |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(long j) {
            this.zzdl |= 4;
            this.zzfa = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzdl |= 16;
            this.zzfc = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzdl |= 32;
            this.zzfd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzdl |= 1024;
            this.zzfi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzdl |= 2048;
            this.zzfj = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzdl |= 8192;
            this.zzfl = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzdl |= 16384;
            this.zzfm = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzdl |= 32768;
            this.zzfn = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzm(long j) {
            this.zzdl |= 65536;
            this.zzfo = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzn(long j) {
            this.zzdl |= 524288;
            this.zzfr = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzo(long j) {
            this.zzdl |= 1048576;
            this.zzfs = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzp(long j) {
            this.zzdl |= 2097152;
            this.zzft = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzq(long j) {
            this.zzdl |= 33554432;
            this.zzfw = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzr(long j) {
            this.zzdl |= 67108864;
            this.zzfx = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzs(long j) {
            this.zzdl |= 134217728;
            this.zzfy = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzt(long j) {
            this.zzdl |= 536870912;
            this.zzfz = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzu(long j) {
            this.zzdl |= Ints.MAX_POWER_OF_TWO;
            this.zzga = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzv(long j) {
            this.zzdl |= Integer.MIN_VALUE;
            this.zzgb = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzw(long j) {
            this.zzex |= 2;
            this.zzgd = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzw(String str) {
            str.getClass();
            this.zzdl |= 1;
            this.zzez = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzx(long j) {
            this.zzex |= 4;
            this.zzge = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzx(String str) {
            str.getClass();
            this.zzdl |= 2;
            this.zzdv = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzy(long j) {
            this.zzex |= 8;
            this.zzgf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzy(String str) {
            str.getClass();
            this.zzdl |= 4194304;
            this.zzep = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzz(long j) {
            this.zzex |= 16;
            this.zzgg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzz(String str) {
            str.getClass();
            this.zzdl |= 16777216;
            this.zzfv = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbt zzbtVar = null;
            switch (zzbt.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb(zzbtVar);
                case 3:
                    return zzdrt.a(zzht, "\u0001M\u0000\u0003\u0001ÉM\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0002\u0003\u0005\u0002\u0004\u0006\u0002\u0005\u0007\u0002\u0006\b\u0002\u0007\t\u0002\b\n\u0002\t\u000b\u0002\n\f\u0002\u000b\r\b\f\u000e\u0002\r\u000f\u0002\u000e\u0010\u0002\u000f\u0011\u0002\u0010\u0012\u0002\u0011\u0013\u0002\u0012\u0014\u0002\u0013\u0015\u0002E\u0016\u0002\u0014\u0017\u0002\u0015\u0018\bF\u0019\u0002J\u001a\fG\u001b\b\u0016\u001c\u0007H\u001d\b\u0018\u001e\bI\u001f\u0002\u0019 \u0002\u001a!\u0002\u001b\"\b\u001c#\u0002\u001d$\u0002\u001e%\u0002\u001f&\t '\u0002!(\u0002\")\u0002#*\u0002$+\u001b,\u0002%-\u0002&.\b'/\b(0\f*1\f+2\t23\u0002,4\u0002-5\u0002.6\u0002/7\u000208\f19\t3:\u00024;\u00025<\u00026=\u00027>\u0002:?\u0002;@\u0002=A\f>B\f?C\b<D\f@E\tAF\u0002BG\u00028H\u00029I\fCJ\u0002)K\b\u0017L\fDÉ\tK", new Object[]{"zzdl", "zzex", "zzey", "zzez", "zzdv", "zzfa", "zzfb", "zzfc", "zzfd", "zzfe", "zzff", "zzfg", "zzfh", "zzfi", "zzfj", "zzfk", "zzfl", "zzfm", "zzfn", "zzfo", "zzfp", "zzfq", "zzfr", "zzhm", "zzfs", "zzft", "zzhn", "zzhr", "zzho", zzc.zzaf(), "zzep", "zzhp", "zzfv", "zzhq", "zzfw", "zzfx", "zzfy", "zzer", "zzfz", "zzga", "zzgb", "zzgc", "zzgd", "zzge", "zzgf", "zzgg", "zzgt", zze.class, "zzgh", "zzgi", "zzes", "zzet", "zzgk", zzcd.zzaf(), "zzgl", zzcd.zzaf(), "zzgs", "zzgm", "zzgn", "zzgo", "zzgp", "zzgq", "zzgr", zzcd.zzaf(), "zzgu", "zzgv", "zzgw", "zzgx", "zzgy", "zzhb", "zzhc", "zzhe", "zzhf", zzbz.zzaf(), "zzhg", zzce.zzaf(), "zzhd", "zzhh", EnumC0012zza.zzaf(), "zzhi", "zzhj", "zzgz", "zzha", "zzhk", zzcd.zzaf(), "zzgj", "zzfu", "zzhl", zzcd.zzaf(), "zzhs"});
                case 4:
                    return zzht;
                case 5:
                    zzdtn<zza> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zza.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzht);
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

        public final boolean zzaj() {
            return (this.zzdl & 4194304) != 0;
        }

        public final boolean zzal() {
            return (this.zzey & 2048) != 0;
        }

        public final zzd zzam() {
            zzd zzdVar = this.zzhs;
            return zzdVar == null ? zzd.zzbf() : zzdVar;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzb extends zzdrt<zzb, zza> implements zzdtg {
        private static volatile zzdtn<zzb> zzdz;
        private static final zzb zzko;
        private int zzdl;
        private long zzkj;
        private int zzkk;
        private boolean zzkl;
        private zzdrz zzkm = zzdrt.c();
        private long zzkn;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzb, zza> implements zzdtg {
            private zza() {
                super(zzb.zzko);
            }

            /* synthetic */ zza(zzbt zzbtVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzko = zzbVar;
            zzdrt.a((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbt zzbtVar = null;
            switch (zzbt.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzbtVar);
                case 3:
                    return zzdrt.a(zzko, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u0002\u0000\u0002\u0004\u0001\u0003\u0007\u0002\u0004\u0016\u0005\u0003\u0003", new Object[]{"zzdl", "zzkj", "zzkk", "zzkl", "zzkm", "zzkn"});
                case 4:
                    return zzko;
                case 5:
                    zzdtn<zzb> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzb.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzko);
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
        private static final zzc zzkt;
        private int zzdl;
        private zzdqk zzkp;
        private zzdqk zzkq;
        private zzdqk zzkr;
        private zzdqk zzks;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzc, zza> implements zzdtg {
            private zza() {
                super(zzc.zzkt);
            }

            /* synthetic */ zza(zzbt zzbtVar) {
                this();
            }

            public final zza zze(zzdqk zzdqkVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzc) this.a).zza(zzdqkVar);
                return this;
            }

            public final zza zzf(zzdqk zzdqkVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzc) this.a).zzb(zzdqkVar);
                return this;
            }

            public final zza zzg(zzdqk zzdqkVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzc) this.a).zzc(zzdqkVar);
                return this;
            }

            public final zza zzh(zzdqk zzdqkVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzc) this.a).zzd(zzdqkVar);
                return this;
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzkt = zzcVar;
            zzdrt.a((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
            zzdqk zzdqkVar = zzdqk.zzhhx;
            this.zzkp = zzdqkVar;
            this.zzkq = zzdqkVar;
            this.zzkr = zzdqkVar;
            this.zzks = zzdqkVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzdqk zzdqkVar) {
            zzdqkVar.getClass();
            this.zzdl |= 1;
            this.zzkp = zzdqkVar;
        }

        public static zzc zzb(byte[] bArr, zzdrg zzdrgVar) {
            return (zzc) zzdrt.a(zzkt, bArr, zzdrgVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzdqk zzdqkVar) {
            zzdqkVar.getClass();
            this.zzdl |= 2;
            this.zzkq = zzdqkVar;
        }

        public static zza zzbb() {
            return zzkt.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(zzdqk zzdqkVar) {
            zzdqkVar.getClass();
            this.zzdl |= 4;
            this.zzkr = zzdqkVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(zzdqk zzdqkVar) {
            zzdqkVar.getClass();
            this.zzdl |= 8;
            this.zzks = zzdqkVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbt zzbtVar = null;
            switch (zzbt.a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzbtVar);
                case 3:
                    return zzdrt.a(zzkt, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002\u0004\n\u0003", new Object[]{"zzdl", "zzkp", "zzkq", "zzkr", "zzks"});
                case 4:
                    return zzkt;
                case 5:
                    zzdtn<zzc> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzc.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzkt);
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

        public final zzdqk zzax() {
            return this.zzkp;
        }

        public final zzdqk zzay() {
            return this.zzkq;
        }

        public final zzdqk zzaz() {
            return this.zzkr;
        }

        public final zzdqk zzba() {
            return this.zzks;
        }
    }

    /* loaded from: classes.dex */
    public static final class zzd extends zzdrt<zzd, zza> implements zzdtg {
        private static volatile zzdtn<zzd> zzdz;
        private static final zzd zzll;
        private int zzdl;
        private long zzkj;
        private String zzlj = "";
        private zzdqk zzlk = zzdqk.zzhhx;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzd, zza> implements zzdtg {
            private zza() {
                super(zzd.zzll);
            }

            /* synthetic */ zza(zzbt zzbtVar) {
                this();
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzll = zzdVar;
            zzdrt.a((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        public static zzd zzbf() {
            return zzll;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbt zzbtVar = null;
            switch (zzbt.a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(zzbtVar);
                case 3:
                    return zzdrt.a(zzll, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001\u0002\u0000\u0003\b\u0001\u0004\n\u0002", new Object[]{"zzdl", "zzkj", "zzlj", "zzlk"});
                case 4:
                    return zzll;
                case 5:
                    zzdtn<zzd> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzd.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzll);
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

        public final boolean zzbd() {
            return (this.zzdl & 1) != 0;
        }

        public final long zzbe() {
            return this.zzkj;
        }
    }

    /* loaded from: classes.dex */
    public static final class zze extends zzdrt<zze, zza> implements zzdtg {
        private static volatile zzdtn<zze> zzdz;
        private static final zze zzlm;
        private int zzdl;
        private String zzeu = "";

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zze, zza> implements zzdtg {
            private zza() {
                super(zze.zzlm);
            }

            /* synthetic */ zza(zzbt zzbtVar) {
                this();
            }
        }

        static {
            zze zzeVar = new zze();
            zzlm = zzeVar;
            zzdrt.a((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbt zzbtVar = null;
            switch (zzbt.a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(zzbtVar);
                case 3:
                    return zzdrt.a(zzlm, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzdl", "zzeu"});
                case 4:
                    return zzlm;
                case 5:
                    zzdtn<zze> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zze.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzlm);
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
        private static volatile zzdtn<zzf> zzdz;
        private static final zzf zzlo;
        private int zzdl;
        private zzdsb<zzdqk> zzln = zzdrt.d();
        private zzdqk zzkq = zzdqk.zzhhx;
        private int zzhg = 1;
        private int zzhf = 1;

        /* loaded from: classes.dex */
        public static final class zza extends zzdrt.zzb<zzf, zza> implements zzdtg {
            private zza() {
                super(zzf.zzlo);
            }

            /* synthetic */ zza(zzbt zzbtVar) {
                this();
            }

            public final zza zza(zzbz zzbzVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzf) this.a).zzb(zzbzVar);
                return this;
            }

            public final zza zzi(zzdqk zzdqkVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzf) this.a).zzk(zzdqkVar);
                return this;
            }

            public final zza zzj(zzdqk zzdqkVar) {
                if (this.b) {
                    a();
                    this.b = false;
                }
                ((zzf) this.a).zzb(zzdqkVar);
                return this;
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzlo = zzfVar;
            zzdrt.a((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzbz zzbzVar) {
            this.zzhf = zzbzVar.zzae();
            this.zzdl |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(zzdqk zzdqkVar) {
            zzdqkVar.getClass();
            this.zzdl |= 1;
            this.zzkq = zzdqkVar;
        }

        public static zza zzbi() {
            return zzlo.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzk(zzdqk zzdqkVar) {
            zzdqkVar.getClass();
            if (!this.zzln.zzaxp()) {
                this.zzln = zzdrt.a(this.zzln);
            }
            this.zzln.add(zzdqkVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdrt
        public final Object a(int i, Object obj, Object obj2) {
            zzbt zzbtVar = null;
            switch (zzbt.a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(zzbtVar);
                case 3:
                    return zzdrt.a(zzlo, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002\n\u0000\u0003\f\u0001\u0004\f\u0002", new Object[]{"zzdl", "zzln", "zzkq", "zzhg", zzce.zzaf(), "zzhf", zzbz.zzaf()});
                case 4:
                    return zzlo;
                case 5:
                    zzdtn<zzf> zzdtnVar = zzdz;
                    if (zzdtnVar == null) {
                        synchronized (zzf.class) {
                            zzdtnVar = zzdz;
                            if (zzdtnVar == null) {
                                zzdtnVar = new zzdrt.zza<>(zzlo);
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

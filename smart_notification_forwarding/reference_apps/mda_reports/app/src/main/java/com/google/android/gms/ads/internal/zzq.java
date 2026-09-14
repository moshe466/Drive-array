package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzaic;
import com.google.android.gms.internal.ads.zzajt;
import com.google.android.gms.internal.ads.zzala;
import com.google.android.gms.internal.ads.zzaoq;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapt;
import com.google.android.gms.internal.ads.zzaqv;
import com.google.android.gms.internal.ads.zzatv;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzawb;
import com.google.android.gms.internal.ads.zzawh;
import com.google.android.gms.internal.ads.zzawq;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzbck;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzqe;
import com.google.android.gms.internal.ads.zzrq;
import com.google.android.gms.internal.ads.zzrr;
import com.google.android.gms.internal.ads.zzsn;
import com.google.android.gms.internal.ads.zzzw;

/* loaded from: classes.dex */
public final class zzq {
    private static zzq zzbmd = new zzq();
    private final com.google.android.gms.ads.internal.overlay.zzb zzbme;
    private final zzapt zzbmf;
    private final com.google.android.gms.ads.internal.overlay.zzn zzbmg;
    private final zzapk zzbmh;
    private final zzawb zzbmi;
    private final zzbdr zzbmj;
    private final zzawh zzbmk;
    private final zzqe zzbml;
    private final zzave zzbmm;
    private final zzawq zzbmn;
    private final zzrr zzbmo;
    private final zzrq zzbmp;
    private final Clock zzbmq;
    private final zzd zzbmr;
    private final zzzw zzbms;
    private final zzawy zzbmt;
    private final zzaqv zzbmu;
    private final zzaic zzbmv;
    private final zzazk zzbmw;
    private final zzahp zzbmx;
    private final zzajt zzbmy;
    private final zzaxw zzbmz;
    private final zzw zzbna;
    private final zzv zzbnb;
    private final zzala zzbnc;
    private final zzaxz zzbnd;
    private final zzaoq zzbne;
    private final zzsn zzbnf;
    private final zzatv zzbng;
    private final zzayg zzbnh;
    private final zzbck zzbni;
    private final zzazt zzbnj;

    protected zzq() {
        this(new com.google.android.gms.ads.internal.overlay.zzb(), new zzapt(), new com.google.android.gms.ads.internal.overlay.zzn(), new zzapk(), new zzawb(), new zzbdr(), zzawh.zzcr(Build.VERSION.SDK_INT), new zzqe(), new zzave(), new zzawq(), new zzrr(), new zzrq(), DefaultClock.getInstance(), new zzd(), new zzzw(), new zzawy(), new zzaqv(), new zzaic(), new zzazk(), new zzajt(), new zzaxw(), new zzw(), new zzv(), new zzala(), new zzaxz(), new zzaoq(), new zzsn(), new zzatv(), new zzayg(), new zzbck(), new zzazt());
    }

    private zzq(com.google.android.gms.ads.internal.overlay.zzb zzbVar, zzapt zzaptVar, com.google.android.gms.ads.internal.overlay.zzn zznVar, zzapk zzapkVar, zzawb zzawbVar, zzbdr zzbdrVar, zzawh zzawhVar, zzqe zzqeVar, zzave zzaveVar, zzawq zzawqVar, zzrr zzrrVar, zzrq zzrqVar, Clock clock, zzd zzdVar, zzzw zzzwVar, zzawy zzawyVar, zzaqv zzaqvVar, zzaic zzaicVar, zzazk zzazkVar, zzajt zzajtVar, zzaxw zzaxwVar, zzw zzwVar, zzv zzvVar, zzala zzalaVar, zzaxz zzaxzVar, zzaoq zzaoqVar, zzsn zzsnVar, zzatv zzatvVar, zzayg zzaygVar, zzbck zzbckVar, zzazt zzaztVar) {
        this.zzbme = zzbVar;
        this.zzbmf = zzaptVar;
        this.zzbmg = zznVar;
        this.zzbmh = zzapkVar;
        this.zzbmi = zzawbVar;
        this.zzbmj = zzbdrVar;
        this.zzbmk = zzawhVar;
        this.zzbml = zzqeVar;
        this.zzbmm = zzaveVar;
        this.zzbmn = zzawqVar;
        this.zzbmo = zzrrVar;
        this.zzbmp = zzrqVar;
        this.zzbmq = clock;
        this.zzbmr = zzdVar;
        this.zzbms = zzzwVar;
        this.zzbmt = zzawyVar;
        this.zzbmu = zzaqvVar;
        this.zzbmv = zzaicVar;
        this.zzbmw = zzazkVar;
        this.zzbmx = new zzahp();
        this.zzbmy = zzajtVar;
        this.zzbmz = zzaxwVar;
        this.zzbna = zzwVar;
        this.zzbnb = zzvVar;
        this.zzbnc = zzalaVar;
        this.zzbnd = zzaxzVar;
        this.zzbne = zzaoqVar;
        this.zzbnf = zzsnVar;
        this.zzbng = zzatvVar;
        this.zzbnh = zzaygVar;
        this.zzbni = zzbckVar;
        this.zzbnj = zzaztVar;
    }

    public static com.google.android.gms.ads.internal.overlay.zzb zzko() {
        return zzbmd.zzbme;
    }

    public static com.google.android.gms.ads.internal.overlay.zzn zzkp() {
        return zzbmd.zzbmg;
    }

    public static zzawb zzkq() {
        return zzbmd.zzbmi;
    }

    public static zzbdr zzkr() {
        return zzbmd.zzbmj;
    }

    public static zzawh zzks() {
        return zzbmd.zzbmk;
    }

    public static zzqe zzkt() {
        return zzbmd.zzbml;
    }

    public static zzave zzku() {
        return zzbmd.zzbmm;
    }

    public static zzawq zzkv() {
        return zzbmd.zzbmn;
    }

    public static zzrq zzkw() {
        return zzbmd.zzbmp;
    }

    public static Clock zzkx() {
        return zzbmd.zzbmq;
    }

    public static zzd zzky() {
        return zzbmd.zzbmr;
    }

    public static zzzw zzkz() {
        return zzbmd.zzbms;
    }

    public static zzawy zzla() {
        return zzbmd.zzbmt;
    }

    public static zzaqv zzlb() {
        return zzbmd.zzbmu;
    }

    public static zzazk zzlc() {
        return zzbmd.zzbmw;
    }

    public static zzajt zzld() {
        return zzbmd.zzbmy;
    }

    public static zzaxw zzle() {
        return zzbmd.zzbmz;
    }

    public static zzaoq zzlf() {
        return zzbmd.zzbne;
    }

    public static zzw zzlg() {
        return zzbmd.zzbna;
    }

    public static zzv zzlh() {
        return zzbmd.zzbnb;
    }

    public static zzala zzli() {
        return zzbmd.zzbnc;
    }

    public static zzaxz zzlj() {
        return zzbmd.zzbnd;
    }

    public static zzsn zzlk() {
        return zzbmd.zzbnf;
    }

    public static zzayg zzll() {
        return zzbmd.zzbnh;
    }

    public static zzbck zzlm() {
        return zzbmd.zzbni;
    }

    public static zzazt zzln() {
        return zzbmd.zzbnj;
    }

    public static zzatv zzlo() {
        return zzbmd.zzbng;
    }
}

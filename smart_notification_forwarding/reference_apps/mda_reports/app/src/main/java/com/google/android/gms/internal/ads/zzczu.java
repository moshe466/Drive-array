package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzczu {
    public final zzuj zzblm;
    public final zzaby zzddz;

    @Nullable
    public final zzagz zzdkf;
    public final int zzgdu;

    @Nullable
    public final zzwi zzgmj;

    @Nullable
    public final zzyw zzgmk;
    public final zzug zzgml;
    public final String zzgmm;
    public final ArrayList<String> zzgmn;
    public final ArrayList<String> zzgmo;
    public final zzuo zzgmp;
    public final PublisherAdViewOptions zzgmq;
    public final zzwc zzgmr;
    public final Set<String> zzgms;

    private zzczu(zzczw zzczwVar) {
        this.zzblm = zzczw.a(zzczwVar);
        this.zzgmm = zzczw.b(zzczwVar);
        this.zzgmj = zzczw.c(zzczwVar);
        this.zzgml = new zzug(zzczw.k(zzczwVar).versionCode, zzczw.k(zzczwVar).zzcby, zzczw.k(zzczwVar).extras, zzczw.k(zzczwVar).zzcbz, zzczw.k(zzczwVar).zzcca, zzczw.k(zzczwVar).zzccb, zzczw.k(zzczwVar).zzabo, zzczw.k(zzczwVar).zzbkh || zzczw.l(zzczwVar), zzczw.k(zzczwVar).zzccc, zzczw.k(zzczwVar).zzccd, zzczw.k(zzczwVar).zzmi, zzczw.k(zzczwVar).zzcce, zzczw.k(zzczwVar).zzccf, zzczw.k(zzczwVar).zzccg, zzczw.k(zzczwVar).zzcch, zzczw.k(zzczwVar).zzcci, zzczw.k(zzczwVar).zzccj, zzczw.k(zzczwVar).zzcck, zzczw.k(zzczwVar).zzccm, zzczw.k(zzczwVar).zzabp, zzczw.k(zzczwVar).zzabq, zzczw.k(zzczwVar).zzccl);
        this.zzgmk = zzczw.m(zzczwVar) != null ? zzczw.m(zzczwVar) : zzczw.n(zzczwVar) != null ? zzczw.n(zzczwVar).zzcvp : null;
        this.zzgmn = zzczw.d(zzczwVar);
        this.zzgmo = zzczw.e(zzczwVar);
        this.zzddz = zzczw.d(zzczwVar) != null ? zzczw.n(zzczwVar) == null ? new zzaby(new NativeAdOptions.Builder().build()) : zzczw.n(zzczwVar) : null;
        this.zzgmp = zzczw.f(zzczwVar);
        this.zzgdu = zzczw.g(zzczwVar);
        this.zzgmq = zzczw.h(zzczwVar);
        this.zzgmr = zzczw.i(zzczwVar);
        this.zzdkf = zzczw.j(zzczwVar);
        this.zzgms = zzczwVar.zzgms;
    }

    public final zzaea zzaoo() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzgmq;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzjn();
    }
}

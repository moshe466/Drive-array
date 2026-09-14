package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzczw {
    private boolean zzbkh;
    private zzuj zzblm;
    private zzaby zzddz;
    private zzagz zzdkf;
    private zzwi zzgmj;
    private zzyw zzgmk;
    private zzug zzgml;
    private String zzgmm;
    private ArrayList<String> zzgmn;
    private ArrayList<String> zzgmo;
    private zzuo zzgmp;
    private PublisherAdViewOptions zzgmq;

    @Nullable
    private zzwc zzgmr;
    private int zzgdu = 1;
    public final Set<String> zzgms = new HashSet();

    public static /* synthetic */ zzuj a(zzczw zzczwVar) {
        return zzczwVar.zzblm;
    }

    public static /* synthetic */ String b(zzczw zzczwVar) {
        return zzczwVar.zzgmm;
    }

    public static /* synthetic */ zzwi c(zzczw zzczwVar) {
        return zzczwVar.zzgmj;
    }

    public static /* synthetic */ ArrayList d(zzczw zzczwVar) {
        return zzczwVar.zzgmn;
    }

    public static /* synthetic */ ArrayList e(zzczw zzczwVar) {
        return zzczwVar.zzgmo;
    }

    public static /* synthetic */ zzuo f(zzczw zzczwVar) {
        return zzczwVar.zzgmp;
    }

    public static /* synthetic */ int g(zzczw zzczwVar) {
        return zzczwVar.zzgdu;
    }

    public static /* synthetic */ PublisherAdViewOptions h(zzczw zzczwVar) {
        return zzczwVar.zzgmq;
    }

    public static /* synthetic */ zzwc i(zzczw zzczwVar) {
        return zzczwVar.zzgmr;
    }

    public static /* synthetic */ zzagz j(zzczw zzczwVar) {
        return zzczwVar.zzdkf;
    }

    public static /* synthetic */ zzug k(zzczw zzczwVar) {
        return zzczwVar.zzgml;
    }

    public static /* synthetic */ boolean l(zzczw zzczwVar) {
        return zzczwVar.zzbkh;
    }

    public static /* synthetic */ zzyw m(zzczw zzczwVar) {
        return zzczwVar.zzgmk;
    }

    public static /* synthetic */ zzaby n(zzczw zzczwVar) {
        return zzczwVar.zzddz;
    }

    public final zzug zzaoq() {
        return this.zzgml;
    }

    public final String zzaor() {
        return this.zzgmm;
    }

    public final zzczu zzaos() {
        Preconditions.checkNotNull(this.zzgmm, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzblm, "ad size must not be null");
        Preconditions.checkNotNull(this.zzgml, "ad request must not be null");
        return new zzczu(this);
    }

    public final zzczw zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgmq = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbkh = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzgmr = publisherAdViewOptions.zzjm();
        }
        return this;
    }

    public final zzczw zzb(zzaby zzabyVar) {
        this.zzddz = zzabyVar;
        return this;
    }

    public final zzczw zzb(zzagz zzagzVar) {
        this.zzdkf = zzagzVar;
        this.zzgmk = new zzyw(false, true, false);
        return this;
    }

    public final zzczw zzb(zzuo zzuoVar) {
        this.zzgmp = zzuoVar;
        return this;
    }

    public final zzczw zzb(ArrayList<String> arrayList) {
        this.zzgmn = arrayList;
        return this;
    }

    public final zzczw zzbm(boolean z) {
        this.zzbkh = z;
        return this;
    }

    public final zzczw zzc(zzwi zzwiVar) {
        this.zzgmj = zzwiVar;
        return this;
    }

    public final zzczw zzc(zzyw zzywVar) {
        this.zzgmk = zzywVar;
        return this;
    }

    public final zzczw zzc(ArrayList<String> arrayList) {
        this.zzgmo = arrayList;
        return this;
    }

    public final zzczw zzd(zzuj zzujVar) {
        this.zzblm = zzujVar;
        return this;
    }

    public final zzczw zzdl(int i) {
        this.zzgdu = i;
        return this;
    }

    public final zzczw zzg(zzug zzugVar) {
        this.zzgml = zzugVar;
        return this;
    }

    public final zzczw zzgk(String str) {
        this.zzgmm = str;
        return this;
    }

    public final zzuj zzjz() {
        return this.zzblm;
    }
}

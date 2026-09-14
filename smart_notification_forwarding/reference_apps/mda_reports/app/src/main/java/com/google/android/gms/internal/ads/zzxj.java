package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdData;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzxj {
    private final int zzabo;
    private final int zzabp;
    private final String zzabq;
    private final boolean zzbkh;
    private final int zzcbz;
    private final String zzccc;
    private final String zzcce;
    private final Bundle zzccg;
    private final String zzcci;
    private final boolean zzcck;
    private final List<String> zzccl;
    private final Bundle zzcee;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcef;
    private final SearchAdRequest zzceg;
    private final Set<String> zzceh;
    private final Set<String> zzcei;
    private final AdData zzcej;
    private final Date zzme;
    private final Set<String> zzmg;
    private final Location zzmi;

    public zzxj(zzxm zzxmVar) {
        this(zzxmVar, null);
    }

    public zzxj(zzxm zzxmVar, SearchAdRequest searchAdRequest) {
        Date date;
        String str;
        List<String> list;
        int i;
        HashSet hashSet;
        Location location;
        boolean z;
        Bundle bundle;
        HashMap hashMap;
        String str2;
        String str3;
        int i2;
        HashSet hashSet2;
        Bundle bundle2;
        HashSet hashSet3;
        boolean z2;
        AdData adData;
        int i3;
        String str4;
        date = zzxmVar.zzme;
        this.zzme = date;
        str = zzxmVar.zzcce;
        this.zzcce = str;
        list = zzxmVar.zzccl;
        this.zzccl = list;
        i = zzxmVar.zzcbz;
        this.zzcbz = i;
        hashSet = zzxmVar.zzceq;
        this.zzmg = Collections.unmodifiableSet(hashSet);
        location = zzxmVar.zzmi;
        this.zzmi = location;
        z = zzxmVar.zzbkh;
        this.zzbkh = z;
        bundle = zzxmVar.zzcee;
        this.zzcee = bundle;
        hashMap = zzxmVar.zzcer;
        this.zzcef = Collections.unmodifiableMap(hashMap);
        str2 = zzxmVar.zzccc;
        this.zzccc = str2;
        str3 = zzxmVar.zzcci;
        this.zzcci = str3;
        this.zzceg = searchAdRequest;
        i2 = zzxmVar.zzabo;
        this.zzabo = i2;
        hashSet2 = zzxmVar.zzces;
        this.zzceh = Collections.unmodifiableSet(hashSet2);
        bundle2 = zzxmVar.zzccg;
        this.zzccg = bundle2;
        hashSet3 = zzxmVar.zzcet;
        this.zzcei = Collections.unmodifiableSet(hashSet3);
        z2 = zzxmVar.zzcck;
        this.zzcck = z2;
        adData = zzxmVar.zzcej;
        this.zzcej = adData;
        i3 = zzxmVar.zzabp;
        this.zzabp = i3;
        str4 = zzxmVar.zzabq;
        this.zzabq = str4;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzme;
    }

    public final String getContentUrl() {
        return this.zzcce;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzcee.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzccg;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcbz;
    }

    public final Set<String> getKeywords() {
        return this.zzmg;
    }

    public final Location getLocation() {
        return this.zzmi;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbkh;
    }

    @Nullable
    public final String getMaxAdContentRating() {
        return this.zzabq;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (T) this.zzcef.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzcee.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzccc;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcck;
    }

    public final boolean isTestDevice(Context context) {
        Set<String> set = this.zzceh;
        zzve.zzou();
        return set.contains(zzayk.zzbi(context));
    }

    public final List<String> zzpn() {
        return new ArrayList(this.zzccl);
    }

    public final String zzpo() {
        return this.zzcci;
    }

    public final SearchAdRequest zzpp() {
        return this.zzceg;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzpq() {
        return this.zzcef;
    }

    public final Bundle zzpr() {
        return this.zzcee;
    }

    public final int zzps() {
        return this.zzabo;
    }

    public final Set<String> zzpt() {
        return this.zzcei;
    }

    @Nullable
    public final AdData zzpu() {
        return this.zzcej;
    }

    public final int zzpv() {
        return this.zzabp;
    }
}

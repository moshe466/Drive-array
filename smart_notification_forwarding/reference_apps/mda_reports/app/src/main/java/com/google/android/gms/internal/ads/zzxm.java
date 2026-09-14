package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class zzxm {
    private String zzabq;
    private String zzccc;
    private String zzcce;
    private String zzcci;
    private boolean zzcck;
    private AdData zzcej;
    private Date zzme;
    private Location zzmi;
    private final HashSet<String> zzceq = new HashSet<>();
    private final Bundle zzcee = new Bundle();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcer = new HashMap<>();
    private final HashSet<String> zzces = new HashSet<>();
    private final Bundle zzccg = new Bundle();
    private final HashSet<String> zzcet = new HashSet<>();
    private final List<String> zzccl = new ArrayList();
    private int zzcbz = -1;
    private boolean zzbkh = false;
    private int zzabo = -1;
    private int zzabp = -1;

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbkh = z;
    }

    public final void zza(Location location) {
        this.zzmi = location;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzcer.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(AdData adData) {
        this.zzcej = adData;
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcee.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzme = date;
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzcck = z;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzcee.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzcee.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzcee.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzcf(String str) {
        this.zzceq.add(str);
    }

    public final void zzcg(String str) {
        this.zzces.add(str);
    }

    public final void zzch(String str) {
        this.zzces.remove(str);
    }

    public final void zzci(String str) {
        this.zzcce = str;
    }

    public final void zzcj(String str) {
        this.zzccc = str;
    }

    public final void zzck(String str) {
        this.zzcci = str;
    }

    @Deprecated
    public final void zzcl(int i) {
        this.zzcbz = i;
    }

    public final void zzcl(String str) {
        this.zzcet.add(str);
    }

    @Deprecated
    public final void zzcm(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzabp = i;
        }
    }

    @Deprecated
    public final void zzcm(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzabq = str;
        }
    }

    public final void zze(String str, String str2) {
        this.zzccg.putString(str, str2);
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.zzabo = z ? 1 : 0;
    }
}

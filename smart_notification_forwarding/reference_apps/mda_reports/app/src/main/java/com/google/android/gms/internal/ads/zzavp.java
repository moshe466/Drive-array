package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzavp implements zzqj {
    private final zzavu zzdrk;

    @VisibleForTesting
    private final zzavl zzdrr;
    private final Object lock = new Object();

    @VisibleForTesting
    private final HashSet<zzavd> zzdrs = new HashSet<>();

    @VisibleForTesting
    private final HashSet<zzavm> zzdrt = new HashSet<>();
    private final zzavn zzdrq = new zzavn();

    public zzavp(String str, zzavu zzavuVar) {
        this.zzdrr = new zzavl(str, zzavuVar);
        this.zzdrk = zzavuVar;
    }

    public final Bundle zza(Context context, zzavk zzavkVar) {
        HashSet<zzavd> hashSet = new HashSet<>();
        synchronized (this.lock) {
            hashSet.addAll(this.zzdrs);
            this.zzdrs.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle(SettingsJsonConstants.APP_KEY, this.zzdrr.zzo(context, this.zzdrq.zzvq()));
        Bundle bundle2 = new Bundle();
        Iterator<zzavm> it = this.zzdrt.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<zzavd> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBundle());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzavkVar.zza(hashSet);
        return bundle;
    }

    public final zzavd zza(Clock clock, String str) {
        return new zzavd(clock, this, this.zzdrq.zzvp(), str);
    }

    public final void zza(zzug zzugVar, long j) {
        synchronized (this.lock) {
            this.zzdrr.zza(zzugVar, j);
        }
    }

    public final void zzb(zzavd zzavdVar) {
        synchronized (this.lock) {
            this.zzdrs.add(zzavdVar);
        }
    }

    public final void zzb(HashSet<zzavd> hashSet) {
        synchronized (this.lock) {
            this.zzdrs.addAll(hashSet);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zzp(boolean z) {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
        if (!z) {
            this.zzdrk.zzez(currentTimeMillis);
            this.zzdrk.zzcq(this.zzdrr.a);
            return;
        }
        if (currentTimeMillis - this.zzdrk.zzwb() > ((Long) zzve.zzoy().zzd(zzzn.zzcjc)).longValue()) {
            this.zzdrr.a = -1;
        } else {
            this.zzdrr.a = this.zzdrk.zzwc();
        }
    }

    public final void zzuv() {
        synchronized (this.lock) {
            this.zzdrr.zzuv();
        }
    }

    public final void zzuw() {
        synchronized (this.lock) {
            this.zzdrr.zzuw();
        }
    }
}

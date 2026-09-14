package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzahq {
    private final zzvn zzabd;
    private final Context zzup;

    private zzahq(Context context, zzvn zzvnVar) {
        this.zzup = context;
        this.zzabd = zzvnVar;
    }

    public zzahq(Context context, String str) {
        this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzve.zzov().zzb(context, str, new zzakz()));
    }

    public final zzahq zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzabd.zza(new zzaho(instreamAdLoadCallback));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzahq zza(zzahl zzahlVar) {
        try {
            this.zzabd.zza(new zzagz(zzahlVar));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzahn zzry() {
        try {
            return new zzahn(this.zzup, this.zzabd.zzpd());
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}

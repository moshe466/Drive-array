package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* loaded from: classes.dex */
public final class zzrp {

    @AppOpenAd.AppOpenAdOrientation
    private final int orientation;
    private final zzxj zzabc;
    private zzvu zzbqy;
    private final String zzbqz;
    private final AppOpenAd.AppOpenAdLoadCallback zzbra;
    private final Context zzup;
    private final zzakz zzbrb = new zzakz();
    private final zzuh zzaba = zzuh.zzccn;

    public zzrp(Context context, String str, zzxj zzxjVar, @AppOpenAd.AppOpenAdOrientation int i, AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzup = context;
        this.zzbqz = str;
        this.zzabc = zzxjVar;
        this.orientation = i;
        this.zzbra = appOpenAdLoadCallback;
    }

    public final void zzmn() {
        try {
            this.zzbqy = zzve.zzov().zza(this.zzup, zzuj.zzom(), this.zzbqz, this.zzbrb);
            this.zzbqy.zza(new zzuo(this.orientation));
            this.zzbqy.zza(new zzrd(this.zzbra));
            this.zzbqy.zza(zzuh.zza(this.zzup, this.zzabc));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }
}

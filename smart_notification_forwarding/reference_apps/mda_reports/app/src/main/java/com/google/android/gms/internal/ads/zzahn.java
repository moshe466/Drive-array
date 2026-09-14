package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

/* loaded from: classes.dex */
public final class zzahn {
    private final zzuh zzaba;
    private final zzvm zzabb;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzahn(Context context, zzvm zzvmVar) {
        this(context, zzvmVar, zzuh.zzccn);
    }

    private zzahn(Context context, zzvm zzvmVar, zzuh zzuhVar) {
        this.zzup = context;
        this.zzabb = zzvmVar;
        this.zzaba = zzuhVar;
    }

    private final void zza(zzxj zzxjVar) {
        try {
            this.zzabb.zzb(zzuh.zza(this.zzup, zzxjVar));
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdg());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdg());
    }
}

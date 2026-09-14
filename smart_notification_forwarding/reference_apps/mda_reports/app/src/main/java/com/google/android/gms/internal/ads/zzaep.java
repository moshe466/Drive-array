package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzaep extends zzadt {
    private final OnPublisherAdViewLoadedListener zzcwk;

    public zzaep(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzcwk = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final void zza(zzvu zzvuVar, IObjectWrapper iObjectWrapper) {
        if (zzvuVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
        try {
            if (zzvuVar.zzkd() instanceof zzuc) {
                zzuc zzucVar = (zzuc) zzvuVar.zzkd();
                publisherAdView.setAdListener(zzucVar != null ? zzucVar.getAdListener() : null);
            }
        } catch (RemoteException e) {
            zzayu.zzc("", e);
        }
        try {
            if (zzvuVar.zzkc() instanceof zzul) {
                zzul zzulVar = (zzul) zzvuVar.zzkc();
                publisherAdView.setAppEventListener(zzulVar != null ? zzulVar.getAppEventListener() : null);
            }
        } catch (RemoteException e2) {
            zzayu.zzc("", e2);
        }
        zzayk.zzyu.post(new zzaes(this, publisherAdView, zzvuVar));
    }
}

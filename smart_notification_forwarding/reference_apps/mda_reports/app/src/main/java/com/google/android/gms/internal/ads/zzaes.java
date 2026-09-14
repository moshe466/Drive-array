package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;

/* loaded from: classes.dex */
final class zzaes implements Runnable {
    private final /* synthetic */ PublisherAdView zzcwn;
    private final /* synthetic */ zzvu zzcwo;
    private final /* synthetic */ zzaep zzcwp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaes(zzaep zzaepVar, PublisherAdView publisherAdView, zzvu zzvuVar) {
        this.zzcwp = zzaepVar;
        this.zzcwn = publisherAdView;
        this.zzcwo = zzvuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener;
        if (!this.zzcwn.zza(this.zzcwo)) {
            zzayu.zzez("Could not bind.");
        } else {
            onPublisherAdViewLoadedListener = this.zzcwp.zzcwk;
            onPublisherAdViewLoadedListener.onPublisherAdViewLoaded(this.zzcwn);
        }
    }
}

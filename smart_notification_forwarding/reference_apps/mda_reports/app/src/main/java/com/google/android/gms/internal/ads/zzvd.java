package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

/* loaded from: classes.dex */
public class zzvd extends AdListener {
    private final Object lock = new Object();
    private AdListener zzcdq;

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzcdq != null) {
                this.zzcdq.onAdClosed();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzcdq != null) {
                this.zzcdq.onAdFailedToLoad(i);
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzcdq != null) {
                this.zzcdq.onAdLeftApplication();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzcdq != null) {
                this.zzcdq.onAdLoaded();
            }
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzcdq != null) {
                this.zzcdq.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzcdq = adListener;
        }
    }
}

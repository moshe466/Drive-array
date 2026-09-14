package com.google.android.gms.ads;

import android.content.Context;

public class InterstitialAd {
    private Context context;
    private String adUnitId;
    private AdListener adListener;
    private boolean isLoaded = false;

    public InterstitialAd(Context context) {
        this.context = context;
    }

    public void setAdUnitId(String adUnitId) {
        this.adUnitId = adUnitId;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public void setAdListener(AdListener adListener) {
        this.adListener = adListener;
    }

    public AdListener getAdListener() {
        return this.adListener;
    }

    public boolean isLoaded() {
        return this.isLoaded;
    }

    public boolean isLoading() {
        return false;
    }

    public void loadAd(AdRequest adRequest) {
        this.isLoaded = true;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    public void show() {
        if (adListener != null) {
            adListener.onAdOpened();
            adListener.onAdClosed();
        }
    }
}

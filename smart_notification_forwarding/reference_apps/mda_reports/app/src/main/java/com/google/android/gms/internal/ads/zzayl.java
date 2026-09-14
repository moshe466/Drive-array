package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

/* loaded from: classes.dex */
public final class zzayl {
    private final View view;
    private boolean zzbnz;
    private boolean zzbsd;
    private Activity zzdvo;
    private boolean zzdvp;
    private ViewTreeObserver.OnGlobalLayoutListener zzdvq;
    private ViewTreeObserver.OnScrollChangedListener zzdvr = null;

    public zzayl(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzdvo = activity;
        this.view = view;
        this.zzdvq = onGlobalLayoutListener;
    }

    private static ViewTreeObserver zzi(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void zzxi() {
        ViewTreeObserver zzi;
        if (this.zzdvp) {
            return;
        }
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzdvq;
        if (onGlobalLayoutListener != null) {
            Activity activity = this.zzdvo;
            if (activity != null && (zzi = zzi(activity)) != null) {
                zzi.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            com.google.android.gms.ads.internal.zzq.zzln();
            zzazt.zza(this.view, this.zzdvq);
        }
        this.zzdvp = true;
    }

    private final void zzxj() {
        ViewTreeObserver zzi;
        Activity activity = this.zzdvo;
        if (activity != null && this.zzdvp) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzdvq;
            if (onGlobalLayoutListener != null && (zzi = zzi(activity)) != null) {
                com.google.android.gms.ads.internal.zzq.zzks();
                zzi.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzdvp = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzbnz = true;
        if (this.zzbsd) {
            zzxi();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbnz = false;
        zzxj();
    }

    public final void zzh(Activity activity) {
        this.zzdvo = activity;
    }

    public final void zzxg() {
        this.zzbsd = true;
        if (this.zzbnz) {
            zzxi();
        }
    }

    public final void zzxh() {
        this.zzbsd = false;
        zzxj();
    }
}

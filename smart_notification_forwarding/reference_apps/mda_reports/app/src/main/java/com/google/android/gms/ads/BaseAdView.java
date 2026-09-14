package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzty;
import com.google.android.gms.internal.ads.zzxl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class BaseAdView extends ViewGroup {
    protected final zzxl a;

    public BaseAdView(Context context, int i) {
        super(context);
        this.a = new zzxl(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.a = new zzxl(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.a = new zzxl(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.a.destroy();
    }

    public AdListener getAdListener() {
        return this.a.getAdListener();
    }

    public AdSize getAdSize() {
        return this.a.getAdSize();
    }

    public String getAdUnitId() {
        return this.a.getAdUnitId();
    }

    public String getMediationAdapterClassName() {
        return this.a.getMediationAdapterClassName();
    }

    public boolean isLoading() {
        return this.a.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.a.zza(adRequest.zzdg());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzayu.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }

    public void pause() {
        this.a.pause();
    }

    public void resume() {
        this.a.resume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        this.a.setAdListener(adListener);
        if (adListener == 0) {
            this.a.zza((zzty) null);
            this.a.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zzty) {
            this.a.zza((zzty) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.a.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.a.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.a.setAdUnitId(str);
    }
}

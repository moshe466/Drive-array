package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.internal.ads.zzabt;
import com.google.android.gms.internal.ads.zzabv;

/* loaded from: classes.dex */
public class MediaView extends FrameLayout {
    private UnifiedNativeAd.MediaContent zzbjp;
    private boolean zzbjq;
    private zzabt zzbjr;
    private ImageView.ScaleType zzbjs;
    private boolean zzbjt;
    private zzabv zzbju;

    public MediaView(Context context) {
        super(context);
    }

    public MediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public MediaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(zzabt zzabtVar) {
        this.zzbjr = zzabtVar;
        if (this.zzbjq) {
            zzabtVar.setMediaContent(this.zzbjp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(zzabv zzabvVar) {
        this.zzbju = zzabvVar;
        if (this.zzbjt) {
            zzabvVar.setImageScaleType(this.zzbjs);
        }
    }

    public void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbjt = true;
        this.zzbjs = scaleType;
        zzabv zzabvVar = this.zzbju;
        if (zzabvVar != null) {
            zzabvVar.setImageScaleType(this.zzbjs);
        }
    }

    public void setMediaContent(UnifiedNativeAd.MediaContent mediaContent) {
        this.zzbjq = true;
        this.zzbjp = mediaContent;
        zzabt zzabtVar = this.zzbjr;
        if (zzabtVar != null) {
            zzabtVar.setMediaContent(mediaContent);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcab extends zzacz {

    @Nullable
    private final String zzfge;
    private final zzbws zzfkc;
    private final zzbwk zzfnf;

    public zzcab(@Nullable String str, zzbwk zzbwkVar, zzbws zzbwsVar) {
        this.zzfge = str;
        this.zzfnf = zzbwkVar;
        this.zzfkc = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void destroy() {
        this.zzfnf.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final String getAdvertiser() {
        return this.zzfkc.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final String getBody() {
        return this.zzfkc.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final String getCallToAction() {
        return this.zzfkc.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final Bundle getExtras() {
        return this.zzfkc.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final String getHeadline() {
        return this.zzfkc.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final List<?> getImages() {
        return this.zzfkc.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final String getMediationAdapterClassName() {
        return this.zzfge;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final zzxb getVideoController() {
        return this.zzfkc.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void performClick(Bundle bundle) {
        this.zzfnf.zzf(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean recordImpression(Bundle bundle) {
        return this.zzfnf.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void reportTouchEvent(Bundle bundle) {
        this.zzfnf.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final IObjectWrapper zzrf() {
        return ObjectWrapper.wrap(this.zzfnf);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final zzaca zzrh() {
        return this.zzfkc.zzrh();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final IObjectWrapper zzri() {
        return this.zzfkc.zzri();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final zzaci zzrj() {
        return this.zzfkc.zzrj();
    }
}

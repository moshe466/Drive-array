package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcad extends zzadd {
    private final zzbws zzfkc;
    private final zzbwk zzfnf;
    private final zzbxj zzfqd;
    private final Context zzyv;

    public zzcad(Context context, zzbws zzbwsVar, zzbxj zzbxjVar, zzbwk zzbwkVar) {
        this.zzyv = context;
        this.zzfkc = zzbwsVar;
        this.zzfqd = zzbxjVar;
        this.zzfnf = zzbwkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void destroy() {
        this.zzfnf.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final List<String> getAvailableAssetNames() {
        SimpleArrayMap<String, zzabu> zzaji = this.zzfkc.zzaji();
        SimpleArrayMap<String, String> zzajk = this.zzfkc.zzajk();
        String[] strArr = new String[zzaji.size() + zzajk.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzaji.size()) {
            strArr[i3] = zzaji.keyAt(i2);
            i2++;
            i3++;
        }
        while (i < zzajk.size()) {
            strArr[i3] = zzajk.keyAt(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final String getCustomTemplateId() {
        return this.zzfkc.getCustomTemplateId();
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final zzxb getVideoController() {
        return this.zzfkc.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void performClick(String str) {
        this.zzfnf.zzfu(str);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void recordImpression() {
        this.zzfnf.zzaio();
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final String zzct(String str) {
        return this.zzfkc.zzajk().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final zzaci zzcu(String str) {
        return this.zzfkc.zzaji().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || !this.zzfqd.zza((ViewGroup) unwrap)) {
            return false;
        }
        this.zzfkc.zzajf().zza(new zzcag(this));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void zzq(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzfkc.zzajh() != null) {
            this.zzfnf.zzz((View) unwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final IObjectWrapper zzrf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final IObjectWrapper zzrk() {
        return ObjectWrapper.wrap(this.zzyv);
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final boolean zzrl() {
        return this.zzfnf.zzaiw() && this.zzfkc.zzajg() != null && this.zzfkc.zzajf() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final boolean zzrm() {
        IObjectWrapper zzajh = this.zzfkc.zzajh();
        if (zzajh != null) {
            com.google.android.gms.ads.internal.zzq.zzlf().zzab(zzajh);
            return true;
        }
        zzayu.zzez("Trying to start OMID session before creation.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void zzrn() {
        String zzajj = this.zzfkc.zzajj();
        if ("Google".equals(zzajj)) {
            zzayu.zzez("Illegal argument specified for omid partner name.");
        } else {
            this.zzfnf.zzg(zzajj, false);
        }
    }
}

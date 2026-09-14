package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzcak implements zzafn<Object> {
    private final zzdxa<zzcad> zzfln;
    private final zzcaj zzfnx;

    @Nullable
    private final zzado zzfqi;

    public zzcak(zzbwz zzbwzVar, zzbws zzbwsVar, zzcaj zzcajVar, zzdxa<zzcad> zzdxaVar) {
        this.zzfqi = zzbwzVar.zzga(zzbwsVar.getCustomTemplateId());
        this.zzfnx = zzcajVar;
        this.zzfln = zzdxaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("asset");
        try {
            this.zzfqi.zza(this.zzfln.get(), str);
        } catch (RemoteException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzayu.zzd(sb.toString(), e);
        }
    }

    public final void zzakr() {
        if (this.zzfqi == null) {
            return;
        }
        this.zzfnx.zza("/nativeAdCustomClick", this);
    }
}

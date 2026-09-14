package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzcqe implements zzcty<Bundle> {
    private final String zzabg;
    private final zzuj zzblm;
    private final float zzboh;
    private final boolean zzccq;
    private final int zzdgf;
    private final int zzdgg;
    private final String zzgep;
    private final String zzgeq;

    public zzcqe(zzuj zzujVar, String str, boolean z, String str2, float f, int i, int i2, String str3) {
        Preconditions.checkNotNull(zzujVar, "the adSize must not be null");
        this.zzblm = zzujVar;
        this.zzabg = str;
        this.zzccq = z;
        this.zzgep = str2;
        this.zzboh = f;
        this.zzdgf = i;
        this.zzdgg = i2;
        this.zzgeq = str3;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdaa.zza(bundle2, "smart_w", "full", this.zzblm.width == -1);
        zzdaa.zza(bundle2, "smart_h", "auto", this.zzblm.height == -2);
        zzdaa.zza(bundle2, "ene", (Boolean) true, this.zzblm.zzccr);
        zzdaa.zza(bundle2, "rafmt", "102", this.zzblm.zzccu);
        zzdaa.zza(bundle2, "rafmt", "103", this.zzblm.zzccv);
        zzdaa.zza(bundle2, "format", this.zzabg);
        zzdaa.zza(bundle2, "fluid", SettingsJsonConstants.ICON_HEIGHT_KEY, this.zzccq);
        zzdaa.zza(bundle2, "sz", this.zzgep, !TextUtils.isEmpty(r0));
        bundle2.putFloat("u_sd", this.zzboh);
        bundle2.putInt("sw", this.zzdgf);
        bundle2.putInt("sh", this.zzdgg);
        String str = this.zzgeq;
        zzdaa.zza(bundle2, "sc", str, true ^ TextUtils.isEmpty(str));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        zzuj[] zzujVarArr = this.zzblm.zzccp;
        if (zzujVarArr == null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt(SettingsJsonConstants.ICON_HEIGHT_KEY, this.zzblm.height);
            bundle3.putInt(SettingsJsonConstants.ICON_WIDTH_KEY, this.zzblm.width);
            bundle3.putBoolean("is_fluid_height", this.zzblm.zzccq);
            arrayList.add(bundle3);
        } else {
            for (zzuj zzujVar : zzujVarArr) {
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("is_fluid_height", zzujVar.zzccq);
                bundle4.putInt(SettingsJsonConstants.ICON_HEIGHT_KEY, zzujVar.height);
                bundle4.putInt(SettingsJsonConstants.ICON_WIDTH_KEY, zzujVar.width);
                arrayList.add(bundle4);
            }
        }
        bundle2.putParcelableArrayList("valid_ad_sizes", arrayList);
    }
}

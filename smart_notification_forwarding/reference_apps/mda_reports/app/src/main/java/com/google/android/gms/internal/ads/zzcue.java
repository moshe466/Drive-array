package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzcue implements zzcty<Bundle> {
    private final boolean zzdmx;
    private final boolean zzdmy;
    private final String zzdmz;
    private final boolean zzdna;
    private final boolean zzdnb;
    private final boolean zzdnc;
    private final String zzdnd;
    private final String zzdne;
    private final String zzdnf;
    private final boolean zzdng;
    private final ArrayList<String> zzghc;
    private final String zzghd;
    private final String zzghe;
    private final long zzghf;

    public zzcue(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, ArrayList<String> arrayList, @Nullable String str3, @Nullable String str4, String str5, boolean z6, String str6, long j) {
        this.zzdmx = z;
        this.zzdmy = z2;
        this.zzdmz = str;
        this.zzdna = z3;
        this.zzdnb = z4;
        this.zzdnc = z5;
        this.zzdnd = str2;
        this.zzghc = arrayList;
        this.zzdne = str3;
        this.zzdnf = str4;
        this.zzghd = str5;
        this.zzdng = z6;
        this.zzghe = str6;
        this.zzghf = j;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("cog", this.zzdmx);
        bundle2.putBoolean("coh", this.zzdmy);
        bundle2.putString("gl", this.zzdmz);
        bundle2.putBoolean("simulator", this.zzdna);
        bundle2.putBoolean("is_latchsky", this.zzdnb);
        bundle2.putBoolean("is_sidewinder", this.zzdnc);
        bundle2.putString("hl", this.zzdnd);
        if (!this.zzghc.isEmpty()) {
            bundle2.putStringArrayList("hl_list", this.zzghc);
        }
        bundle2.putString("mv", this.zzdne);
        bundle2.putString("submodel", this.zzghe);
        Bundle zza = zzdaa.zza(bundle2, "device");
        bundle2.putBundle("device", zza);
        zza.putString("build", this.zzghd);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzclt)).booleanValue()) {
            zza.putLong("remaining_data_partition_space", this.zzghf);
        }
        Bundle zza2 = zzdaa.zza(zza, "browser");
        zza.putBundle("browser", zza2);
        zza2.putBoolean("is_browser_custom_tabs_capable", this.zzdng);
        if (TextUtils.isEmpty(this.zzdnf)) {
            return;
        }
        Bundle zza3 = zzdaa.zza(zza, "play_store");
        zza.putBundle("play_store", zza3);
        zza3.putString("package_version", this.zzdnf);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzatn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatn> CREATOR = new zzatm();

    @SafeParcelable.Field(id = 2)
    public final String zzdos;

    @SafeParcelable.Field(id = 3)
    public final String zzdot;

    @SafeParcelable.Field(id = 4)
    public final boolean zzdou;

    @SafeParcelable.Field(id = 5)
    public final boolean zzdov;

    @SafeParcelable.Field(id = 6)
    public final List<String> zzdow;

    @SafeParcelable.Field(id = 7)
    public final boolean zzdox;

    @SafeParcelable.Field(id = 8)
    public final boolean zzdoy;

    @SafeParcelable.Field(id = 9)
    public final List<String> zzdoz;

    @SafeParcelable.Constructor
    public zzatn(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) List<String> list, @SafeParcelable.Param(id = 7) boolean z3, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) List<String> list2) {
        this.zzdos = str;
        this.zzdot = str2;
        this.zzdou = z;
        this.zzdov = z2;
        this.zzdow = list;
        this.zzdox = z3;
        this.zzdoy = z4;
        this.zzdoz = list2 == null ? new ArrayList<>() : list2;
    }

    @Nullable
    public static zzatn zzg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new zzatn(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzaxs.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzaxs.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdos, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdot, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdou);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdov);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdow, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdox);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdoy);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdoz, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

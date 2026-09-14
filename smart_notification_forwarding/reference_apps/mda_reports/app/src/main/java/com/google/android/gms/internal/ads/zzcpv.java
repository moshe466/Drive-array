package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.List;

/* loaded from: classes.dex */
public final class zzcpv implements zzcty<Bundle> {
    private final zzuj zzblm;
    private final List<Parcelable> zzgel;
    private final Context zzup;

    public zzcpv(Context context, zzuj zzujVar, List<Parcelable> list) {
        this.zzup = context;
        this.zzblm = zzujVar;
        this.zzgel = list;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzabb.zzctv.get().booleanValue()) {
            Bundle bundle3 = new Bundle();
            com.google.android.gms.ads.internal.zzq.zzkq();
            bundle3.putString("activity", zzawb.zzat(this.zzup));
            Bundle bundle4 = new Bundle();
            bundle4.putInt(SettingsJsonConstants.ICON_WIDTH_KEY, this.zzblm.width);
            bundle4.putInt(SettingsJsonConstants.ICON_HEIGHT_KEY, this.zzblm.height);
            bundle3.putBundle("size", bundle4);
            if (this.zzgel.size() > 0) {
                List<Parcelable> list = this.zzgel;
                bundle3.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle2.putBundle("view_hierarchy", bundle3);
        }
    }
}

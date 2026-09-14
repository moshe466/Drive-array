package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

/* loaded from: classes.dex */
public class RtbSignalData {
    private final Bundle zzccf;

    @Nullable
    private final AdSize zzdi;
    private final List<MediationConfiguration> zzejo;
    private final Context zzup;

    public RtbSignalData(Context context, List<MediationConfiguration> list, Bundle bundle, @Nullable AdSize adSize) {
        this.zzup = context;
        this.zzejo = list;
        this.zzccf = bundle;
        this.zzdi = adSize;
    }

    @Nullable
    public AdSize getAdSize() {
        return this.zzdi;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzejo;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.zzejo.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.zzejo;
    }

    public Context getContext() {
        return this.zzup;
    }

    public Bundle getNetworkExtras() {
        return this.zzccf;
    }
}

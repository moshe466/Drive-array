package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes.dex */
final class zzavt extends zzavo {
    private Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavt(Context context) {
        this.zzup = context;
    }

    @Override // com.google.android.gms.internal.ads.zzavo
    public final void zztu() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zzup);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzayu.zzc("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzayo.zzar(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzayu.zzez(sb.toString());
    }
}
